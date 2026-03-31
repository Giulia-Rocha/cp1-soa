package br.com.logistica.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Representa um endereço físico para entrega ou coleta.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Endereco", propOrder = {"logradouro", "numero", "complemento", "bairro", "cidade", "estado", "cep"})
public class Endereco {

    @XmlElement(required = true)
    private String logradouro;

    @XmlElement(required = true)
    private String numero;

    private String complemento;

    @XmlElement(required = true)
    private String bairro;

    @XmlElement(required = true)
    private String cidade;

    @XmlElement(required = true)
    private String estado;

    @XmlElement(required = true)
    private String cep;

    public Endereco() {}

    public Endereco(String logradouro, String numero, String complemento,
                    String bairro, String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    // Getters e Setters
    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    @Override
    public String toString() {
        return logradouro + ", " + numero + " - " + bairro + ", " + cidade + "/" + estado + " - CEP: " + cep;
    }
}
