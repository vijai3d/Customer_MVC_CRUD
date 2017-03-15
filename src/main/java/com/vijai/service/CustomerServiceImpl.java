package com.vijai.service;

import com.vijai.dao.CustomerDAO;
import com.vijai.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Victor on 15.03.2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    // need to inject customaer dao
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
}
