
package br.com.logistica.client.generated;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Pedido complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>{@code
 * <complexType name="Pedido">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="codigoRastreio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="nomeRemetente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="nomeDestinatario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="enderecoOrigem" type="{http://logistica.com/ws}Endereco"/>
 *         <element name="enderecoDestino" type="{http://logistica.com/ws}Endereco"/>
 *         <element name="descricaoConteudo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="pesoKg" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="valorDeclarado" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="statusAtual" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="dataCriacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="previsaoEntrega" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="historico" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="evento" type="{http://logistica.com/ws}EventoRastreamento" maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pedido", propOrder = {
    "codigoRastreio",
    "nomeRemetente",
    "nomeDestinatario",
    "enderecoOrigem",
    "enderecoDestino",
    "descricaoConteudo",
    "pesoKg",
    "valorDeclarado",
    "statusAtual",
    "dataCriacao",
    "previsaoEntrega",
    "historico"
})
public class Pedido {

    @XmlElement(required = true)
    protected String codigoRastreio;
    @XmlElement(required = true)
    protected String nomeRemetente;
    @XmlElement(required = true)
    protected String nomeDestinatario;
    @XmlElement(required = true)
    protected Endereco enderecoOrigem;
    @XmlElement(required = true)
    protected Endereco enderecoDestino;
    protected String descricaoConteudo;
    protected double pesoKg;
    protected double valorDeclarado;
    @XmlElement(required = true)
    protected String statusAtual;
    protected String dataCriacao;
    protected String previsaoEntrega;
    protected Pedido.Historico historico;

    /**
     * Obtém o valor da propriedade codigoRastreio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    /**
     * Define o valor da propriedade codigoRastreio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoRastreio(String value) {
        this.codigoRastreio = value;
    }

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

    /**
     * Obtém o valor da propriedade statusAtual.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusAtual() {
        return statusAtual;
    }

    /**
     * Define o valor da propriedade statusAtual.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusAtual(String value) {
        this.statusAtual = value;
    }

    /**
     * Obtém o valor da propriedade dataCriacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataCriacao() {
        return dataCriacao;
    }

    /**
     * Define o valor da propriedade dataCriacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataCriacao(String value) {
        this.dataCriacao = value;
    }

    /**
     * Obtém o valor da propriedade previsaoEntrega.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    /**
     * Define o valor da propriedade previsaoEntrega.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrevisaoEntrega(String value) {
        this.previsaoEntrega = value;
    }

    /**
     * Obtém o valor da propriedade historico.
     * 
     * @return
     *     possible object is
     *     {@link Pedido.Historico }
     *     
     */
    public Pedido.Historico getHistorico() {
        return historico;
    }

    /**
     * Define o valor da propriedade historico.
     * 
     * @param value
     *     allowed object is
     *     {@link Pedido.Historico }
     *     
     */
    public void setHistorico(Pedido.Historico value) {
        this.historico = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="evento" type="{http://logistica.com/ws}EventoRastreamento" maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "evento"
    })
    public static class Historico {

        protected List<EventoRastreamento> evento;

        /**
         * Gets the value of the evento property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a {@code set} method for the evento property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEvento().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EventoRastreamento }
         * 
         * 
         * @return
         *     The value of the evento property.
         */
        public List<EventoRastreamento> getEvento() {
            if (evento == null) {
                evento = new ArrayList<>();
            }
            return this.evento;
        }

    }

}
