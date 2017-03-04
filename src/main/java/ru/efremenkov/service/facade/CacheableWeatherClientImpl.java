package ru.efremenkov.service.facade;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.glassfish.hk2.api.Factory;
import ru.efremenkov.business.BusinessException;
import ru.efremenkov.business.model.GetWeatherRs;
import ru.efremenkov.config.cache.CacheManagerFactory;
import ru.efremenkov.config.cache.Caches;
import ru.efremenkov.service.client.JsonClient;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public class CacheableWeatherClientImpl implements WeatherClient {
    private static CacheManager cacheManager;
    private JsonClient jsonClient;

    public CacheableWeatherClientImpl() {
        if(cacheManager == null) {
            Factory<CacheManager> cacheFactory = new CacheManagerFactory();
            cacheManager = cacheFactory.provide();
        }
        jsonClient = new JsonClient();
    }

    @Override
    public String getLocation(String longitude, String latitude) throws BusinessException {
        Cache<String, GetWeatherRs> cache = cacheManager.getCache(Caches.WEATHER.toString(), String.class, GetWeatherRs.class);
        GetWeatherRs getWeatherRs = cache.get(getCacheKey(longitude, latitude));
        if(getWeatherRs == null) {
            getWeatherRs = jsonClient.getWeather(longitude, latitude);
            cache.put(getCacheKey(longitude, latitude), getWeatherRs);
        }
        return String.format("Country %s, location %s",
            getWeatherRs.loc.country,
            getWeatherRs.loc.name);
    }

    @Override
    public String getTemperature(String longitude, String latitude) throws BusinessException {
        Cache<String, GetWeatherRs> cache = cacheManager.getCache(Caches.WEATHER.toString(), String.class, GetWeatherRs.class);
        GetWeatherRs getWeatherRs = cache.get(getCacheKey(longitude, latitude));
        if(getWeatherRs == null) {
            getWeatherRs = jsonClient.getWeather(longitude, latitude);
            cache.put(getCacheKey(longitude, latitude), getWeatherRs);
        }
        return String.format("max T: %s, min T: %s",
            getWeatherRs.fcd.get(0).tx,
            getWeatherRs.fcd.get(0).tn);
    }

    private String getCacheKey(final String longitude, final String latitude) {
        return longitude + "&" + latitude;
    }
}
