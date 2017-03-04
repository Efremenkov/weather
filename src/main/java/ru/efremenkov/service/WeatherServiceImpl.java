package ru.efremenkov.service;

import static ru.efremenkov.utils.ResponseUtils.buildEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/v1")
public class WeatherServiceImpl implements WeatherService {

    @Override
    @GET
    @Produces("text/plain")
    @Path("/weather")
    public Response getWeather(@QueryParam("latitude") String latitude,
                               @QueryParam("longitude") String longitude) {
        return buildEntity(String.format("Latitude = %s\nLongitude = %s", latitude, longitude));
    }
}

