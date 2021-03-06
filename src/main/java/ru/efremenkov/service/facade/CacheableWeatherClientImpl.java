package ru.efremenkov.service.facade;

import org.ehcache.Cache;
import ru.efremenkov.business.BusinessException;
import ru.efremenkov.business.model.GetWeatherRs;
import ru.efremenkov.business.model.WeatherInfo;
import ru.efremenkov.config.cache.Caches;
import ru.efremenkov.service.client.JsonClient;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public class CacheableWeatherClientImpl extends CacheableClientImplBase implements WeatherClient {
    private JsonClient jsonClient;

    public CacheableWeatherClientImpl() {
        jsonClient = new JsonClient();
    }

    @Override
    public WeatherInfo getWeatherInfo(String longitude, String latitude) throws BusinessException {
        Cache<String, GetWeatherRs> cache = getCache(Caches.WEATHER.toString(), GetWeatherRs.class);
        GetWeatherRs getWeatherRs = cache.get(getCacheKey(longitude, latitude));
        if(getWeatherRs == null) {
            getWeatherRs = jsonClient.getWeather(longitude, latitude);
            cache.put(getCacheKey(longitude, latitude), getWeatherRs);
        }
        return new WeatherInfo(
            getWeatherRs.loc.country,
            getWeatherRs.loc.name,
            getWeatherRs.fcd.get(0).tx,
            getWeatherRs.fcd.get(0).tn);
    }

    private String getCacheKey(final String longitude, final String latitude) {
        return longitude + "&" + latitude;
    }
}
