package br.com.logistica.service;

import br.com.logistica.exception.LogisticaException;
import br.com.logistica.model.*;
import br.com.logistica.repository.PedidoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Camada de serviço contendo toda a lógica de negócio.
 * Separa responsabilidades: o Endpoint apenas delega para cá.
 *
 * Boas práticas aplicadas:
 * - Validações centralizadas nesta camada
 * - Lançamento de exceções semânticas (LogisticaException)
 * - Geração de código de rastreio com UUID garantindo unicidade
 */
public class RastreamentoService {

    private final PedidoRepository repository = PedidoRepository.INSTANCE;

    /**
     * Cria um novo pedido no sistema e retorna o código de rastreio gerado.
     */
    public String criarPedido(String nomeRemetente, String nomeDestinatario,
                               Endereco enderecoOrigem, Endereco enderecoDestino,
                               String descricaoConteudo, double pesoKg,
                               double valorDeclarado) throws LogisticaException {

        validarCamposObrigatorios(nomeRemetente, nomeDestinatario, enderecoOrigem,
                                   enderecoDestino, descricaoConteudo);

        if (pesoKg <= 0) {
            throw new LogisticaException(
                LogisticaException.DADOS_INVALIDOS,
                "Peso do pedido deve ser maior que zero.",
                "Campo pesoKg inválido: " + pesoKg
            );
        }

        String codigo = gerarCodigoRastreio();

        Pedido pedido = Pedido.builder()
            .codigoRastreio(codigo)
            .nomeRemetente(nomeRemetente)
            .nomeDestinatario(nomeDestinatario)
            .enderecoOrigem(enderecoOrigem)
            .enderecoDestino(enderecoDestino)
            .descricaoConteudo(descricaoConteudo)
            .pesoKg(pesoKg)
            .valorDeclarado(valorDeclarado)
            .statusAtual(StatusPedido.AGUARDANDO_COLETA)
            .dataCriacao(LocalDateTime.now())
            .previsaoEntrega(calcularPrevisaoEntrega(enderecoOrigem, enderecoDestino))
            .build();

        pedido.adicionarEvento(new EventoRastreamento(
            LocalDateTime.now(),
            StatusPedido.AGUARDANDO_COLETA,
            "Pedido registrado no sistema. Aguardando coleta.",
            enderecoOrigem.getCidade() + "/" + enderecoOrigem.getEstado(),
            "Sistema Automático"
        ));

        repository.salvar(pedido);
        return codigo;
    }

    /**
     * Busca um pedido pelo código de rastreio.
     */
    public Pedido rastrearPedido(String codigoRastreio) throws LogisticaException {
        if (codigoRastreio == null || codigoRastreio.isBlank()) {
            throw new LogisticaException(
                LogisticaException.CODIGO_INVALIDO,
                "Código de rastreio não pode ser vazio.",
                "codigoRastreio nulo ou em branco"
            );
        }

        return repository.buscarPorCodigo(codigoRastreio)
            .orElseThrow(() -> new LogisticaException(
                LogisticaException.PEDIDO_NAO_ENCONTRADO,
                "Pedido com código '" + codigoRastreio + "' não encontrado.",
                "Nenhum registro no repositório para o código: " + codigoRastreio
            ));
    }

    /**
     * Atualiza o status de um pedido e registra o evento no histórico.
     */
    public void atualizarStatus(String codigoRastreio, StatusPedido novoStatus,
                                 String descricao, String localidade,
                                 String responsavel) throws LogisticaException {

        Pedido pedido = rastrearPedido(codigoRastreio);

        // Regra de negócio: não permite atualizar pedido já entregue ou cancelado
        if (pedido.getStatusAtual().equals(StatusPedido.ENTREGUE.getDescricao())) {
            throw new LogisticaException(
                LogisticaException.PEDIDO_JA_ENTREGUE,
                "Pedido já foi entregue e não pode ter status alterado.",
                "Tentativa de alterar status de pedido ENTREGUE: " + codigoRastreio
            );
        }

        if (pedido.getStatusAtual().equals(StatusPedido.CANCELADO.getDescricao())) {
            throw new LogisticaException(
                LogisticaException.PEDIDO_CANCELADO,
                "Pedido cancelado não pode ter status alterado.",
                "Tentativa de alterar status de pedido CANCELADO: " + codigoRastreio
            );
        }

        EventoRastreamento evento = new EventoRastreamento(
            LocalDateTime.now(), novoStatus, descricao, localidade, responsavel
        );

        pedido.adicionarEvento(evento);
        repository.salvar(pedido);
    }

