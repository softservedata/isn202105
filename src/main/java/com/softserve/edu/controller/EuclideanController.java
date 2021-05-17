package com.softserve.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.softserve.edu.service.EuclideanService;

@Controller
public class EuclideanController {

    private EuclideanService euclideanService;

    @Value("${welcome.message}")
    private String message;

    @Autowired
    public EuclideanController(EuclideanService euclideanService) {
        this.euclideanService = euclideanService;
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping("/gcd")
    public String getOperation(Model model,
            @RequestParam(value = "arg0", required = false, defaultValue = "0")
            String arg0,
            @RequestParam(value = "arg1", required = false, defaultValue = "0")
            String arg1) {
        String result = euclideanService.calculateGCD(arg0, arg1);
        model.addAttribute("arg0", arg0);
        model.addAttribute("arg1", arg1);
        model.addAttribute("result", result);
        return "gcd";
    }
}
