package ru.efremenkov.config.cache;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.glassfish.hk2.api.Factory;
import ru.efremenkov.business.cache.CacheManagerKeeper;

import java.io.File;

import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManagerBuilder;
import static ru.efremenkov.config.cache.CacheConfig.WEATHER;
import static ru.efremenkov.config.cache.CacheConfig.WEATHER_DISK;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public class CacheManagerFactory implements Factory<CacheManager> {

    @Override
    public CacheManager provide() {
        CacheManager cacheManager = newCacheManagerBuilder()
            .with(CacheManagerBuilder.persistence(getStoragePath()))
            .withCache(Caches.WEATHER.toString(), WEATHER)
            .withCache(Caches.WEATHER_DISK.toString(), WEATHER_DISK)
            .build(true);
        CacheManagerKeeper.setCacheManager(cacheManager);
        return cacheManager;
    }

    @Override
    public void dispose(CacheManager cacheManager) {

    }

    private String getStoragePath() {
        return File.separator + "caches" + File.separator + "weather-service";
    }
}
