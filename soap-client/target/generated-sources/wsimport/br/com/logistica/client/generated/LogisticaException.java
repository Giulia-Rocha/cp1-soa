
package br.com.logistica.client.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de LogisticaException complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>{@code
 * <complexType name="LogisticaException">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="codigoErro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="mensagemTecnica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogisticaException", propOrder = {
    "codigoErro",
    "mensagemTecnica",
    "message"
})
public class LogisticaException {

    protected String codigoErro;
    protected String mensagemTecnica;
    protected String message;

    /**
     * Obtém o valor da propriedade codigoErro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoErro() {
        return codigoErro;
    }

    /**
     * Define o valor da propriedade codigoErro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoErro(String value) {
        this.codigoErro = value;
    }

    /**
     * Obtém o valor da propriedade mensagemTecnica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensagemTecnica() {
        return mensagemTecnica;
    }

    /**
     * Define o valor da propriedade mensagemTecnica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagemTecnica(String value) {
        this.mensagemTecnica = value;
    }

    /**
     * Obtém o valor da propriedade message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Define o valor da propriedade message.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
