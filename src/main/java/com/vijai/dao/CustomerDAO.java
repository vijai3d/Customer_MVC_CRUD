package com.vijai.dao;

import com.vijai.entity.Customer;

import java.util.List;

/**
 * Created by Victor on 14.03.2017.
 */
public interface CustomerDAO {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
