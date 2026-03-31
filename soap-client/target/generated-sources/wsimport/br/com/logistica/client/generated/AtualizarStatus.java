
package br.com.logistica.client.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de atualizarStatus complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>{@code
 * <complexType name="atualizarStatus">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="codigoRastreio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="novoStatus" type="{http://logistica.com/ws}statusPedido" minOccurs="0"/>
 *         <element name="descricao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="localidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="responsavel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "atualizarStatus", propOrder = {
    "codigoRastreio",
    "novoStatus",
    "descricao",
    "localidade",
    "responsavel"
})
public class AtualizarStatus {

    protected String codigoRastreio;
    @XmlSchemaType(name = "string")
    protected StatusPedido novoStatus;
    protected String descricao;
    protected String localidade;
    protected String responsavel;

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
     * Obtém o valor da propriedade novoStatus.
     * 
     * @return
     *     possible object is
     *     {@link StatusPedido }
     *     
     */
    public StatusPedido getNovoStatus() {
        return novoStatus;
    }

    /**
     * Define o valor da propriedade novoStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusPedido }
     *     
     */
    public void setNovoStatus(StatusPedido value) {
        this.novoStatus = value;
    }

    /**
     * Obtém o valor da propriedade descricao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define o valor da propriedade descricao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricao(String value) {
        this.descricao = value;
    }

    /**
     * Obtém o valor da propriedade localidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * Define o valor da propriedade localidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalidade(String value) {
        this.localidade = value;
    }

    /**
     * Obtém o valor da propriedade responsavel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsavel() {
        return responsavel;
    }

    /**
     * Define o valor da propriedade responsavel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsavel(String value) {
        this.responsavel = value;
    }

}