    /**
     * Cancela um pedido se ainda for possível (não entregue).
     */
    public void cancelarPedido(String codigoRastreio, String motivo) throws LogisticaException {
        Pedido pedido = rastrearPedido(codigoRastreio);

        if (pedido.getStatusAtual().equals(StatusPedido.ENTREGUE.getDescricao())) {
            throw new LogisticaException(
                LogisticaException.PEDIDO_JA_ENTREGUE,
                "Não é possível cancelar um pedido já entregue.",
                "Tentativa de cancelar pedido ENTREGUE: " + codigoRastreio
            );
        }

        atualizarStatus(codigoRastreio, StatusPedido.CANCELADO,
            "Pedido cancelado. Motivo: " + motivo,
            pedido.getEnderecoOrigem().getCidade() + "/" + pedido.getEnderecoOrigem().getEstado(),
            "Solicitação do cliente"
        );
    }

    /**
     * Calcula o frete estimado com base no peso e distância (interestadual).
     */
    public double calcularFrete(double pesoKg, String estadoOrigem, String estadoDestino) throws LogisticaException {
        if (pesoKg <= 0) {
            throw new LogisticaException(
                LogisticaException.DADOS_INVALIDOS,
                "Peso inválido para cálculo de frete.",
                "pesoKg <= 0: " + pesoKg
            );
        }

        // Lógica simplificada: base + por kg, com acréscimo se interestadual
        double taxaBase = 15.00;
        double taxaPorKg = 3.50;
        double taxaInterestadual = estadoOrigem.equalsIgnoreCase(estadoDestino) ? 0 : 25.00;

        double frete = taxaBase + (pesoKg * taxaPorKg) + taxaInterestadual;

        // Arredondar para 2 casas decimais
        return Math.round(frete * 100.0) / 100.0;
    }

    /**
     * Lista todos os pedidos cadastrados.
     */
    public List<Pedido> listarPedidos() {
        return repository.listarTodos();
    }

    // -------------------------------------------------------------------------
    // Métodos auxiliares privados
    // -------------------------------------------------------------------------

    private String gerarCodigoRastreio() {
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase();
        return "LOG" + LocalDateTime.now().getYear() + uuid;
    }

    private LocalDateTime calcularPrevisaoEntrega(Endereco origem, Endereco destino) {
        // Mesma cidade: 1 dia | Mesmo estado: 3 dias | Interestadual: 7 dias
        if (origem.getCidade().equalsIgnoreCase(destino.getCidade())) {
            return LocalDateTime.now().plusDays(1);
        } else if (origem.getEstado().equalsIgnoreCase(destino.getEstado())) {
            return LocalDateTime.now().plusDays(3);
        } else {
            return LocalDateTime.now().plusDays(7);
        }
    }

    private void validarCamposObrigatorios(String nomeRemetente, String nomeDestinatario,
                                            Endereco enderecoOrigem, Endereco enderecoDestino,
                                            String descricaoConteudo) throws LogisticaException {
        if (nomeRemetente == null || nomeRemetente.isBlank()) {
            throw new LogisticaException(LogisticaException.DADOS_INVALIDOS,
                "Nome do remetente é obrigatório.", "nomeRemetente nulo/vazio");
        }
        if (nomeDestinatario == null || nomeDestinatario.isBlank()) {
            throw new LogisticaException(LogisticaException.DADOS_INVALIDOS,
                "Nome do destinatário é obrigatório.", "nomeDestinatario nulo/vazio");
        }
        if (enderecoOrigem == null || enderecoDestino == null) {
            throw new LogisticaException(LogisticaException.DADOS_INVALIDOS,
                "Endereços de origem e destino são obrigatórios.", "endereco nulo");
        }
        if (descricaoConteudo == null || descricaoConteudo.isBlank()) {
            throw new LogisticaException(LogisticaException.DADOS_INVALIDOS,
                "Descrição do conteúdo é obrigatória.", "descricaoConteudo nulo/vazio");
        }
    }
}
