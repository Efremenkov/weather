package ru.efremenkov.config.cache;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public enum Caches {
    WEATHER("weather");

    private final String value;

    Caches(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
