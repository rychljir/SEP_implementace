package cz.cvut.sep.rychljir.controllers;

import cz.cvut.sep.rychljir.customerDatabase.CustomerDetailType;
import cz.cvut.sep.rychljir.objects.OwnCustomer;
import cz.cvut.sep.rychljir.objects.Request;
import cz.cvut.sep.rychljir.objects.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Holder;
import java.math.BigInteger;
import java.util.ArrayList;

@Controller
public class EditController {

    @Autowired
    RequestRepository reqRep;

    @RequestMapping("/edit")
    public String detail(Model model, @RequestParam(value="id") BigInteger id,@RequestParam(value="status") String status) {
        APIController cont = APIController.getInstance();
        CustomerDetailType customer = new CustomerDetailType();

        Holder<BigInteger> idHolder = new Holder<>(id);
        Holder<String> statusHolder = new Holder<>(status);
        Holder<CustomerDetailType> customerDetailTypeHolder = new Holder<>(customer);

        cont.getWsdl().readCustomerDetails(idHolder,statusHolder,customerDetailTypeHolder);
        CustomerDetailType cdt = customerDetailTypeHolder.value;
        model.addAttribute("client",cdt);
        model.addAttribute("id",id);

        int statusIndex = 0;
        switch (status){
            case "Active":
                statusIndex = 1;
                break;
            case "Suspended":
                statusIndex = 2;
                break;
            case "Refunded":
                statusIndex = 3;
                break;
            case "Deactivated":
                statusIndex = 4;
                break;
            default:
                break;
        }
        model.addAttribute("status",statusIndex);
        OwnCustomer oc = new OwnCustomer(cdt);
       // oc.setStat(new BigInteger(Integer.toString(statusIndex)));
        oc.setId(id);
        model.addAttribute("customer", oc);

        return "edit";
    }

    @PostMapping("/edit")
    public String pushChanges(@ModelAttribute("customer") OwnCustomer customer) {
        Request r = new Request();
        r.setCustomer(customer);
        r.setUser_id(customer.getId());
        r.setRequestType("Change");
        switch (customer.getStat().intValue()){
            case 0:
                String status = "";
                APIController cont = APIController.getInstance();
                CustomerDetailType detail = new CustomerDetailType();
                Holder<BigInteger> idHolder = new Holder<>(customer.getId());
                Holder<String> statusHolder = new Holder<>(status);
                Holder<CustomerDetailType> customerDetailTypeHolder = new Holder<>(detail);
                cont.getWsdl().readCustomerDetails(idHolder,statusHolder,customerDetailTypeHolder);
                status = statusHolder.value;
                r.setStatus(status);
                break;
            case 1:
                r.setStatus("Active");
                break;
            case 2:
                r.setStatus("Suspended");
                break;
            case 3:
                r.setStatus("Refunded");
                break;
            case 4:
                r.setStatus("Deactivated");
                break;
        }
        reqRep.save(r);
        return "redirect:requests";
    }


}
