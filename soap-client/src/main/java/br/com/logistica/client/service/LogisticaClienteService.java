package br.com.logistica.client.service;

import br.com.logistica.client.generated.*;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

public class LogisticaClienteService {

    private static final Logger LOGGER = Logger.getLogger(LogisticaClienteService.class.getName());

    private static final String DEFAULT_URL = "http://localhost:8080/logistica/rastreamento?wsdl";
    private static final QName SERVICE_QNAME =
            new QName("http://logistica.com/ws", "RastreamentoLogisticoService");
    private static final QName PORT_QNAME =
            new QName("http://logistica.com/ws", "RastreamentoLogisticoPort");

    private final RastreamentoLogistico port;

    public LogisticaClienteService() {
        this(DEFAULT_URL);
    }

    public LogisticaClienteService(String wsdlUrl) {
        try {
            URL url = new URL(wsdlUrl);
            Service service = Service.create(url, SERVICE_QNAME);
            this.port = service.getPort(PORT_QNAME, RastreamentoLogistico.class);
            LOGGER.info("Cliente SOAP conectado em: " + wsdlUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL do WSDL inválida: " + wsdlUrl, e);
        }
    }

    public String criarPedido(String nomeRemetente, String nomeDestinatario,
                              Endereco enderecoOrigem, Endereco enderecoDestino,
                              String descricaoConteudo, double pesoKg,
                              double valorDeclarado) {
        try {
            return port.criarPedido(nomeRemetente, nomeDestinatario, enderecoOrigem,
                    enderecoDestino, descricaoConteudo, pesoKg, valorDeclarado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Pedido rastrearPedido(String codigoRastreio) {
        try {
            return port.rastrearPedido(codigoRastreio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarStatus(String codigoRastreio, StatusPedido novoStatus,
                                String descricao, String localidade,
                                String responsavel) {
        try {
            port.atualizarStatus(codigoRastreio, novoStatus, descricao, localidade, responsavel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void cancelarPedido(String codigoRastreio, String motivo) {
        try {
            port.cancelarPedido(codigoRastreio, motivo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double calcularFrete(double pesoKg, String estadoOrigem,
                                String estadoDestino) {
        try {
            return port.calcularFrete(pesoKg, estadoOrigem, estadoDestino);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Pedido> listarPedidos() {
        return port.listarPedidos();
    }
}