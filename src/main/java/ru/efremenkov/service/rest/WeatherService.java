package ru.efremenkov.service.rest;

import javax.ws.rs.core.Response;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public interface WeatherService {

    Response getWeather(String longitude, String latitude);
}
