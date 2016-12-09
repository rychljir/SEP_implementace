package cz.cvut.sep.rychljir.ws.time;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.8
 * 2016-11-23T19:16:09.876+01:00
 * Generated source version: 3.1.8
 * 
 */
@WebService(targetNamespace = "http://profinit.eu/time/util/", name = "TimeUtilService")
@XmlSeeAlso({ObjectFactory.class})
public interface TimeUtilService {

    @WebMethod
    @RequestWrapper(localName = "getDate", targetNamespace = "http://profinit.eu/time/util/", className = "GetDate")
    @ResponseWrapper(localName = "getDateResponse", targetNamespace = "http://profinit.eu/time/util/", className = "GetDateResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String getDate(
        @WebParam(name = "returnException", targetNamespace = "")
        boolean returnException
    ) throws TimeUtilException_Exception;
}
