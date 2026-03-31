# 🚚 Sistema de Rastreamento Logístico — API SOAP com JAX-WS (Java 21)

> Trabalho acadêmico — Desenvolvimento de API SOAP (publicação + consumo)

---

## 📋 Índice

1. [Contexto de Implantação](#contexto-de-implantação)
2. [Problemas Resolvidos](#problemas-resolvidos)
3. [Arquitetura do Sistema](#arquitetura-do-sistema)
4. [Operações Disponíveis](#operações-disponíveis)
5. [Boas Práticas Aplicadas](#boas-práticas-aplicadas)
6. [Como Executar](#como-executar)
7. [Testando com SoapUI](#testando-com-soapui)
8. [Próximas Features](#próximas-features)
9. [Tecnologias Utilizadas](#tecnologias-utilizadas)

---

## 🌍 Contexto de Implantação

### Cenário Real

Transportadoras e e-commerces precisam integrar seus sistemas para que o consumidor final acompanhe o status das entregas em tempo real. Empresas como Correios, Jadlog e Sequoia já utilizam ou utilizaram APIs SOAP para essa finalidade, pois o protocolo oferece **contrato formal via WSDL**, garantindo que ambas as pontas (publicador e consumidor) concordem com o formato das mensagens.

### Por que SOAP neste cenário?

| Critério | SOAP | REST |
|---|---|---|
| Contrato formal | ✅ WSDL | ❌ Apenas informal (OpenAPI é opcional) |
| Tipagem forte | ✅ XSD Schema | ⚠️ Depende do JSON Schema |
| WS-Security nativo | ✅ | ❌ |
| Maturidade em legado | ✅ Altíssima | ⚠️ Baixa em sistemas antigos |
| Simplicidade | ⚠️ Verboso | ✅ |

**Conclusão:** Para integração com sistemas legados e onde a garantia de contrato é crítica (setor logístico, financeiro, saúde), SOAP ainda é a escolha mais robusta.

### Ambiente de Implantação

```
┌─────────────────┐        SOAP/HTTPS         ┌──────────────────────┐
│  E-commerce /   │ ────────────────────────▶  │  soap-server (WAR)   │
│  App Mobile     │ ◀────────────────────────  │  WildFly / Payara    │
│  (soap-client)  │      XML Response          │  Jakarta EE 10       │
└─────────────────┘                            └──────────────────────┘
                                                         │
                                                         ▼
                                               ┌──────────────────────┐
                                               │  Banco de Dados       │
                                               │  PostgreSQL / Oracle  │
                                               └──────────────────────┘
```

---

## 🔧 Problemas Resolvidos

### 1. Falta de Padronização na Troca de Dados
**Problema:** Diferentes transportadoras usam formatos proprietários incompatíveis.  
**Solução:** WSDL gerado automaticamente define o contrato: tipos, operações e namespaces são declarados explicitamente via XSD.

### 2. Ausência de Rastreamento em Tempo Real
**Problema:** Clientes ligam para saber status de pedidos, sobrecarregando o SAC.  
**Solução:** Operação `rastrearPedido` com histórico completo de eventos, disponível 24/7 via serviço SOAP.

### 3. Erros Silenciosos nas Integrações
**Problema:** Quando a integração falha, não há informação estruturada sobre o erro.  
**Solução:** `LogisticaException` anotada com `@WebFault` gera SOAP Faults estruturados com código de erro, mensagem amigável e detalhes técnicos.

### 4. Cálculo Manual de Fretes
**Problema:** Operadores calculavam fretes manualmente, gerando inconsistências.  
**Solução:** Operação `calcularFrete` centraliza a regra de negócio, garantindo cálculo consistente para todos os consumidores.

---

## 🏗️ Arquitetura do Sistema

```
soap-server/
├── model/
│   ├── Pedido.java              ← Entidade principal (JAXB anotada)
│   ├── Endereco.java            ← Tipo complexo para XSD
│   ├── EventoRastreamento.java  ← Histórico de eventos
│   └── StatusPedido.java        ← Enum de status
├── repository/
│   └── PedidoRepository.java   ← Persistência (Singleton thread-safe)
├── service/
│   └── RastreamentoService.java ← Lógica de negócio
├── endpoint/
│   └── RastreamentoEndpoint.java← SEI + SIB JAX-WS (expõe o serviço)
├── exception/
│   └── LogisticaException.java  ← SOAP Fault customizado
└── config/
    └── ServidorSoap.java        ← Publisher standalone

soap-client/
├── client/
│   ├── generated/               ← Stubs gerados pelo wsimport
│   └── ClienteLogisticaMain.java← Demo de todas as operações
└── service/
    └── LogisticaClienteService.java ← Wrapper do proxy
```

---

## 📡 Operações Disponíveis

| # | Operação | Descrição | Parâmetros principais |
|---|---|---|---|
| 1 | `criarPedido` | Registra novo pedido, retorna código de rastreio | remetente, destinatário, endereços, peso |
| 2 | `rastrearPedido` | Consulta status atual e histórico completo | codigoRastreio |
| 3 | `atualizarStatus` | Atualiza status e registra evento no histórico | codigoRastreio, novoStatus, localidade |
| 4 | `cancelarPedido` | Cancela pedido (se não entregue) | codigoRastreio, motivo |
| 5 | `calcularFrete` | Calcula valor estimado do frete | pesoKg, estadoOrigem, estadoDestino |
| 6 | `listarPedidos` | Lista todos os pedidos cadastrados | — |

### SOAP Faults (Erros tratados)

| Código | Situação |
|---|---|
| LOG-001 | Pedido não encontrado |
| LOG-002 | Código de rastreio inválido/vazio |
| LOG-003 | Tentativa de alterar pedido já entregue |
| LOG-004 | Tentativa de alterar pedido cancelado |
| LOG-005 | Dados obrigatórios ausentes ou inválidos |

---

## ✅ Boas Práticas Aplicadas

### 1. Separação em Camadas (Responsabilidade Única)
- `Endpoint` → só recebe/responde chamadas SOAP e delega
- `Service` → contém toda a lógica de negócio e validações
- `Repository` → gerencia o estado dos pedidos
- `Model` → POJOs anotados com JAXB para serialização XML

### 2. SOAP Binding DOCUMENT/LITERAL (WS-I Basic Profile)
```java
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
```
Mais interoperável que RPC/ENCODED; compatível com .NET, Python, PHP.

### 3. SOAP Faults Estruturados
```java
@WebFault(name = "LogisticaFault", targetNamespace = "http://logistica.com/ws")
public class LogisticaException extends Exception { ... }
```
Erros semânticos, rastreáveis e documentados no WSDL.

### 4. Nomes Explícitos no WSDL
```java
@WebParam(name = "codigoRastreio")
@WebResult(name = "pedido", targetNamespace = "http://logistica.com/ws")
```
Sem nomes genéricos como `arg0`, `arg1` no WSDL gerado.

### 5. Thread-Safety com ConcurrentHashMap
Repositório usa `ConcurrentHashMap` para suportar múltiplas requisições simultâneas sem race conditions.

### 6. Logging de Auditoria
Cada operação loga remetente/destinatário/código para rastreabilidade de chamadas.

### 7. Builder Pattern no Model
```java
Pedido.builder()
    .codigoRastreio("LOG001")
    .nomeRemetente("Loja X")
    .build();
```
Evita construtores com muitos parâmetros; código legível e menos propenso a erros.

### 8. Enum com Descrição Legível
`StatusPedido` carrega tanto o nome técnico quanto a descrição amigável para o usuário final.

---

## ▶️ Como Executar

### Pré-requisitos
- Java 21+
- Maven 3.9+

### 1. Iniciar o Servidor

```bash
cd soap-server
mvn clean compile
mvn exec:java -Dexec.mainClass="br.com.logistica.config.ServidorSoap"
```

**Saída esperada:**
```
✅ Serviço publicado com sucesso!
📍 URL do Serviço : http://localhost:8080/logistica/rastreamento
📄 WSDL           : http://localhost:8080/logistica/rastreamento?wsdl
```

### 2. Gerar Stubs do Cliente (wsimport)

```bash
cd soap-client
mvn clean generate-sources
```

### 3. Executar o Cliente

```bash
mvn exec:java -Dexec.mainClass="br.com.logistica.client.ClienteLogisticaMain"
```

### Pedidos pré-carregados para teste

| Código | Status |
|---|---|
| LOG2024001 | Em Trânsito |
| LOG2024002 | Entregue |
| LOG2024003 | Saiu para Entrega |

---

## 🧪 Testando com SoapUI

1. Abra o SoapUI e crie novo projeto SOAP
2. WSDL URL: `http://localhost:8080/logistica/rastreamento?wsdl`
3. O SoapUI gera automaticamente requests de exemplo para cada operação

**Exemplo de request `rastrearPedido`:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ws="http://logistica.com/ws">
   <soapenv:Body>
      <ws:rastrearPedido>
         <codigoRastreio>LOG2024001</codigoRastreio>
      </ws:rastrearPedido>
   </soapenv:Body>
</soapenv:Envelope>
```

---

## 🚀 Próximas Features

### Curto Prazo
- [ ] **WS-Security**: Autenticação via UsernameToken nos headers SOAP
- [ ] **Persistência real**: Substituir repositório em memória por JPA + PostgreSQL
- [ ] **Testes unitários**: JUnit 5 + Mockito para `RastreamentoService`
- [ ] **Notificações**: Envio de e-mail/SMS ao atualizar status

### Médio Prazo
- [ ] **Paginação** na operação `listarPedidos`
- [ ] **Versionamento do WSDL**: `/v1/rastreamento` e `/v2/rastreamento`
- [ ] **Deploy em WildFly/Payara**: WAR com `web.xml` configurado
- [ ] **Dashboard Admin**: Interface web para visualizar pedidos

### Longo Prazo
- [ ] **Migração gradual para REST**: API REST paralela para novos clientes, mantendo SOAP para legados
- [ ] **Event sourcing**: Persistir todos os eventos para auditoria completa
- [ ] **Rate limiting**: Proteção contra abuso das operações

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia              | Versão | Uso |
|-------------------------|---|---|
| Java                    | 21 | Linguagem principal |
| JAX-WS (Jakarta XML WS) | 4.0 | Publicação e consumo SOAP |
| Jakarta EE              | 10.0 | Plataforma base |
| JAXB                    | 4.0 | Serialização XML |
| Maven                   | 3.9+ | Build e gerenciamento de dependências |
| wsimport                | 4.0 | Geração de stubs do cliente |
| wsgen                   | 4.0 | Geração do WSDL a partir do código |
| Postman                 | 5.7+ | Testes manuais das operações |

---

## 👥 Grupo

| Nome | Responsabilidade |
|---|---|
| Membro 1 | Modelo de dados (Pedido, Endereco, EventoRastreamento) |
| Membro 2 | Repository e dados de teste |
| Membro 3 | Service layer e regras de negócio |
| Membro 4 | Endpoint JAX-WS e SOAP Faults |
| Membro 5 | Cliente (wsimport + ClienteLogisticaMain) |
| Membro 6 | Documentação, README e vídeo explicativo |

---

*Desenvolvido para a disciplina de Integração de Sistemas — Java 21 + JAX-WS*
