package br.com.logistica.model;

import jakarta.xml.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade principal que representa um pedido de entrega no sistema logístico.
 */
@XmlRootElement(name = "Pedido")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pedido", propOrder = {
    "codigoRastreio", "nomeRemetente", "nomeDestinatario",
    "enderecoOrigem", "enderecoDestino", "descricaoConteudo",
    "pesoKg", "valorDeclarado", "statusAtual",
    "dataCriacao", "previsaoEntrega", "historico"
})
public class Pedido {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @XmlElement(required = true)
    private String codigoRastreio;

    @XmlElement(required = true)
    private String nomeRemetente;

    @XmlElement(required = true)
    private String nomeDestinatario;

    @XmlElement(required = true)
    private Endereco enderecoOrigem;

    @XmlElement(required = true)
    private Endereco enderecoDestino;

    private String descricaoConteudo;
    private double pesoKg;
    private double valorDeclarado;

    @XmlElement(required = true)
    private String statusAtual;

    private String dataCriacao;
    private String previsaoEntrega;

    @XmlElementWrapper(name = "historico")
    @XmlElement(name = "evento")
    private List<EventoRastreamento> historico = new ArrayList<>();

    public Pedido() {}

    // Builder pattern para facilitar criação
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final Pedido pedido = new Pedido();

        public Builder codigoRastreio(String codigo) { pedido.codigoRastreio = codigo; return this; }
        public Builder nomeRemetente(String nome) { pedido.nomeRemetente = nome; return this; }
        public Builder nomeDestinatario(String nome) { pedido.nomeDestinatario = nome; return this; }
        public Builder enderecoOrigem(Endereco e) { pedido.enderecoOrigem = e; return this; }
        public Builder enderecoDestino(Endereco e) { pedido.enderecoDestino = e; return this; }
        public Builder descricaoConteudo(String d) { pedido.descricaoConteudo = d; return this; }
        public Builder pesoKg(double p) { pedido.pesoKg = p; return this; }
        public Builder valorDeclarado(double v) { pedido.valorDeclarado = v; return this; }
        public Builder statusAtual(StatusPedido s) { pedido.statusAtual = s.getDescricao(); return this; }
        public Builder dataCriacao(LocalDateTime d) { pedido.dataCriacao = d.format(FORMATTER); return this; }
        public Builder previsaoEntrega(LocalDateTime d) { pedido.previsaoEntrega = d.format(FORMATTER); return this; }

        public Pedido build() { return pedido; }
    }

    public void adicionarEvento(EventoRastreamento evento) {
        this.historico.add(evento);
        this.statusAtual = evento.getStatus();
    }

    // Getters e Setters
    public String getCodigoRastreio() { return codigoRastreio; }
    public void setCodigoRastreio(String codigoRastreio) { this.codigoRastreio = codigoRastreio; }

    public String getNomeRemetente() { return nomeRemetente; }
    public void setNomeRemetente(String nomeRemetente) { this.nomeRemetente = nomeRemetente; }

    public String getNomeDestinatario() { return nomeDestinatario; }
    public void setNomeDestinatario(String nomeDestinatario) { this.nomeDestinatario = nomeDestinatario; }

    public Endereco getEnderecoOrigem() { return enderecoOrigem; }
    public void setEnderecoOrigem(Endereco enderecoOrigem) { this.enderecoOrigem = enderecoOrigem; }

    public Endereco getEnderecoDestino() { return enderecoDestino; }
    public void setEnderecoDestino(Endereco enderecoDestino) { this.enderecoDestino = enderecoDestino; }

    public String getDescricaoConteudo() { return descricaoConteudo; }
    public void setDescricaoConteudo(String descricaoConteudo) { this.descricaoConteudo = descricaoConteudo; }

    public double getPesoKg() { return pesoKg; }
    public void setPesoKg(double pesoKg) { this.pesoKg = pesoKg; }

    public double getValorDeclarado() { return valorDeclarado; }
    public void setValorDeclarado(double valorDeclarado) { this.valorDeclarado = valorDeclarado; }

    public String getStatusAtual() { return statusAtual; }
    public void setStatusAtual(String statusAtual) { this.statusAtual = statusAtual; }

    public String getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(String dataCriacao) { this.dataCriacao = dataCriacao; }

    public String getPrevisaoEntrega() { return previsaoEntrega; }
    public void setPrevisaoEntrega(String previsaoEntrega) { this.previsaoEntrega = previsaoEntrega; }

    public List<EventoRastreamento> getHistorico() { return historico; }
    public void setHistorico(List<EventoRastreamento> historico) { this.historico = historico; }
}
