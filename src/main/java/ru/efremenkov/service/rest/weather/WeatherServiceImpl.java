package ru.efremenkov.service.rest.weather;

import com.google.gson.Gson;
import ru.efremenkov.business.BusinessException;
import ru.efremenkov.service.facade.CacheableWeatherClientImpl;
import ru.efremenkov.service.facade.WeatherClient;
import ru.efremenkov.service.rest.RestServiceBase;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/weather")
    public Response getWeather(@QueryParam("lon") String longitude,
                               @QueryParam("lat") String latitude) {
        Gson gson = new Gson();
        try {
            WeatherClient weatherClient = new CacheableWeatherClientImpl();
            return responseWithOkStatus(gson.toJson(weatherClient.getWeatherInfo(longitude, latitude)));
        }
        catch (BusinessException e) {
            return responseWithErrorStatus(gson.toJson(new ErrorResponseMessage(e.getMessage())));
        }
    }
}

