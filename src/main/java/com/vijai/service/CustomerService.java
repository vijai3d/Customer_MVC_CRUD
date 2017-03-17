package com.vijai.service;

import com.vijai.entity.Customer;

import java.util.List;

/**
 * Created by Victor on 15.03.2017.
 */
public interface CustomerService {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);


    void deleteCustomer(int theId);
}
