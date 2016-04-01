package com.ngrogan.customer_distance;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ngrogan.customer_distance.model.Customer;

public class CalculateDistanceTest {

    @Test
    public void customerShouldBeInvited(){
    	Customer customer = new Customer(1, "Intercom", 53.3381985, -6.2592576);
    	List<Customer> customerList = new ArrayList<Customer>();
    	customerList.add(customer);

    	CalculateDistance cd = new CalculateDistance(customerList);
        List<Customer> customersToBeInvited = cd.getCustomersWithinRange();

        assertTrue(customersToBeInvited.get(0) == customer);
    }
    
    @Test
    public void customerShouldNotBeInvited(){
    	Customer customer = new Customer(1, "Darth Vader", 56.3381985, -3.2592576);
    	List<Customer> customerList = new ArrayList<Customer>();
    	customerList.add(customer);

    	CalculateDistance cd = new CalculateDistance(customerList);
        List<Customer> customersToBeInvited = cd.getCustomersWithinRange();

        assertTrue(customersToBeInvited.isEmpty());
    }
    
}
