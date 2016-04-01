package com.ngrogan.customer_distance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ngrogan.customer_distance.model.Customer;

public class CustomerTest {
    private Customer customer;
    
    @Before
    public void setUp(){
        customer = new Customer(1, "Neil Grogan", -57.1020290, 33.0022323);
    }
    
    @Test
    public void getCustomerID(){
        assertEquals(customer.getUserId(), 1);
    }
    
    @Test
    public void getCustomerName(){
        assertEquals(customer.getName(), "Neil Grogan");
    }
    
    @Test
    public void getCustomerLatitude(){
        assertTrue(customer.getGeoPoint().getLatitude() == -57.1020290);
    }
    
    @Test
    public void getCustomerLongitude(){
        assertTrue(customer.getGeoPoint().getLongitude() == 33.0022323);
    }
    
    @Test
    public void getToString(){
        final String expectedResult = "[user_id:1, name:Neil Grogan]";
        final String actualResult = customer.toString();
        assertTrue(expectedResult.equals(actualResult));
    }
}
