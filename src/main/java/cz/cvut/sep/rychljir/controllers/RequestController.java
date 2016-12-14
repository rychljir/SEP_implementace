package cz.cvut.sep.rychljir.controllers;

import cz.cvut.sep.rychljir.customerDatabase.CustomerDetailType;
import cz.cvut.sep.rychljir.customerDatabase.CustomerType;
import cz.cvut.sep.rychljir.objects.Request;
import cz.cvut.sep.rychljir.objects.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Holder;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class RequestController {

    @Autowired
    RequestRepository reqRep;

    private static List<CustomerType> customers = new LinkedList<>();


    @RequestMapping(value={"/requests"})
    public String customers(Model model) {
    ArrayList<Request> requests = new ArrayList<>();
    for (Request rep : reqRep.findAll()) {
        requests.add(rep);
    }
        model.addAttribute("allRequests",requests);

        return "requests";
    }

    @RequestMapping("/requests_removed")
    public String detail(Model model, @RequestParam(value="id") Integer id) {
        reqRep.delete(id);
        return "requests_removed";
    }


}
