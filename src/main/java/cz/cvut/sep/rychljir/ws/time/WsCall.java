package cz.cvut.sep.rychljir.ws.time;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by vjinoch on 23.11.2016.
 */
public class WsCall {

    private static final QName SERVICE_NAME = new QName("http://profinit.eu/time/util/", "TimeUtilService");

    public TimeUtilService getPort() throws MalformedURLException {
        URL wsdlURL = new URL("http://127.0.0.1:19090/timeUtilsService?WSDL");

        TimeUtilService_Service ss = new TimeUtilService_Service(wsdlURL, SERVICE_NAME);
        return ss.getTimeUtilPort();
    }

    public String getDate() throws MalformedURLException {
        TimeUtilService timeUtilService = getPort();

        String output = null;

        try {
            output = timeUtilService.getDate(false);
        } catch (TimeUtilException_Exception e) {
            e.printStackTrace();
        }

        return output;
    }


}
