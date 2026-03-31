
package br.com.logistica.client.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de calcularFrete complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>{@code
 * <complexType name="calcularFrete">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="pesoKg" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="estadoOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="estadoDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calcularFrete", propOrder = {
    "pesoKg",
    "estadoOrigem",
    "estadoDestino"
})
public class CalcularFrete {

    protected double pesoKg;
    protected String estadoOrigem;
    protected String estadoDestino;

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
     * Obtém o valor da propriedade estadoOrigem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoOrigem() {
        return estadoOrigem;
    }

    /**
     * Define o valor da propriedade estadoOrigem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoOrigem(String value) {
        this.estadoOrigem = value;
    }

    /**
     * Obtém o valor da propriedade estadoDestino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoDestino() {
        return estadoDestino;
    }

    /**
     * Define o valor da propriedade estadoDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoDestino(String value) {
        this.estadoDestino = value;
    }

}
