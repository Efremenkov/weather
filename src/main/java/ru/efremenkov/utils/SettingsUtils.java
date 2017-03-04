package ru.efremenkov.utils;

import java.util.ResourceBundle;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public class SettingsUtils {
    private static final String BUNDLE_NAME = "settings";
    private static ResourceBundle bundle = getBundle();

    public static String getProperty(final String key) {
        return bundle.getString(key);
    }

    private static ResourceBundle getBundle() {
        return ResourceBundle.getBundle(BUNDLE_NAME);
    }
}
