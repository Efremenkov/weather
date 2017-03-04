package ru.efremenkov.business.cache;

import org.ehcache.CacheManager;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public class CacheManagerKeeper {
    private static CacheManager cacheManager;

    public static void setCacheManager(CacheManager cacheManager) {
        CacheManagerKeeper.cacheManager = cacheManager;
    }

    public static void shutdown() {
        if (cacheManager != null) {
            cacheManager.close();
        }
    }
}
