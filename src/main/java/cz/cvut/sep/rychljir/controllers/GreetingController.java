package cz.cvut.sep.rychljir.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class GreetingController {

    private static List<String> infoList = new LinkedList<>();

    static {
        infoList.add("A");
        infoList.add("B");
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("infoList", infoList);

        return "greeting";
    }

    @PostMapping("/add")
    public String addSubmit(@RequestParam(value="info", required=true) String info) {
        infoList.add(info);
        return "redirect:greeting";
    }



}
