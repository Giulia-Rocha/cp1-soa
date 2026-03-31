package br.com.logistica.exception;

import jakarta.xml.ws.WebFault;

/**
 * Exceção customizada que gera um SOAP Fault estruturado.
 * Boas práticas: SOAP Faults devem carregar informações claras sobre o erro.
 */
@WebFault(name = "LogisticaFault", targetNamespace = "http://logistica.com/ws")
public class LogisticaException extends Exception {

    private final String codigoErro;
    private final String mensagemTecnica;

    public LogisticaException(String codigoErro, String mensagem, String mensagemTecnica) {
        super(mensagem);
        this.codigoErro = codigoErro;
        this.mensagemTecnica = mensagemTecnica;
    }

    public String getCodigoErro() { return codigoErro; }
    public String getMensagemTecnica() { return mensagemTecnica; }

    // Códigos de erro padronizados
    public static final String PEDIDO_NAO_ENCONTRADO = "LOG-001";
    public static final String CODIGO_INVALIDO = "LOG-002";
    public static final String PEDIDO_JA_ENTREGUE = "LOG-003";
    public static final String PEDIDO_CANCELADO = "LOG-004";
    public static final String DADOS_INVALIDOS = "LOG-005";
}
