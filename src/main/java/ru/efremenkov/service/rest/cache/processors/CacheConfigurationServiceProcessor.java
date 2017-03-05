package ru.efremenkov.service.rest.cache.processors;

import ru.efremenkov.business.BusinessException;
import ru.efremenkov.business.cache.CacheManagerKeeper;
import ru.efremenkov.config.cache.CacheConfig;
import ru.efremenkov.service.facade.CacheableClientImplBase;

/**
 * @author efremenkov
 * @ created 05.03.2017
 * $Author$
 * $Revision$
 */
public class CacheConfigurationServiceProcessor {

    public String processSettings(long heapSize, long offheapSize, long diskMemSize, long duration)
        throws BusinessException {
        CacheManagerKeeper.shutdown();
        CacheConfig.setHeapSize(heapSize);
        CacheConfig.setOffheapSize(offheapSize);
        CacheConfig.setDiskMemSize(diskMemSize);
        CacheConfig.setDuration(duration);
        return "";
    }

    public String processChangeSource() {
        CacheableClientImplBase.changeCacheSource();
        return "";
    }
}
