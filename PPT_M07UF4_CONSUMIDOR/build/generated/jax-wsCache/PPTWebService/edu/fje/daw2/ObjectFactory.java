
package edu.fje.daw2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.fje.daw2 package. 
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

    private final static QName _ConsultarEstatPartida_QNAME = new QName("http://daw2/", "consultarEstatPartida");
    private final static QName _ConsultarEstatPartidaResponse_QNAME = new QName("http://daw2/", "consultarEstatPartidaResponse");
    private final static QName _SetLlistaPartidesResponse_QNAME = new QName("http://daw2/", "setLlistaPartidesResponse");
    private final static QName _SetLlistaPartides_QNAME = new QName("http://daw2/", "setLlistaPartides");
    private final static QName _AcabarJoc_QNAME = new QName("http://daw2/", "acabarJoc");
    private final static QName _GetLlistaPartides_QNAME = new QName("http://daw2/", "getLlistaPartides");
    private final static QName _MoureJugadorResponse_QNAME = new QName("http://daw2/", "moureJugadorResponse");
    private final static QName _IniciarJocResponse_QNAME = new QName("http://daw2/", "iniciarJocResponse");
    private final static QName _GetLlistaPartidesResponse_QNAME = new QName("http://daw2/", "getLlistaPartidesResponse");
    private final static QName _AcabarJocResponse_QNAME = new QName("http://daw2/", "acabarJocResponse");
    private final static QName _MoureJugador_QNAME = new QName("http://daw2/", "moureJugador");
    private final static QName _IniciarJoc_QNAME = new QName("http://daw2/", "iniciarJoc");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.fje.daw2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLlistaPartidesResponse }
     * 
     */
    public GetLlistaPartidesResponse createGetLlistaPartidesResponse() {
        return new GetLlistaPartidesResponse();
    }

    /**
     * Create an instance of {@link IniciarJocResponse }
     * 
     */
    public IniciarJocResponse createIniciarJocResponse() {
        return new IniciarJocResponse();
    }

    /**
     * Create an instance of {@link AcabarJocResponse }
     * 
     */
    public AcabarJocResponse createAcabarJocResponse() {
        return new AcabarJocResponse();
    }

    /**
     * Create an instance of {@link MoureJugador }
     * 
     */
    public MoureJugador createMoureJugador() {
        return new MoureJugador();
    }

    /**
     * Create an instance of {@link IniciarJoc }
     * 
     */
    public IniciarJoc createIniciarJoc() {
        return new IniciarJoc();
    }

    /**
     * Create an instance of {@link ConsultarEstatPartida }
     * 
     */
    public ConsultarEstatPartida createConsultarEstatPartida() {
        return new ConsultarEstatPartida();
    }

    /**
     * Create an instance of {@link ConsultarEstatPartidaResponse }
     * 
     */
    public ConsultarEstatPartidaResponse createConsultarEstatPartidaResponse() {
        return new ConsultarEstatPartidaResponse();
    }

    /**
     * Create an instance of {@link SetLlistaPartidesResponse }
     * 
     */
    public SetLlistaPartidesResponse createSetLlistaPartidesResponse() {
        return new SetLlistaPartidesResponse();
    }

    /**
     * Create an instance of {@link GetLlistaPartides }
     * 
     */
    public GetLlistaPartides createGetLlistaPartides() {
        return new GetLlistaPartides();
    }

    /**
     * Create an instance of {@link MoureJugadorResponse }
     * 
     */
    public MoureJugadorResponse createMoureJugadorResponse() {
        return new MoureJugadorResponse();
    }

    /**
     * Create an instance of {@link SetLlistaPartides }
     * 
     */
    public SetLlistaPartides createSetLlistaPartides() {
        return new SetLlistaPartides();
    }

    /**
     * Create an instance of {@link AcabarJoc }
     * 
     */
    public AcabarJoc createAcabarJoc() {
        return new AcabarJoc();
    }

    /**
     * Create an instance of {@link Partida }
     * 
     */
    public Partida createPartida() {
        return new Partida();
    }

    /**
     * Create an instance of {@link Jugador }
     * 
     */
    public Jugador createJugador() {
        return new Jugador();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarEstatPartida }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2/", name = "consultarEstatPartida")
    public JAXBElement<ConsultarEstatPartida> createConsultarEstatPartida(ConsultarEstatPartida value) {
        return new JAXBElement<ConsultarEstatPartida>(_ConsultarEstatPartida_QNAME, ConsultarEstatPartida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarEstatPartidaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2/", name = "consultarEstatPartidaResponse")
    public JAXBElement<ConsultarEstatPartidaResponse> createConsultarEstatPartidaResponse(ConsultarEstatPartidaResponse value) {
        return new JAXBElement<ConsultarEstatPartidaResponse>(_ConsultarEstatPartidaResponse_QNAME, ConsultarEstatPartidaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetLlistaPartidesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2/", name = "setLlistaPartidesResponse")
    public JAXBElement<SetLlistaPartidesResponse> createSetLlistaPartidesResponse(SetLlistaPartidesResponse value) {
        return new JAXBElement<SetLlistaPartidesResponse>(_SetLlistaPartidesResponse_QNAME, SetLlistaPartidesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetLlistaPartides }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2/", name = "setLlistaPartides")
    public JAXBElement<SetLlistaPartides> createSetLlistaPartides(SetLlistaPartides value) {
        return new JAXBElement<SetLlistaPartides>(_SetLlistaPartides_QNAME, SetLlistaPartides.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcabarJoc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2/", name = "acabarJoc")
    public JAXBElement<AcabarJoc> createAcabarJoc(AcabarJoc value) {
        return new JAXBElement<AcabarJoc>(_AcabarJoc_QNAME, AcabarJoc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLlistaPartides }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2/", name = "getLlistaPartides")
    public JAXBElement<GetLlistaPartides> createGetLlistaPartides(GetLlistaPartides value) {
        return new JAXBElement<GetLlistaPartides>(_GetLlistaPartides_QNAME, GetLlistaPartides.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MoureJugadorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2/", name = "moureJugadorResponse")
    public JAXBElement<MoureJugadorResponse> createMoureJugadorResponse(MoureJugadorResponse value) {
        return new JAXBElement<MoureJugadorResponse>(_MoureJugadorResponse_QNAME, MoureJugadorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarJocResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2/", name = "iniciarJocResponse")
    public JAXBElement<IniciarJocResponse> createIniciarJocResponse(IniciarJocResponse value) {
        return new JAXBElement<IniciarJocResponse>(_IniciarJocResponse_QNAME, IniciarJocResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLlistaPartidesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2/", name = "getLlistaPartidesResponse")
    public JAXBElement<GetLlistaPartidesResponse> createGetLlistaPartidesResponse(GetLlistaPartidesResponse value) {
        return new JAXBElement<GetLlistaPartidesResponse>(_GetLlistaPartidesResponse_QNAME, GetLlistaPartidesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcabarJocResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2/", name = "acabarJocResponse")
    public JAXBElement<AcabarJocResponse> createAcabarJocResponse(AcabarJocResponse value) {
        return new JAXBElement<AcabarJocResponse>(_AcabarJocResponse_QNAME, AcabarJocResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MoureJugador }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2/", name = "moureJugador")
    public JAXBElement<MoureJugador> createMoureJugador(MoureJugador value) {
        return new JAXBElement<MoureJugador>(_MoureJugador_QNAME, MoureJugador.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarJoc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://daw2/", name = "iniciarJoc")
    public JAXBElement<IniciarJoc> createIniciarJoc(IniciarJoc value) {
        return new JAXBElement<IniciarJoc>(_IniciarJoc_QNAME, IniciarJoc.class, null, value);
    }

}
