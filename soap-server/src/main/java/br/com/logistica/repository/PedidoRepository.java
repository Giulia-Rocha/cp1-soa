package br.com.logistica.repository;

import br.com.logistica.model.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Repositório em memória simulando persistência de pedidos.
 * Em produção, seria substituído por JPA/Hibernate com banco relacional.
 *
 * Padrão Singleton via enum — thread-safe por definição em Java.
 */
public enum PedidoRepository {
    INSTANCE;

    // ConcurrentHashMap para thread-safety em ambiente de servidor
    private final Map<String, Pedido> pedidos = new ConcurrentHashMap<>();

    PedidoRepository() {
        popularDadosIniciais();
    }

    public Optional<Pedido> buscarPorCodigo(String codigo) {
        return Optional.ofNullable(pedidos.get(codigo.toUpperCase()));
    }

    public Pedido salvar(Pedido pedido) {
        pedidos.put(pedido.getCodigoRastreio().toUpperCase(), pedido);
        return pedido;
    }

    public List<Pedido> listarTodos() {
        return new ArrayList<>(pedidos.values());
    }

    public boolean existe(String codigo) {
        return pedidos.containsKey(codigo.toUpperCase());
    }

    /**
     * Popula dados fictícios para demonstração e testes.
     */
    private void popularDadosIniciais() {
        // Pedido 1 - Em trânsito
        Pedido p1 = Pedido.builder()
            .codigoRastreio("LOG2024001")
            .nomeRemetente("Magazine Luiza S.A.")
            .nomeDestinatario("João Silva")
            .enderecoOrigem(new Endereco("Av. Paulista", "1000", "Andar 5",
                "Bela Vista", "São Paulo", "SP", "01310-100"))
            .enderecoDestino(new Endereco("Rua das Flores", "45", "Apto 3",
                "Centro", "Campinas", "SP", "13010-050"))
            .descricaoConteudo("Smartphone Samsung Galaxy A55")
            .pesoKg(0.5)
            .valorDeclarado(1599.99)
            .statusAtual(StatusPedido.EM_TRANSITO)
            .dataCriacao(LocalDateTime.now().minusDays(3))
            .previsaoEntrega(LocalDateTime.now().plusDays(2))
            .build();

        p1.adicionarEvento(new EventoRastreamento(
            LocalDateTime.now().minusDays(3),
            StatusPedido.AGUARDANDO_COLETA,
            "Pedido registrado no sistema e aguardando coleta.",
            "São Paulo/SP - CD Paulista",
            "Sistema Automático"
        ));
        p1.adicionarEvento(new EventoRastreamento(
            LocalDateTime.now().minusDays(2),
            StatusPedido.COLETADO,
            "Objeto coletado pelo transportador.",
            "São Paulo/SP",
            "Transportador: Carlos Mendes"
        ));
        p1.adicionarEvento(new EventoRastreamento(
            LocalDateTime.now().minusDays(1),
            StatusPedido.EM_TRANSITO,
            "Objeto em trânsito para a cidade de destino.",
            "Jundiaí/SP - Centro de Triagem",
            "Sistema de Triagem"
        ));

        // Pedido 2 - Entregue
        Pedido p2 = Pedido.builder()
            .codigoRastreio("LOG2024002")
            .nomeRemetente("Amazon Brasil")
            .nomeDestinatario("Maria Souza")
            .enderecoOrigem(new Endereco("Rod. Anhanguera", "km 32", null,
                "Distrito Industrial", "Cajamar", "SP", "07776-000"))
            .enderecoDestino(new Endereco("Av. Brasil", "500", "Casa",
                "Jardim América", "Rio de Janeiro", "RJ", "20949-900"))
            .descricaoConteudo("Livros de Programação Java")
            .pesoKg(2.3)
            .valorDeclarado(350.00)
            .statusAtual(StatusPedido.ENTREGUE)
            .dataCriacao(LocalDateTime.now().minusDays(10))
            .previsaoEntrega(LocalDateTime.now().minusDays(3))
            .build();

        p2.adicionarEvento(new EventoRastreamento(
            LocalDateTime.now().minusDays(10),
            StatusPedido.AGUARDANDO_COLETA,
            "Pedido registrado.", "Cajamar/SP", "Sistema"
        ));
        p2.adicionarEvento(new EventoRastreamento(
            LocalDateTime.now().minusDays(8),
            StatusPedido.EM_TRANSITO,
            "Objeto em rota interestadual SP-RJ.", "Guarulhos/SP", "Sistema"
        ));
        p2.adicionarEvento(new EventoRastreamento(
            LocalDateTime.now().minusDays(4),
            StatusPedido.SAIU_PARA_ENTREGA,
            "Objeto saiu para entrega ao destinatário.", "Rio de Janeiro/RJ", "Entregador: Pedro Costa"
        ));
        p2.adicionarEvento(new EventoRastreamento(
            LocalDateTime.now().minusDays(3),
            StatusPedido.ENTREGUE,
            "Objeto entregue ao destinatário. Assinatura: M.Souza", "Rio de Janeiro/RJ", "Entregador: Pedro Costa"
        ));

        // Pedido 3 - Saiu para entrega (hoje)
        Pedido p3 = Pedido.builder()
            .codigoRastreio("LOG2024003")
            .nomeRemetente("Shopee Brasil")
            .nomeDestinatario("Ana Lima")
            .enderecoOrigem(new Endereco("Av. das Nações", "2000", null,
                "Tamboré", "Barueri", "SP", "06460-000"))
            .enderecoDestino(new Endereco("Rua XV de Novembro", "100", "Bloco B Ap 12",
                "Centro", "Curitiba", "PR", "80020-310"))
            .descricaoConteudo("Roupas e Acessórios")
            .pesoKg(1.1)
            .valorDeclarado(280.00)
            .statusAtual(StatusPedido.SAIU_PARA_ENTREGA)
            .dataCriacao(LocalDateTime.now().minusDays(5))
            .previsaoEntrega(LocalDateTime.now())
            .build();

        p3.adicionarEvento(new EventoRastreamento(
            LocalDateTime.now().minusDays(5),
            StatusPedido.AGUARDANDO_COLETA,
            "Pedido registrado.", "Barueri/SP", "Sistema"
        ));
        p3.adicionarEvento(new EventoRastreamento(
            LocalDateTime.now().minusDays(3),
            StatusPedido.EM_TRANSITO,
            "Objeto em trânsito.", "Curitiba/PR - CD Central", "Sistema"
        ));
        p3.adicionarEvento(new EventoRastreamento(
            LocalDateTime.now().minusHours(6),
            StatusPedido.SAIU_PARA_ENTREGA,
            "Objeto saiu para entrega. Previsão: hoje até 20h.", "Curitiba/PR", "Entregador: Lucas Silva"
        ));

        pedidos.put(p1.getCodigoRastreio(), p1);
        pedidos.put(p2.getCodigoRastreio(), p2);
        pedidos.put(p3.getCodigoRastreio(), p3);
    }
}
