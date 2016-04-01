package com.ngrogan.customer_distance;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ngrogan.customer_distance.model.Customer;

public class CustomerComparatorTest {
    private List<Customer> customers;
    private Customer c1;
    private Customer c2;
    private Customer c3;
    
    @Before
    public void setUp(){
        customers = new ArrayList<Customer>();
        
        c1 = new Customer(1, "NG", -57.2, 33.453);
        c2 = new Customer(1, "NP", -57.2, 33.453);
        c3 = new Customer(2, "NC", -57.2, 33.453);
    }
    
    @Test
    public void higherIDIsSorted(){
        customers.add(c3);
        customers.add(c2);
        Collections.sort(customers, new CustomerComparator());


        assertTrue(customers.get(0) == c2);
        assertTrue(customers.get(1) == c3);
    }

    @Test
    public void lowerIDIsSorted(){
        customers.add(c2);
        customers.add(c3);
        Collections.sort(customers, new CustomerComparator());


        assertTrue(customers.get(0) == c2);
        assertTrue(customers.get(1) == c3);
    }

    @Test
    public void sameIdIsSorted(){
        customers.add(c1);
        customers.add(c2);
        Collections.sort(customers, new CustomerComparator());


        assertTrue(customers.get(0) == c1);
        assertTrue(customers.get(1) == c2);
    }

}
