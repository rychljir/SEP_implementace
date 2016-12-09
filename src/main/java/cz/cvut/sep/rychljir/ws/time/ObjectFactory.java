
package cz.cvut.sep.rychljir.ws.time;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cz.cvut.profinit.example.ws.time package. 
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

    private final static QName _GetDate_QNAME = new QName("http://profinit.eu/time/util/", "getDate");
    private final static QName _GetDateResponse_QNAME = new QName("http://profinit.eu/time/util/", "getDateResponse");
    private final static QName _TimeUtilException_QNAME = new QName("http://profinit.eu/time/util/", "TimeUtilException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cz.cvut.profinit.example.ws.time
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDate }
     * 
     */
    public GetDate createGetDate() {
        return new GetDate();
    }

    /**
     * Create an instance of {@link GetDateResponse }
     * 
     */
    public GetDateResponse createGetDateResponse() {
        return new GetDateResponse();
    }

    /**
     * Create an instance of {@link TimeUtilException }
     * 
     */
    public TimeUtilException createTimeUtilException() {
        return new TimeUtilException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://profinit.eu/time/util/", name = "getDate")
    public JAXBElement<GetDate> createGetDate(GetDate value) {
        return new JAXBElement<GetDate>(_GetDate_QNAME, GetDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://profinit.eu/time/util/", name = "getDateResponse")
    public JAXBElement<GetDateResponse> createGetDateResponse(GetDateResponse value) {
        return new JAXBElement<GetDateResponse>(_GetDateResponse_QNAME, GetDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeUtilException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://profinit.eu/time/util/", name = "TimeUtilException")
    public JAXBElement<TimeUtilException> createTimeUtilException(TimeUtilException value) {
        return new JAXBElement<TimeUtilException>(_TimeUtilException_QNAME, TimeUtilException.class, null, value);
    }

}
