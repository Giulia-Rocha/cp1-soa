package br.com.logistica.model;

/**
 * Representa os possíveis status de um pedido no fluxo logístico.
 */
public enum StatusPedido {
    AGUARDANDO_COLETA("Aguardando Coleta"),
    COLETADO("Coletado"),
    EM_TRANSITO("Em Trânsito"),
    EM_SEPARACAO("Em Separação no Centro de Distribuição"),
    SAIU_PARA_ENTREGA("Saiu para Entrega"),
    ENTREGUE("Entregue"),
    TENTATIVA_ENTREGA("Tentativa de Entrega sem Sucesso"),
    DEVOLVIDO("Devolvido ao Remetente"),
    EXTRAVIADO("Extraviado"),
    CANCELADO("Cancelado");

    private final String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
