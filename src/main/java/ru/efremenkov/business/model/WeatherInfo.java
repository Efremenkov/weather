package ru.efremenkov.business.model;

import java.io.Serializable;

/**
 * @author efremenkov
 * @ created 05.03.2017
 * $Author$
 * $Revision$
 */
public class WeatherInfo implements Serializable {

    public WeatherInfo(String country, String location, Double maxT, Double minT) {
        this.country = country;
        this.location = location;
        this.maxT = maxT;
        this.minT = minT;
    }

    public String country;
    public String location;
    public Double maxT;
    public Double minT;
}
