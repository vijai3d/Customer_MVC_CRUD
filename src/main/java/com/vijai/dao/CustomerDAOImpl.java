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
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
        //execute query and get result list
        List<Customer> customers = theQuery.getResultList();
        // return the result
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        //get hte current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //save the customer...
        currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(int theId) {
        //get hte current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // retrieve/read from db using primary key
        Customer theCustomer = currentSession.get(Customer.class, theId);
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        //get hte current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //delete
        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);
        theQuery.executeUpdate();
    }
}
