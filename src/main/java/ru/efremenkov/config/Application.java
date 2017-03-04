package ru.efremenkov.config;

import org.glassfish.jersey.server.ResourceConfig;
import ru.efremenkov.web.ContextListener;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public class Application extends ResourceConfig {
    private static final String SERVICE_PACKAGE = "ru.efremenkov.service";

    public Application() {
        registerPackages();
        registerListeners();
    }

    private void registerPackages() {
        packages(SERVICE_PACKAGE);
    }

    private void registerListeners() {
        register(ContextListener.class);
    }
}