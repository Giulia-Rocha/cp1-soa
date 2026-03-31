package br.com.logistica.client;

import br.com.logistica.client.generated.*;
import br.com.logistica.client.service.LogisticaClienteService;

import java.util.List;

public class ClienteLogisticaMain {

    private static final String RESET  = "\u001B[0m";
    private static final String GREEN  = "\u001B[32m";
    private static final String CYAN   = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED    = "\u001B[31m";
    private static final String BOLD   = "\u001B[1m";

    public static void main(String[] args) {
        cabecalho();

        LogisticaClienteService cliente = new LogisticaClienteService();

        // =====================================================================
        // DEMO 1: Calcular frete
        // =====================================================================
        secao("OPERAÇÃO 1: Calcular Frete");
        try {
            double frete = cliente.calcularFrete(3.5, "SP", "RJ");
            System.out.println(GREEN + "✅ Frete calculado:" + RESET);
            System.out.printf("   Peso: 3.5 kg | SP → RJ | Valor: R$ %.2f%n%n", frete);

            double freteLocal = cliente.calcularFrete(1.0, "SP", "SP");
            System.out.printf("   Peso: 1.0 kg | SP → SP | Valor: R$ %.2f%n%n", freteLocal);
        } catch (Throwable e) {
            System.out.println(RED + "❌ Erro em [calcularFrete]: " + mensagem(e) + RESET);
            System.out.println();
        }

        // =====================================================================
        // DEMO 2: Criar novo pedido
        // =====================================================================
        secao("OPERAÇÃO 2: Criar Pedido");
        String novoCodigo = null;
        try {
            Endereco origem = new Endereco();
            origem.setLogradouro("Av. Tecnologia");
            origem.setNumero("500");
            origem.setBairro("Tech Park");
            origem.setCidade("São Paulo");
            origem.setEstado("SP");
            origem.setCep("04040-000");

            Endereco destino = new Endereco();
            destino.setLogradouro("Rua das Palmeiras");
            destino.setNumero("200");
            destino.setComplemento("Casa 3");
            destino.setBairro("Jardim Botânico");
            destino.setCidade("Rio de Janeiro");
            destino.setEstado("RJ");
            destino.setCep("22461-000");

            novoCodigo = cliente.criarPedido(
                    "Tech Store LTDA",
                    "Roberto Fernandes",
                    origem,
                    destino,
                    "Notebook Dell Inspiron 15",
                    2.8,
                    4500.00
            );

            System.out.println(GREEN + "✅ Pedido criado com sucesso!" + RESET);
            System.out.println("   Código de Rastreio: " + BOLD + CYAN + novoCodigo + RESET);
            System.out.println();
        } catch (Throwable e) {
            System.out.println(RED + "❌ Erro em [criarPedido]: " + mensagem(e) + RESET);
            System.out.println();
        }

        // =====================================================================
        // DEMO 3: Rastrear pedido pré-cadastrado
        // =====================================================================
        secao("OPERAÇÃO 3: Rastrear Pedido (LOG2024001 - Em Trânsito)");
        try {
            Pedido pedido = cliente.rastrearPedido("LOG2024001");
            imprimirPedido(pedido);
        } catch (Throwable e) {
            System.out.println(RED + "❌ Erro em [rastrearPedido]: " + mensagem(e) + RESET);
            System.out.println();
        }

        // =====================================================================
        // DEMO 4: Rastrear pedido entregue
        // =====================================================================
        secao("OPERAÇÃO 3: Rastrear Pedido (LOG2024002 - Entregue)");
        try {
            Pedido pedido = cliente.rastrearPedido("LOG2024002");
            imprimirPedido(pedido);
        } catch (Throwable e) {
            System.out.println(RED + "❌ Erro em [rastrearPedido]: " + mensagem(e) + RESET);
            System.out.println();
        }

        // =====================================================================
        // DEMO 5: Atualizar status do pedido recém-criado
        // =====================================================================
        if (novoCodigo != null) {
            secao("OPERAÇÃO 4: Atualizar Status do Pedido " + novoCodigo);
            try {
                cliente.atualizarStatus(
                        novoCodigo,
                        StatusPedido.COLETADO,
                        "Objeto coletado pelo transportador parceiro.",
                        "São Paulo/SP - Unidade Central",
                        "Transportador: Paulo Carvalho"
                );
                System.out.println(GREEN + "✅ Status atualizado para: COLETADO" + RESET);

                Pedido atualizado = cliente.rastrearPedido(novoCodigo);
                System.out.println("   Status atual confirmado: " + CYAN + atualizado.getStatusAtual() + RESET);
                System.out.printf("   Eventos no histórico: %d%n%n",
                        atualizado.getHistorico() != null ? atualizado.getHistorico().getEvento().size() : 0);
            } catch (Throwable e) {
                System.out.println(RED + "❌ Erro em [atualizarStatus]: " + mensagem(e) + RESET);
                System.out.println();
            }
        }

        // =====================================================================
        // DEMO 6: SOAP Fault - pedido já ENTREGUE
        // =====================================================================
        secao("OPERAÇÃO 4: Testar SOAP Fault - Atualizar pedido ENTREGUE");
        try {
            cliente.atualizarStatus(
                    "LOG2024002",
                    StatusPedido.EM_TRANSITO,
                    "Tentativa inválida",
                    "Qualquer lugar",
                    "Sistema"
            );
        } catch (Throwable e) {
            System.out.println(YELLOW + "⚠️  SOAP Fault recebido (esperado):" + RESET);
            System.out.println("   Mensagem : " + mensagem(e));
            System.out.println();
        }

        // =====================================================================
        // DEMO 7: SOAP Fault - código inexistente
        // =====================================================================
        secao("OPERAÇÃO 3: Testar SOAP Fault - Código inexistente");
        try {
            cliente.rastrearPedido("INVALIDO999");
        } catch (Throwable e) {
            System.out.println(YELLOW + "⚠️  SOAP Fault recebido (esperado):" + RESET);
            System.out.println("   Mensagem : " + mensagem(e));
            System.out.println();
        }

        // =====================================================================
        // DEMO 8: Listar todos os pedidos
        // =====================================================================
        secao("OPERAÇÃO 6: Listar Todos os Pedidos");
        try {
            List<Pedido> pedidos = cliente.listarPedidos();
            System.out.println(GREEN + "✅ Total de pedidos no sistema: " + pedidos.size() + RESET);
            pedidos.forEach(p -> System.out.printf(
                    "   [%s] %-20s → %-20s | %s%n",
                    CYAN + p.getCodigoRastreio() + RESET,
                    p.getNomeRemetente(),
                    p.getNomeDestinatario(),
                    p.getStatusAtual()
            ));
            System.out.println();
        } catch (Throwable e) {
            System.out.println(RED + "❌ Erro em [listarPedidos]: " + mensagem(e) + RESET);
            System.out.println();
        }

        rodape();
    }

