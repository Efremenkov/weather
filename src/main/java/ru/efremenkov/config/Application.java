package ru.efremenkov.config;

import org.glassfish.jersey.server.ResourceConfig;


public class Application extends ResourceConfig {
    private static final String SERVICE_PACKAGE = "ru.efremenkov.service";

    public Application() {
        registerPackages();
    }

    private void registerPackages() {
        packages(SERVICE_PACKAGE);
    }
}