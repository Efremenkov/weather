package ru.efremenkov.business.model;

/**
 * @author efremenkov
 * @ created 05.03.2017
 * $Author$
 * $Revision$
 */
public class WeatherInfo {
    private String country;
    private String location;
    private Double maxT;
    private Double minT;

    public WeatherInfo(String country, String location, Double maxT, Double minT) {
        this.country = country;
        this.location = location;
        this.maxT = maxT;
        this.minT = minT;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getMaxT() {
        return maxT;
    }

    public void setMaxT(Double maxT) {
        this.maxT = maxT;
    }

    public Double getMinT() {
        return minT;
    }

    public void setMinT(Double minT) {
        this.minT = minT;
    }
}
