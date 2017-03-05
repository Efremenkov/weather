package ru.efremenkov.service.facade;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.glassfish.hk2.api.Factory;
import ru.efremenkov.config.cache.CacheManagerFactory;

/**
 * @author efremenkov
 * @ created 05.03.2017
 * $Author$
 * $Revision$
 */
public abstract class CacheableClientImplBase {
    private static CacheManager cacheManager;
    private static boolean useDiskCache = false;

    protected CacheableClientImplBase() {
        if(cacheManager == null) {
            Factory<CacheManager> cacheFactory = new CacheManagerFactory();
            cacheManager = cacheFactory.provide();
        }
    }

    public static void changeCacheSource() {
        useDiskCache = !useDiskCache;
    }

    protected <T> Cache<String, T> getCache(String service, Class<T> responseType) {
        if(useDiskCache) {
            return cacheManager.getCache(service + "-disk", String.class, responseType);
        }
        return cacheManager.getCache(service, String.class, responseType);
    }
}
