package com.ngrogan.customer_distance.model;

import com.google.gson.annotations.SerializedName;

public class Customer {
    @SerializedName("user_id")
    private int userId;
    private String name;
    private double latitude;
    private double longitude;

    public Customer(final int userId, final String name, 
            final double latitude, final double longitude){
        this.userId = userId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    
    public GeoPoint getGeoPoint() {
        return new GeoPoint(latitude, longitude);
    }

    public String toString(){
        return "[user_id:"+userId+", name:"+name+", latitude:"+latitude+", longitude:"+longitude+"]";
    }
}
