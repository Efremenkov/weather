package ru.efremenkov.business.cache;

import org.ehcache.CacheManager;
import org.glassfish.hk2.api.Factory;
import ru.efremenkov.config.cache.CacheManagerFactory;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public class CacheManagerKeeper {
    private static CacheManager cacheManager;

    public static CacheManager getCacheManager(){
        if(cacheManager == null) {
            return initializeCacheManager();
        }
        return cacheManager;
    }

    public static void shutdown() {
        if (cacheManager != null) {
            cacheManager.close();
            cacheManager = null;
        }
    }

    private static CacheManager initializeCacheManager() {
        Factory<CacheManager> cacheFactory = new CacheManagerFactory();
        cacheManager = cacheFactory.provide();
        return cacheManager;
    }
}
