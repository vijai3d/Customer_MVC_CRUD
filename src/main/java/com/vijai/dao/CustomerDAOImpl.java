package com.vijai.dao;

import com.vijai.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Victor on 14.03.2017.
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // get query
        Query<Customer> theQuery = currentSession.createQuery("from Customer ", Customer.class);
        //execute query and get result list
        List<Customer> customers = theQuery.getResultList();
        // return the result
        return customers;
    }
}
