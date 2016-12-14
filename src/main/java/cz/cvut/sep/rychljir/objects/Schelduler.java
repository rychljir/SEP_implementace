package cz.cvut.sep.rychljir.objects;

import cz.cvut.sep.rychljir.controllers.APIController;
import cz.cvut.sep.rychljir.customerDatabase.AddressType;
import cz.cvut.sep.rychljir.customerDatabase.CreateCustomerChangeOrder;
import cz.cvut.sep.rychljir.customerDatabase.CustomerDetailType;
import cz.cvut.sep.rychljir.customerDatabase.PhoneType;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

/**
 * Created by Speedy on 14. 12. 2016.
 */
public class Schelduler extends TimerTask{
    private static RequestRepository reqRep;
    private static Schelduler instance;
    public static boolean isRunning = false;

    private Schelduler(){

    }

    @Override
    public void run() {
        for (Request rep : reqRep.findAll()) {
            OwnCustomer oc = rep.getCustomer();
            CustomerDetailType ct = new CustomerDetailType();
            ct.setFirstName(new ArrayList<String>() {{add(oc.getFirstName());}});
            ct.setSurname(new ArrayList<String>() {{add(oc.getSurName());}});
            AddressType at = new AddressType();
            at.setStreetName(oc.getStreetName());
            at.setStreetNum(oc.getStreetNum());
            at.setPostalCode(oc.getPostalCode());
            at.setCity(oc.getCity());
            at.setCityPart(oc.getCityPart());
            at.setCountry(oc.getCountry());
            at.setCounty(oc.getCounty());
            ct.setAddress(new ArrayList<AddressType>() {{add(at);}});
            PhoneType pt = new PhoneType();
            pt.setPhoneNumberType(oc.getPhoneNumberType());
            pt.setPhoneNum(oc.getPhoneNum());
            pt.setCityCode(oc.getCityCode());
            pt.setCountryCode(oc.getCountryCode());
            ct.setPhoneNum(new ArrayList<PhoneType>() {{add(pt);}});
            ct.setBirthNum(oc.getBirthNum());
            ct.setCountryOfOrigin(oc.getCountryOfOrigin());

            CreateCustomerChangeOrder ccc = new CreateCustomerChangeOrder();
            ccc.setId(new BigInteger(Integer.toString(rep.getId())));
            ccc.setCustomer(ct);
            ccc.setRequestType(rep.getRequestType());
            APIController.getInstance().getWsdl().createCustomerChangeOrder(ccc);
            reqRep.delete(rep.getId());
        }
        System.out.println("Changes pushed!");
    }

    public static Schelduler getInstance(RequestRepository reqRepos){
        reqRep = reqRepos;
        if(instance == null){
            instance = new Schelduler();
        }
        return instance;
    }

}
