package ru.efremenkov.service;

import javax.ws.rs.core.Response;

public interface WeatherService {

    Response getWeather(String latitude, String longitude);
}
