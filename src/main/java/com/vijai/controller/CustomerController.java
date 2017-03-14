package com.vijai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Victor on 14.03.2017.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        return "list-customers";
    }
}
