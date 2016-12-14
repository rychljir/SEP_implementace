package cz.cvut.sep.rychljir.controllers;

import cz.cvut.sep.rychljir.customerDatabase.CustomerDetailType;
import cz.cvut.sep.rychljir.objects.OwnCustomer;
import cz.cvut.sep.rychljir.objects.Request;
import cz.cvut.sep.rychljir.objects.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.Holder;
import java.math.BigInteger;
import java.util.ArrayList;

@Controller
public class NewClientController {

    @Autowired
    RequestRepository reqRep;

    @RequestMapping("/newClient")
    public String detail(Model model) {
        model.addAttribute("customer", new OwnCustomer());
        return "newClient";
    }

    @PostMapping("/newClient")
    public String pushChanges(@ModelAttribute("customer") OwnCustomer customer) {
        Request r = new Request();
        r.setCustomer(customer);
        r.setStatus("Active");
        r.setRequestType("New");
        reqRep.save(r);
        return "redirect:requests";
    }


}
