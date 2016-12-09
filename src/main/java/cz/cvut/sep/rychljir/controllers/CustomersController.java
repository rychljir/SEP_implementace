package cz.cvut.sep.rychljir.controllers;

import cz.cvut.sep.rychljir.customerDatabase.CustomerType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class CustomersController {

    private static List<CustomerType> customers = new LinkedList<>();

    @RequestMapping(value={"/customers", "/new"})
    public String customers(Model model, HttpServletRequest request) {
        APIController cont = APIController.getInstance();
        ArrayList customers = (ArrayList) cont.getWsdl().readAllCustomers(new BigInteger("0"),new BigInteger("10"));
        model.addAttribute("allClients",customers);

        String mapping = request.getServletPath();
        if(mapping.equals("/customers")){
            return "customers";
        }else{
            return "new";
        }

    }
}
