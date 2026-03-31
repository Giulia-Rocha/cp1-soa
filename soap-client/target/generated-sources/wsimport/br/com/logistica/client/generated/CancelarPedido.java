
package br.com.logistica.client.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cancelarPedido complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>{@code
 * <complexType name="cancelarPedido">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="codigoRastreio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="motivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelarPedido", propOrder = {
    "codigoRastreio",
    "motivo"
})
public class CancelarPedido {

    protected String codigoRastreio;
    protected String motivo;

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
     * Obtém o valor da propriedade motivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Define o valor da propriedade motivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivo(String value) {
        this.motivo = value;
    }

}
