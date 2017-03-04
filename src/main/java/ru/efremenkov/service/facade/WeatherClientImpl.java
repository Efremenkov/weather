package ru.efremenkov.service.facade;

import ru.efremenkov.business.BusinessException;
import ru.efremenkov.business.model.GetWeatherRs;
import ru.efremenkov.service.client.JsonClient;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public class WeatherClientImpl implements WeatherClient {

    @Override
    public String getLocation(String longitude, String latitude) throws BusinessException {
        JsonClient jsonClient = new JsonClient();
        GetWeatherRs getWeatherRs = jsonClient.getWeather(longitude, latitude);
        return String.format("Country %s, location %s",
            getWeatherRs.loc.country,
            getWeatherRs.loc.name);
    }

    @Override
    public String getTemperature(String longitude, String latitude) throws BusinessException {
        JsonClient jsonClient = new JsonClient();
        GetWeatherRs getWeatherRs = jsonClient.getWeather(longitude, latitude);
        return String.format("max T: %s, min T: %s",
            getWeatherRs.fcd.get(0).tx,
            getWeatherRs.fcd.get(0).tn);
    }
}
