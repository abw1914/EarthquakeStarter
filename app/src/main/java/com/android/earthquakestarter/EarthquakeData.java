package com.android.earthquakestarter;

public class EarthquakeData {
    private String locations;
    private double magnitude;
    private long eventDate;
    private String url;


    public EarthquakeData(String locations, double magnitude, long eventDate) {
        this.locations = locations;
        this.magnitude = magnitude;
        this.eventDate = eventDate;
    }

    public EarthquakeData(String locations, double magnitude, long eventDate, String url) {
        this.locations = locations;
        this.magnitude = magnitude;
        this.eventDate = eventDate;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public long getEventDate() {
        return eventDate;
    }

    public void setEventDate(long eventDate) {
        this.eventDate = eventDate;
    }
}