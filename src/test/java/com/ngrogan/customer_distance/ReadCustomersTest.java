package com.ngrogan.customer_distance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ngrogan.customer_distance.model.Customer;

public class ReadCustomersTest {
    private final String INVALID_FILE_PATH = "customeers.json";
    private final String VALID_FILE_PATH = "customers.json";
    private ReadCustomers rc;

    @Before
    public void setUp(){
        rc = new ReadCustomers();
    }
    
    @Test
    public void wrongFileMeansEmptyCustList(){
        List<Customer> customers = rc.readJSONFileToCustomers(INVALID_FILE_PATH);
        assertTrue(customers.isEmpty());
    }
    
    @Test
    public void customersReadIn(){
        List<Customer> customers = rc.readJSONFileToCustomers(VALID_FILE_PATH);
        assertFalse(customers.isEmpty());
    }

}
