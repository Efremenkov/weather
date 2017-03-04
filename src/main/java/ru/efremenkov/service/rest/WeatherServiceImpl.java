package ru.efremenkov.service.rest;

import ru.efremenkov.business.BusinessException;
import ru.efremenkov.service.facade.WeatherClient;
import ru.efremenkov.service.facade.WeatherClientImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
@Path("/v1")
public class WeatherServiceImpl extends RestServiceBase implements WeatherService {

    @Override
    @GET
    @Produces("text/plain")
    @Path("/weather")
    public Response getWeather(@QueryParam("lon") String longitude,
                               @QueryParam("lat") String latitude) {

        try {
            WeatherClient weatherClient = new WeatherClientImpl();
        return responseWithOkStatus(weatherClient.getTemperature(longitude, latitude));
        }
        catch (BusinessException e) {
            return responseWithErrorStatus(e);
        }
    }
}

