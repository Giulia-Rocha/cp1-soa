# 📄 Guia: Abordagem Contract-First com JAX-WS

## O que é Contract-First?

Em JAX-WS existem duas abordagens para criar um serviço SOAP:

```
CONTRACT-LAST (Code-First)        CONTRACT-FIRST (WSDL-First)
─────────────────────────         ────────────────────────────
1. Você escreve o Java             1. Você escreve o WSDL
2. wsgen gera o WSDL               2. wsimport gera o Java
3. WSDL muda se o código mudar     3. Código muda se o WSDL mudar
   ↑ frágil para integrações          ↑ contrato estável
```

> **Este projeto implementou ambas:**
> - O servidor usa **contract-last** (código gera WSDL via wsgen) — mais simples para começar
> - O arquivo `RastreamentoLogistico.wsdl` demonstra como seria o **contract-first** equivalente

---

## Estrutura do WSDL (5 seções obrigatórias)

```
definitions
│
├── types          → XSD: define os tipos de dados (Pedido, Endereco, enums...)
│
├── message        → Associa elementos XSD a mensagens nomeadas (input/output/fault)
│
├── portType       → Interface abstrata: lista as operações e quais mensagens usam
│                    (independente de protocolo — sem SOAP aqui)
│
├── binding        → Como transportar: SOAP 1.1, estilo DOCUMENT, uso LITERAL
│
└── service        → Endereço físico (URL) onde o serviço está disponível
```

---

## Por que DOCUMENT/LITERAL?

O WSDL usa `style="document"` e `use="literal"`. Esta é a combinação recomendada pelo **WS-I Basic Profile 1.1** por três razões:

1. **Validável por XSD**: o corpo SOAP é um elemento XML definido no schema, portanto pode ser validado automaticamente.
2. **Interoperável**: funciona com Java, .NET, Python, PHP sem problemas.
3. **Sem ambiguidade de tipos**: ao contrário do `rpc/encoded`, cada elemento tem tipo explícito no XSD.

---

## Como usar este WSDL no projeto

### Opção A — Servidor gera código a partir do WSDL (verdadeiro contract-first)

```bash
# 1. Copie o WSDL para WEB-INF/wsdl/
cp src/main/resources/wsdl/RastreamentoLogistico.wsdl src/main/webapp/WEB-INF/wsdl/

# 2. Gere as classes Java a partir do WSDL
wsimport -keep -verbose \
         -d src/main/java \
         -p br.com.logistica.generated \
         src/main/webapp/WEB-INF/wsdl/RastreamentoLogistico.wsdl

# 3. Implemente a interface gerada
# wsimport cria: RastreamentoLogistico.java (interface)
# Você implementa: RastreamentoLogisticoImpl.java
```

### Opção B — Referenciar o WSDL local no endpoint (anotação)

```java
@WebService(
    endpointInterface = "br.com.logistica.generated.RastreamentoLogistico",
    wsdlLocation      = "WEB-INF/wsdl/RastreamentoLogistico.wsdl",   // ← WSDL fixo
    targetNamespace   = "http://logistica.com/ws",
    serviceName       = "RastreamentoLogisticoService",
    portName          = "RastreamentoLogisticoPort"
)
public class RastreamentoEndpoint implements RastreamentoLogistico {
    // implementação...
}
```

### Opção C — Cliente usa o WSDL local (sem precisar do servidor no ar)

```xml
<!-- soap-client/pom.xml -->
<wsdlFiles>
    <wsdlFile>${project.basedir}/src/main/resources/wsdl/RastreamentoLogistico.wsdl</wsdlFile>
</wsdlFiles>
```

Isso permite que o cliente seja compilado **sem o servidor estar em execução**, útil em pipelines de CI/CD.

---

## Diferenças práticas no WSDL gerado vs manual

| Aspecto | Contract-Last (wsgen) | Contract-First (manual) |
|---|---|---|
| Nomes de elementos | Derivados das anotações Java | Você define livremente |
| Validação de CEP | Não tem | `<xsd:pattern value="\d{5}-?\d{3}"/>` |
| Restrição de UF | Não tem | `<xsd:length value="2"/>` |
| Enum no XSD | Simples `xsd:string` | `xsd:restriction` com valores válidos |
| Contrato estável | ❌ Muda com refatoração | ✅ Independente do código |

---

## Validações XSD presentes neste WSDL

```xml
<!-- Estado com exatamente 2 letras maiúsculas -->
<xsd:restriction base="xsd:string">
    <xsd:length value="2"/>
    <xsd:pattern value="[A-Z]{2}"/>
</xsd:restriction>

<!-- CEP: 00000-000 ou 00000000 -->
<xsd:restriction base="xsd:string">
    <xsd:pattern value="\d{5}-?\d{3}"/>
</xsd:restriction>

<!-- Enum de status com valores controlados -->
<xsd:restriction base="xsd:string">
    <xsd:enumeration value="AGUARDANDO_COLETA"/>
    <xsd:enumeration value="EM_TRANSITO"/>
    <!-- ... -->
</xsd:restriction>
```

Essas restrições são validadas automaticamente pelo runtime JAX-WS antes mesmo de chegar ao seu código Java.

---

## Onde colocar o arquivo no projeto

```
soap-server/
└── src/
    └── main/
        ├── resources/
        │   └── wsdl/
        │       └── RastreamentoLogistico.wsdl   ← desenvolvimento
        └── webapp/
            └── WEB-INF/
                └── wsdl/
                    └── RastreamentoLogistico.wsdl ← deploy WAR
```
