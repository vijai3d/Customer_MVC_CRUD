package com.vijai.controller;

import com.vijai.dao.CustomerDAO;
import com.vijai.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Victor on 14.03.2017.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {


    // need to inject the customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model model) {

        // get customers from dao
        List<Customer> theCustomers = customerDAO.getCustomers();
        // add the customers to the model
        model.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}