    // =========================================================================
    // Helpers
    // =========================================================================

    private static String mensagem(Throwable e) {
        Throwable causa = e.getCause() != null ? e.getCause() : e;
        return causa.getMessage() != null ? causa.getMessage() : causa.getClass().getSimpleName();
    }

    private static void imprimirPedido(Pedido p) {
        System.out.println(GREEN + "✅ Pedido encontrado:" + RESET);
        System.out.println("   Código        : " + BOLD + p.getCodigoRastreio() + RESET);
        System.out.println("   Remetente     : " + p.getNomeRemetente());
        System.out.println("   Destinatário  : " + p.getNomeDestinatario());
        System.out.println("   Conteúdo      : " + p.getDescricaoConteudo());
        System.out.printf( "   Peso / Valor  : %.1f kg | R$ %.2f%n", p.getPesoKg(), p.getValorDeclarado());
        System.out.println("   Status Atual  : " + CYAN + p.getStatusAtual() + RESET);
        System.out.println("   Criado em     : " + p.getDataCriacao());
        System.out.println("   Prev. Entrega : " + p.getPrevisaoEntrega());
        System.out.println("   Histórico     :");

        if (p.getHistorico() != null) {
            p.getHistorico().getEvento().forEach(ev ->
                    System.out.printf("     [%s] %s - %s (%s)%n",
                            ev.getDataHora(), ev.getStatus(), ev.getDescricao(), ev.getLocalidade())
            );
        }
        System.out.println();
    }

    private static void secao(String titulo) {
        System.out.println(BOLD + "─────────────────────────────────────────────────────" + RESET);
        System.out.println(BOLD + YELLOW + "  " + titulo + RESET);
        System.out.println(BOLD + "─────────────────────────────────────────────────────" + RESET);
    }

    private static void cabecalho() {
        System.out.println(BOLD + CYAN);
        System.out.println("╔═════════════════════════════════════════════════════╗");
        System.out.println("║      SISTEMA LOGÍSTICO - CLIENTE SOAP JAX-WS        ║");
        System.out.println("║         Demonstração de todas as operações           ║");
        System.out.println("╚═════════════════════════════════════════════════════╝");
        System.out.println(RESET);
    }

    private static void rodape() {
        System.out.println(BOLD + GREEN);
        System.out.println("╔═════════════════════════════════════════════════════╗");
        System.out.println("║         Demonstração concluída com sucesso!          ║");
        System.out.println("╚═════════════════════════════════════════════════════╝");
        System.out.println(RESET);
    }
}