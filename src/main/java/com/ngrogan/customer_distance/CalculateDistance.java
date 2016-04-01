package com.ngrogan.customer_distance;

import java.util.ArrayList;
import java.util.List;

import com.ngrogan.customer_distance.model.Customer;
import com.ngrogan.customer_distance.model.GeoPoint;

public class CalculateDistance {
    private final GeoPoint officeGeoPoint;
    private final double intercomLat = 53.3381985;
    private final double intercomLon = -6.2592576;
    private final double rangeInKilometers = 100.0;
    private final double degreeOnEarthInKM = 127.993;
    private List<Customer> allCustomers;
    private List<Customer> partyCustomers;

    public CalculateDistance(final List<Customer> customers){
        this.allCustomers = customers;
        this.officeGeoPoint = new GeoPoint(intercomLat, intercomLon);
    }
    
    public List<Customer> getCustomersWithinRange(){
        return calculateCustomersInRange(allCustomers);
    }
    
    private List<Customer> calculateCustomersInRange(final List<Customer> customers){
        partyCustomers = new ArrayList<Customer>();
        for(Customer customer : customers){
            final GeoPoint customerLocation = customer.getGeoPoint();
            if(isWithinRange(officeGeoPoint, customerLocation, rangeInKilometers)){
                partyCustomers.add(customer);
            }
        }
        return partyCustomers;
    }
    
    private boolean isWithinRange(final GeoPoint anchorPoint, 
            final GeoPoint testPoint, final double range){

        final double a1 = testPoint.getLatitudeInRadians();
        final double a2 = testPoint.getLongitudeInRadians();

        final double b1 = anchorPoint.getLatitudeInRadians();
        final double b2 = anchorPoint.getLongitudeInRadians();

        double distance = calculateGreatCircleDistanceInKM(a1, a2, b1, b2);

        if(distance <= range){
            return true;
        }

        return false;
    }

    private double calculateGreatCircleDistanceInKM(final double a1, final double a2, final double b1, final double b2){
        double angle = Math.acos(
                Math.sin(a1) * Math.sin(b1)
                + Math.cos(a1) * Math.cos(b1)
                * Math.cos(a2 - b2));

        angle = Math.toDegrees(angle);

        double distance = degreeOnEarthInKM * angle;

        return distance;
    }
}
