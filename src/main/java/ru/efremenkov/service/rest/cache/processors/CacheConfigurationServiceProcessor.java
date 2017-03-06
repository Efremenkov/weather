package ru.efremenkov.service.rest.cache.processors;

import ru.efremenkov.business.BusinessException;
import ru.efremenkov.business.cache.CacheManagerProvider;
import ru.efremenkov.config.cache.CacheConfig;
import ru.efremenkov.service.facade.CacheableClientImplBase;

/**
 * @author efremenkov
 * @ created 05.03.2017
 * $Author$
 * $Revision$
 */
public class CacheConfigurationServiceProcessor {

    private static final String MSG_CONFIGURATION_ERROR = "Size must be greater than 0";

    public String processConfigure(long heapSize, long offheapSize, long diskMemSize, long duration)
        throws BusinessException {
        if(heapSize == 0 || offheapSize == 0 || diskMemSize == 0) {
            throw new BusinessException(MSG_CONFIGURATION_ERROR);
        }
        CacheManagerProvider.shutdown();
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
