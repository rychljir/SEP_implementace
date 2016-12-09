package cz.cvut.sep.rychljir.controllers;

import cz.cvut.sep.rychljir.customerDatabase.CustomerDetailType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.Holder;
import java.math.BigInteger;

@Controller
public class DetailController {

    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam(value="id") BigInteger id,@RequestParam(value="status") String status) {
        APIController cont = APIController.getInstance();
        CustomerDetailType customer = new CustomerDetailType();

        Holder<BigInteger> idHolder = new Holder<>(id);
        Holder<String> statusHolder = new Holder<>(status);
        Holder<CustomerDetailType> customerDetailTypeHolder = new Holder<>(customer);

        cont.getWsdl().readCustomerDetails(idHolder,statusHolder,customerDetailTypeHolder);
        model.addAttribute("client",customerDetailTypeHolder.value);

        return "detail";
    }
}
