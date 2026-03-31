
package br.com.logistica.client.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de criarPedidoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>{@code
 * <complexType name="criarPedidoResponse">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="codigoRastreio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarPedidoResponse", propOrder = {
    "codigoRastreio"
})
public class CriarPedidoResponse {

    @XmlElement(namespace = "http://logistica.com/ws")
    protected String codigoRastreio;

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

}
