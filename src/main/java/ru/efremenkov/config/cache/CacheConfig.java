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
    public static CacheConfiguration<String, GetWeatherRs> WEATHER =
        newCacheConfigurationBuilder(String.class, GetWeatherRs.class,
            newResourcePoolsBuilder()
                .heap(10, EntryUnit.ENTRIES)
                .offheap(10, MemoryUnit.MB))
            .withExpiry(timeToLiveExpiration(Duration.of(3, MINUTES)))
            .build();

    public static CacheConfiguration<String, GetWeatherRs> WEATHER_DISK =
        newCacheConfigurationBuilder(String.class, GetWeatherRs.class,
            newResourcePoolsBuilder()
                .heap(10, EntryUnit.ENTRIES)
                .offheap(10, MemoryUnit.MB)
                .disk(20, MemoryUnit.MB))
            .withExpiry(timeToLiveExpiration(Duration.of(3, MINUTES)))
            .build();
}
