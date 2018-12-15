package com.isa.cm3.delegations;

public class GeoLocation {

    private Double lat;
    private Double lng;

    public GeoLocation(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("lat:").append(lat);
        sb.append(", lng:").append(lng);
        sb.append('}');
        return sb.toString();
    }
}
