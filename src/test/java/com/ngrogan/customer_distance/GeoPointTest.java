package com.ngrogan.customer_distance;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ngrogan.customer_distance.model.GeoPoint;

public class GeoPointTest {
    private GeoPoint geopoint;
    
    @Before
    public void setUp(){
        geopoint = new GeoPoint(-57.1020290, 33.0022323);
    }
    
    @Test
    public void getLatLon(){
        assertTrue(geopoint.getLatitude() == -57.1020290);
        assertTrue(geopoint.getLongitude() == 33.0022323);
    }
    
    @Test
    public void getLatLonRadians(){
        double latInRadians = Math.toRadians(-57.1020290);
        double lonInRadians = Math.toRadians(33.0022323);
        
        assertTrue(geopoint.getLatitudeInRadians() == latInRadians);
        assertTrue(geopoint.getLongitudeInRadians() == lonInRadians);
    }
    

}
