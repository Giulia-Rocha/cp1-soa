package br.com.logistica.endpoint;

import br.com.logistica.exception.LogisticaException;
import br.com.logistica.model.*;
import br.com.logistica.service.RastreamentoService;
import jakarta.jws.*;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.ws.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * Endpoint JAX-WS que expõe os serviços de rastreamento logístico via SOAP.
 *
 * Boas práticas aplicadas:
 * - Anotações explícitas com targetNamespace consistente
 * - SOAPBinding DOCUMENT/LITERAL (WS-I Basic Profile)
 * - Uso de @WebParam para nomes semânticos no WSDL gerado
 * - Logging para auditoria de chamadas
 * - Delegação total para a camada de serviço
 */
@WebService(
    name = "RastreamentoLogistico",
    serviceName = "RastreamentoLogisticoService",
    portName = "RastreamentoLogisticoPort",
    targetNamespace = "http://logistica.com/ws"
)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class RastreamentoEndpoint {

    private static final Logger LOGGER = Logger.getLogger(RastreamentoEndpoint.class.getName());

    private final RastreamentoService service = new RastreamentoService();

    // =========================================================================
    // Operação 1: Criar Pedido
    // =========================================================================
    @WebMethod(operationName = "criarPedido", action = "http://logistica.com/ws/criarPedido")
    @WebResult(name = "codigoRastreio", targetNamespace = "http://logistica.com/ws")
    public String criarPedido(
        @WebParam(name = "nomeRemetente") String nomeRemetente,
        @WebParam(name = "nomeDestinatario") String nomeDestinatario,
        @WebParam(name = "enderecoOrigem") Endereco enderecoOrigem,
        @WebParam(name = "enderecoDestino") Endereco enderecoDestino,
        @WebParam(name = "descricaoConteudo") String descricaoConteudo,
        @WebParam(name = "pesoKg") double pesoKg,
        @WebParam(name = "valorDeclarado") double valorDeclarado
    ) throws LogisticaException {

        LOGGER.info("[criarPedido] Remetente: " + nomeRemetente + " | Destinatário: " + nomeDestinatario);
        return service.criarPedido(nomeRemetente, nomeDestinatario, enderecoOrigem,
                                    enderecoDestino, descricaoConteudo, pesoKg, valorDeclarado);
    }

    // =========================================================================
    // Operação 2: Rastrear Pedido
    // =========================================================================
    @WebMethod(operationName = "rastrearPedido", action = "http://logistica.com/ws/rastrearPedido")
    @WebResult(name = "pedido", targetNamespace = "http://logistica.com/ws")
    public Pedido rastrearPedido(
        @WebParam(name = "codigoRastreio") String codigoRastreio
    ) throws LogisticaException {

        LOGGER.info("[rastrearPedido] Código: " + codigoRastreio);
        return service.rastrearPedido(codigoRastreio);
    }

    // =========================================================================
    // Operação 3: Atualizar Status
    // =========================================================================
    @WebMethod(operationName = "atualizarStatus", action = "http://logistica.com/ws/atualizarStatus")
    public void atualizarStatus(
        @WebParam(name = "codigoRastreio") String codigoRastreio,
        @WebParam(name = "novoStatus") StatusPedido novoStatus,
        @WebParam(name = "descricao") String descricao,
        @WebParam(name = "localidade") String localidade,
        @WebParam(name = "responsavel") String responsavel
    ) throws LogisticaException {

        LOGGER.info("[atualizarStatus] Código: " + codigoRastreio + " | Novo status: " + novoStatus);
        service.atualizarStatus(codigoRastreio, novoStatus, descricao, localidade, responsavel);
    }

    // =========================================================================
    // Operação 4: Cancelar Pedido
    // =========================================================================
    @WebMethod(operationName = "cancelarPedido", action = "http://logistica.com/ws/cancelarPedido")
    public void cancelarPedido(
        @WebParam(name = "codigoRastreio") String codigoRastreio,
        @WebParam(name = "motivo") String motivo
    ) throws LogisticaException {

        LOGGER.info("[cancelarPedido] Código: " + codigoRastreio + " | Motivo: " + motivo);
        service.cancelarPedido(codigoRastreio, motivo);
    }

    // =========================================================================
    // Operação 5: Calcular Frete
    // =========================================================================
    @WebMethod(operationName = "calcularFrete", action = "http://logistica.com/ws/calcularFrete")
    @WebResult(name = "valorFrete", targetNamespace = "http://logistica.com/ws")
    public double calcularFrete(
        @WebParam(name = "pesoKg") double pesoKg,
        @WebParam(name = "estadoOrigem") String estadoOrigem,
        @WebParam(name = "estadoDestino") String estadoDestino
    ) throws LogisticaException {

        LOGGER.info("[calcularFrete] Peso: " + pesoKg + "kg | " + estadoOrigem + " -> " + estadoDestino);
        return service.calcularFrete(pesoKg, estadoOrigem, estadoDestino);
    }

    // =========================================================================
    // Operação 6: Listar Pedidos
    // =========================================================================
    @WebMethod(operationName = "listarPedidos", action = "http://logistica.com/ws/listarPedidos")
    @WebResult(name = "pedidos", targetNamespace = "http://logistica.com/ws")
    public List<Pedido> listarPedidos() {
        LOGGER.info("[listarPedidos] Listando todos os pedidos.");
        return service.listarPedidos();
    }
}
