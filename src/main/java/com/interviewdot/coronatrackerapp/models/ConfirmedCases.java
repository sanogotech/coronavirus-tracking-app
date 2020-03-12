package com.interviewdot.coronatrackerapp.models;

import java.util.List;

public class ConfirmedCases {
    private String last_updated;
    private String latest;
    private List<LocationData> locations;

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public List<LocationData> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationData> locations) {
        this.locations = locations;
    }
}
