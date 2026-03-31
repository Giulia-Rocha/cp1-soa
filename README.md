# 🚚 Logística SOAP — Java 21 + JAX-WS

Sistema de rastreamento logístico com publicação e consumo de API SOAP.

## Estrutura

```
logistica-soap/
├── soap-server/   → Publica o serviço SOAP (JAX-WS standalone)
├── soap-client/   → Consome o serviço SOAP (stubs gerados por wsimport)
└── docs/          → Documentação completa (README.md)
```

## Quick Start

```bash
# 1. Sobe o servidor (terminal 1)
cd soap-server && mvn clean compile
mvn exec:java -Dexec.mainClass="br.com.logistica.config.ServidorSoap"

# 2. Gera stubs e roda o cliente (terminal 2)
cd soap-client && mvn clean generate-sources
mvn exec:java -Dexec.mainClass="br.com.logistica.client.ClienteLogisticaMain"
```

**WSDL:** http://localhost:8080/logistica/rastreamento?wsdl

📄 Veja `docs/README.md` para documentação completa.
