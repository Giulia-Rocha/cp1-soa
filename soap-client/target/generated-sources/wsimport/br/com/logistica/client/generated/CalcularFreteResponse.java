
package br.com.logistica.client.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de calcularFreteResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>{@code
 * <complexType name="calcularFreteResponse">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="valorFrete" type="{http://www.w3.org/2001/XMLSchema}double" form="qualified"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calcularFreteResponse", propOrder = {
    "valorFrete"
})
public class CalcularFreteResponse {

    @XmlElement(namespace = "http://logistica.com/ws")
    protected double valorFrete;

    /**
     * Obtém o valor da propriedade valorFrete.
     * 
     */
    public double getValorFrete() {
        return valorFrete;
    }

    /**
     * Define o valor da propriedade valorFrete.
     * 
     */
    public void setValorFrete(double value) {
        this.valorFrete = value;
    }

}
