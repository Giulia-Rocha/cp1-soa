
package br.com.logistica.client.generated;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de statusPedido.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <pre>{@code
 * <simpleType name="statusPedido">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="AGUARDANDO_COLETA"/>
 *     <enumeration value="COLETADO"/>
 *     <enumeration value="EM_TRANSITO"/>
 *     <enumeration value="EM_SEPARACAO"/>
 *     <enumeration value="SAIU_PARA_ENTREGA"/>
 *     <enumeration value="ENTREGUE"/>
 *     <enumeration value="TENTATIVA_ENTREGA"/>
 *     <enumeration value="DEVOLVIDO"/>
 *     <enumeration value="EXTRAVIADO"/>
 *     <enumeration value="CANCELADO"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "statusPedido")
@XmlEnum
public enum StatusPedido {

    AGUARDANDO_COLETA,
    COLETADO,
    EM_TRANSITO,
    EM_SEPARACAO,
    SAIU_PARA_ENTREGA,
    ENTREGUE,
    TENTATIVA_ENTREGA,
    DEVOLVIDO,
    EXTRAVIADO,
    CANCELADO;

    public String value() {
        return name();
    }

    public static StatusPedido fromValue(String v) {
        return valueOf(v);
    }

}
