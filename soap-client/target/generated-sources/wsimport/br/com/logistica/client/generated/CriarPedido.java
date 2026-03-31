
package br.com.logistica.client.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de criarPedido complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>{@code
 * <complexType name="criarPedido">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="nomeRemetente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="nomeDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="enderecoOrigem" type="{http://logistica.com/ws}Endereco" minOccurs="0"/>
 *         <element name="enderecoDestino" type="{http://logistica.com/ws}Endereco" minOccurs="0"/>
 *         <element name="descricaoConteudo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="pesoKg" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="valorDeclarado" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarPedido", propOrder = {
    "nomeRemetente",
    "nomeDestinatario",
    "enderecoOrigem",
    "enderecoDestino",
    "descricaoConteudo",
    "pesoKg",
    "valorDeclarado"
})
public class CriarPedido {

    protected String nomeRemetente;
    protected String nomeDestinatario;
    protected Endereco enderecoOrigem;
    protected Endereco enderecoDestino;
    protected String descricaoConteudo;
    protected double pesoKg;
    protected double valorDeclarado;

    /**
     * Obtém o valor da propriedade nomeRemetente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeRemetente() {
        return nomeRemetente;
    }

    /**
     * Define o valor da propriedade nomeRemetente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeRemetente(String value) {
        this.nomeRemetente = value;
    }

    /**
     * Obtém o valor da propriedade nomeDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    /**
     * Define o valor da propriedade nomeDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeDestinatario(String value) {
        this.nomeDestinatario = value;
    }

    /**
     * Obtém o valor da propriedade enderecoOrigem.
     * 
     * @return
     *     possible object is
     *     {@link Endereco }
     *     
     */
    public Endereco getEnderecoOrigem() {
        return enderecoOrigem;
    }

    /**
     * Define o valor da propriedade enderecoOrigem.
     * 
     * @param value
     *     allowed object is
     *     {@link Endereco }
     *     
     */
    public void setEnderecoOrigem(Endereco value) {
        this.enderecoOrigem = value;
    }

    /**
     * Obtém o valor da propriedade enderecoDestino.
     * 
     * @return
     *     possible object is
     *     {@link Endereco }
     *     
     */
    public Endereco getEnderecoDestino() {
        return enderecoDestino;
    }

    /**
     * Define o valor da propriedade enderecoDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link Endereco }
     *     
     */
    public void setEnderecoDestino(Endereco value) {
        this.enderecoDestino = value;
    }

    /**
     * Obtém o valor da propriedade descricaoConteudo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricaoConteudo() {
        return descricaoConteudo;
    }

    /**
     * Define o valor da propriedade descricaoConteudo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricaoConteudo(String value) {
        this.descricaoConteudo = value;
    }

    /**
     * Obtém o valor da propriedade pesoKg.
     * 
     */
    public double getPesoKg() {
        return pesoKg;
    }

    /**
     * Define o valor da propriedade pesoKg.
     * 
     */
    public void setPesoKg(double value) {
        this.pesoKg = value;
    }

    /**
     * Obtém o valor da propriedade valorDeclarado.
     * 
     */
    public double getValorDeclarado() {
        return valorDeclarado;
    }

    /**
     * Define o valor da propriedade valorDeclarado.
     * 
     */
    public void setValorDeclarado(double value) {
        this.valorDeclarado = value;
    }

}
