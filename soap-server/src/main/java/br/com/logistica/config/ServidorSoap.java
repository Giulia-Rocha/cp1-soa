package br.com.logistica.config;

import br.com.logistica.endpoint.RastreamentoEndpoint;
import jakarta.xml.ws.Endpoint;

/**
 * Publicador standalone do serviço SOAP usando o servidor HTTP embutido do JAX-WS.
 *
 * Uso: executa diretamente via 'java -cp ...' ou 'mvn exec:java'
 * URL do serviço: http://localhost:8080/logistica/rastreamento
 * WSDL:           http://localhost:8080/logistica/rastreamento?wsdl
 *
 * NOTA: Para produção, o deploy seria feito em um servidor
 * Jakarta EE (WildFly, GlassFish, Payara) ou via WAR/EAR.
 */
public class ServidorSoap {

    private static final String URL = "http://localhost:8080/logistica/rastreamento";

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║     SISTEMA LOGÍSTICO - SERVIDOR SOAP JAX-WS       ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.println();

        Endpoint endpoint = Endpoint.publish(URL, new RastreamentoEndpoint());

        System.out.println("✅ Serviço publicado com sucesso!");
        System.out.println("📍 URL do Serviço : " + URL);
        System.out.println("📄 WSDL           : " + URL + "?wsdl");
        System.out.println();
        System.out.println("Operações disponíveis:");
        System.out.println("  1. criarPedido      - Registra um novo pedido");
        System.out.println("  2. rastrearPedido   - Consulta status e histórico");
        System.out.println("  3. atualizarStatus  - Atualiza status do pedido");
        System.out.println("  4. cancelarPedido   - Cancela um pedido");
        System.out.println("  5. calcularFrete    - Calcula valor do frete");
        System.out.println("  6. listarPedidos    - Lista todos os pedidos");
        System.out.println();
        System.out.println("Pedidos pré-carregados para teste:");
        System.out.println("  LOG2024001 - Em Trânsito");
        System.out.println("  LOG2024002 - Entregue");
        System.out.println("  LOG2024003 - Saiu para Entrega");
        System.out.println();
        System.out.println("Pressione CTRL+C para encerrar o servidor...");

        // Mantém o servidor ativo
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            endpoint.stop();
            System.out.println("\n🛑 Servidor encerrado.");
        }));

        // Aguarda indefinidamente
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
