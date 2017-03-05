package ru.efremenkov.config.cache;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.expiry.Duration;
import ru.efremenkov.business.model.GetWeatherRs;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.ehcache.config.builders.CacheConfigurationBuilder.newCacheConfigurationBuilder;
import static org.ehcache.config.builders.ResourcePoolsBuilder.newResourcePoolsBuilder;
import static org.ehcache.expiry.Expirations.timeToLiveExpiration;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public class CacheConfig {
    private static long duration = 3;
    private static long heapSize = 10;
    private static long offheapSize = 10;
    private static long diskMemSize = 20;

    public static void setDuration(long duration) {
        CacheConfig.duration = duration;
    }

    public static void setHeapSize(long heapSize) {
        CacheConfig.heapSize = heapSize;
    }

    public static void setOffheapSize(long offheapSize) {
        CacheConfig.offheapSize = offheapSize;
    }

    public static void setDiskMemSize(long diskMemSize) {
        CacheConfig.diskMemSize = diskMemSize;
    }

    public static CacheConfiguration<String, GetWeatherRs> getWeatherCacheConfig() {
        return newCacheConfigurationBuilder(String.class, GetWeatherRs.class,
            newResourcePoolsBuilder()
                .heap(heapSize, EntryUnit.ENTRIES)
                .offheap(offheapSize, MemoryUnit.MB))
            .withExpiry(timeToLiveExpiration(Duration.of(duration, MINUTES)))
            .build();
    }

    public static CacheConfiguration<String, GetWeatherRs> getWeatherDiskCacheConfig() {
        return newCacheConfigurationBuilder(String.class, GetWeatherRs.class,
            newResourcePoolsBuilder()
                .heap(heapSize, EntryUnit.ENTRIES)
                .offheap(offheapSize, MemoryUnit.MB)
                .disk(diskMemSize, MemoryUnit.MB))
            .withExpiry(timeToLiveExpiration(Duration.of(duration, MINUTES)))
            .build();
    }
}
