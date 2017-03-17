package com.vijai.controller;


import com.vijai.entity.Customer;
import com.vijai.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Victor on 14.03.2017.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    //need to inject customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {

        // get customers from service
        List<Customer> theCustomers = customerService.getCustomers();
        // add the customers to the model
        model.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormAdd")
    public String showFormFoeAdd(Model theModel) {

        // create model attribute to bind form data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);
        return "add-customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        // save the customer usin sevice
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForCustomer(@RequestParam("customerId") int theId, Model theModel) {
        //get the customer from the service
        Customer theCustomer = customerService.getCustomer(theId);
        //set a customer as the model attribute to pre-populate form
        theModel.addAttribute("customer", theCustomer);
        //send over to our form
        return "add-customer";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId, Model theModel) {

        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }
}
