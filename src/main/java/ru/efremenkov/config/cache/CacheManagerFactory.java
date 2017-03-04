package ru.efremenkov.config.cache;

import org.ehcache.CacheManager;
import org.glassfish.hk2.api.Factory;
import ru.efremenkov.business.cache.CacheManagerKeeper;

import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManagerBuilder;
import static ru.efremenkov.config.cache.CacheConfig.WEATHER;

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
            .withCache(Caches.WEATHER.toString(), WEATHER)
            .build(true);
        CacheManagerKeeper.setCacheManager(cacheManager);
        return cacheManager;
    }

    @Override
    public void dispose(CacheManager cacheManager) {

    }
}
