package br.com.logistica.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa um evento no histórico de rastreamento de um pedido.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventoRastreamento", propOrder = {"dataHora", "status", "descricao", "localidade", "responsavel"})
public class EventoRastreamento {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @XmlElement(required = true)
    private String dataHora;

    @XmlElement(required = true)
    private String status;

    @XmlElement(required = true)
    private String descricao;

    @XmlElement(required = true)
    private String localidade;

    private String responsavel;

    public EventoRastreamento() {}

    public EventoRastreamento(LocalDateTime dataHora, StatusPedido status,
                               String descricao, String localidade, String responsavel) {
        this.dataHora = dataHora.format(FORMATTER);
        this.status = status.getDescricao();
        this.descricao = descricao;
        this.localidade = localidade;
        this.responsavel = responsavel;
    }

    public String getDataHora() { return dataHora; }
    public void setDataHora(String dataHora) { this.dataHora = dataHora; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getLocalidade() { return localidade; }
    public void setLocalidade(String localidade) { this.localidade = localidade; }

    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
}
