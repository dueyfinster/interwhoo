package com.ngrogan.customer_distance.model;

public class GeoPoint {
    private final double latitude;
    private final double longitude;

    public GeoPoint(final double latitude, final double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    
    public double getLatitudeInRadians() {
        return Math.toRadians(latitude);
    }

    public double getLongitudeInRadians() {
        return Math.toRadians(longitude);
    }
}
