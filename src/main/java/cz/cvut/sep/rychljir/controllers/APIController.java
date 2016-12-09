package cz.cvut.sep.rychljir.controllers;

import cz.cvut.sep.rychljir.customerDatabase.CustomerDatabase;
import cz.cvut.sep.rychljir.customerDatabase.CustomerDatabaseWSDL;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Speedy on 8. 12. 2016.
 */
public class APIController {
        private static APIController cont;
        private CustomerDatabaseWSDL wsdl;

        public static APIController getInstance(){
            if(cont == null){
                cont = new APIController();
            }
            return cont;
        }

        public APIController() {
            try {
                final URL url = new URL("http://localhost:8088/MockCustomerDatabaseSOAP?wsdl");
                final CustomerDatabase customDb = new CustomerDatabase(url);
                wsdl = customDb.getCustomerDatabaseSOAP();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        public CustomerDatabaseWSDL getWsdl() {
            return wsdl;
        }
}
