
package br.com.logistica.client.generated;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.logistica.client.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _LogisticaFault_QNAME = new QName("http://logistica.com/ws", "LogisticaFault");
    private static final QName _Pedido_QNAME = new QName("http://logistica.com/ws", "Pedido");
    private static final QName _AtualizarStatus_QNAME = new QName("http://logistica.com/ws", "atualizarStatus");
    private static final QName _AtualizarStatusResponse_QNAME = new QName("http://logistica.com/ws", "atualizarStatusResponse");
    private static final QName _CalcularFrete_QNAME = new QName("http://logistica.com/ws", "calcularFrete");
    private static final QName _CalcularFreteResponse_QNAME = new QName("http://logistica.com/ws", "calcularFreteResponse");
    private static final QName _CancelarPedido_QNAME = new QName("http://logistica.com/ws", "cancelarPedido");
    private static final QName _CancelarPedidoResponse_QNAME = new QName("http://logistica.com/ws", "cancelarPedidoResponse");
    private static final QName _CriarPedido_QNAME = new QName("http://logistica.com/ws", "criarPedido");
    private static final QName _CriarPedidoResponse_QNAME = new QName("http://logistica.com/ws", "criarPedidoResponse");
    private static final QName _ListarPedidos_QNAME = new QName("http://logistica.com/ws", "listarPedidos");
    private static final QName _ListarPedidosResponse_QNAME = new QName("http://logistica.com/ws", "listarPedidosResponse");
    private static final QName _RastrearPedido_QNAME = new QName("http://logistica.com/ws", "rastrearPedido");
    private static final QName _RastrearPedidoResponse_QNAME = new QName("http://logistica.com/ws", "rastrearPedidoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.logistica.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Pedido }
     * 
     * @return
     *     the new instance of {@link Pedido }
     */
    public Pedido createPedido() {
        return new Pedido();
    }

    /**
     * Create an instance of {@link LogisticaException }
     * 
     * @return
     *     the new instance of {@link LogisticaException }
     */
    public LogisticaException createLogisticaException() {
        return new LogisticaException();
    }

    /**
     * Create an instance of {@link AtualizarStatus }
     * 
     * @return
     *     the new instance of {@link AtualizarStatus }
     */
    public AtualizarStatus createAtualizarStatus() {
        return new AtualizarStatus();
    }

    /**
     * Create an instance of {@link AtualizarStatusResponse }
     * 
     * @return
     *     the new instance of {@link AtualizarStatusResponse }
     */
    public AtualizarStatusResponse createAtualizarStatusResponse() {
        return new AtualizarStatusResponse();
    }

    /**
     * Create an instance of {@link CalcularFrete }
     * 
     * @return
     *     the new instance of {@link CalcularFrete }
     */
    public CalcularFrete createCalcularFrete() {
        return new CalcularFrete();
    }

    /**
     * Create an instance of {@link CalcularFreteResponse }
     * 
     * @return
     *     the new instance of {@link CalcularFreteResponse }
     */
    public CalcularFreteResponse createCalcularFreteResponse() {
        return new CalcularFreteResponse();
    }

    /**
     * Create an instance of {@link CancelarPedido }
     * 
     * @return
     *     the new instance of {@link CancelarPedido }
     */
    public CancelarPedido createCancelarPedido() {
        return new CancelarPedido();
    }

    /**
     * Create an instance of {@link CancelarPedidoResponse }
     * 
     * @return
     *     the new instance of {@link CancelarPedidoResponse }
     */
    public CancelarPedidoResponse createCancelarPedidoResponse() {
        return new CancelarPedidoResponse();
    }

    /**
     * Create an instance of {@link CriarPedido }
     * 
     * @return
     *     the new instance of {@link CriarPedido }
     */
    public CriarPedido createCriarPedido() {
        return new CriarPedido();
    }

    /**
     * Create an instance of {@link CriarPedidoResponse }
     * 
     * @return
     *     the new instance of {@link CriarPedidoResponse }
     */
    public CriarPedidoResponse createCriarPedidoResponse() {
        return new CriarPedidoResponse();
    }

    /**
     * Create an instance of {@link ListarPedidos }
     * 
     * @return
     *     the new instance of {@link ListarPedidos }
     */
    public ListarPedidos createListarPedidos() {
        return new ListarPedidos();
    }

    /**
     * Create an instance of {@link ListarPedidosResponse }
     * 
     * @return
     *     the new instance of {@link ListarPedidosResponse }
     */
    public ListarPedidosResponse createListarPedidosResponse() {
        return new ListarPedidosResponse();
    }

    /**
     * Create an instance of {@link RastrearPedido }
     * 
     * @return
     *     the new instance of {@link RastrearPedido }
     */
    public RastrearPedido createRastrearPedido() {
        return new RastrearPedido();
    }

    /**
     * Create an instance of {@link RastrearPedidoResponse }
     * 
     * @return
     *     the new instance of {@link RastrearPedidoResponse }
     */
    public RastrearPedidoResponse createRastrearPedidoResponse() {
        return new RastrearPedidoResponse();
    }

    /**
     * Create an instance of {@link Endereco }
     * 
     * @return
     *     the new instance of {@link Endereco }
     */
    public Endereco createEndereco() {
        return new Endereco();
    }

    /**
     * Create an instance of {@link EventoRastreamento }
     * 
     * @return
     *     the new instance of {@link EventoRastreamento }
     */
    public EventoRastreamento createEventoRastreamento() {
        return new EventoRastreamento();
    }

    /**
     * Create an instance of {@link Pedido.Historico }
     * 
     * @return
     *     the new instance of {@link Pedido.Historico }
     */
    public Pedido.Historico createPedidoHistorico() {
        return new Pedido.Historico();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogisticaException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LogisticaException }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "LogisticaFault")
    public JAXBElement<LogisticaException> createLogisticaFault(LogisticaException value) {
        return new JAXBElement<>(_LogisticaFault_QNAME, LogisticaException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pedido }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Pedido }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "Pedido")
    public JAXBElement<Pedido> createPedido(Pedido value) {
        return new JAXBElement<>(_Pedido_QNAME, Pedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AtualizarStatus }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AtualizarStatus }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "atualizarStatus")
    public JAXBElement<AtualizarStatus> createAtualizarStatus(AtualizarStatus value) {
        return new JAXBElement<>(_AtualizarStatus_QNAME, AtualizarStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AtualizarStatusResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AtualizarStatusResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "atualizarStatusResponse")
    public JAXBElement<AtualizarStatusResponse> createAtualizarStatusResponse(AtualizarStatusResponse value) {
        return new JAXBElement<>(_AtualizarStatusResponse_QNAME, AtualizarStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalcularFrete }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CalcularFrete }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "calcularFrete")
    public JAXBElement<CalcularFrete> createCalcularFrete(CalcularFrete value) {
        return new JAXBElement<>(_CalcularFrete_QNAME, CalcularFrete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalcularFreteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CalcularFreteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "calcularFreteResponse")
    public JAXBElement<CalcularFreteResponse> createCalcularFreteResponse(CalcularFreteResponse value) {
        return new JAXBElement<>(_CalcularFreteResponse_QNAME, CalcularFreteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarPedido }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelarPedido }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "cancelarPedido")
    public JAXBElement<CancelarPedido> createCancelarPedido(CancelarPedido value) {
        return new JAXBElement<>(_CancelarPedido_QNAME, CancelarPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarPedidoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelarPedidoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "cancelarPedidoResponse")
    public JAXBElement<CancelarPedidoResponse> createCancelarPedidoResponse(CancelarPedidoResponse value) {
        return new JAXBElement<>(_CancelarPedidoResponse_QNAME, CancelarPedidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarPedido }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CriarPedido }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "criarPedido")
    public JAXBElement<CriarPedido> createCriarPedido(CriarPedido value) {
        return new JAXBElement<>(_CriarPedido_QNAME, CriarPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarPedidoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CriarPedidoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "criarPedidoResponse")
    public JAXBElement<CriarPedidoResponse> createCriarPedidoResponse(CriarPedidoResponse value) {
        return new JAXBElement<>(_CriarPedidoResponse_QNAME, CriarPedidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPedidos }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarPedidos }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "listarPedidos")
    public JAXBElement<ListarPedidos> createListarPedidos(ListarPedidos value) {
        return new JAXBElement<>(_ListarPedidos_QNAME, ListarPedidos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPedidosResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarPedidosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "listarPedidosResponse")
    public JAXBElement<ListarPedidosResponse> createListarPedidosResponse(ListarPedidosResponse value) {
        return new JAXBElement<>(_ListarPedidosResponse_QNAME, ListarPedidosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RastrearPedido }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RastrearPedido }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "rastrearPedido")
    public JAXBElement<RastrearPedido> createRastrearPedido(RastrearPedido value) {
        return new JAXBElement<>(_RastrearPedido_QNAME, RastrearPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RastrearPedidoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RastrearPedidoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://logistica.com/ws", name = "rastrearPedidoResponse")
    public JAXBElement<RastrearPedidoResponse> createRastrearPedidoResponse(RastrearPedidoResponse value) {
        return new JAXBElement<>(_RastrearPedidoResponse_QNAME, RastrearPedidoResponse.class, null, value);
    }

}
