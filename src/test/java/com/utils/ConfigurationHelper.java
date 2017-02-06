package com.utils;

import com.controlcenter.config.Configuration;
import com.controlcenter.manager.TestManager;

/**
 * Created by prajitmadan on 1/13/17.
 */
public class ConfigurationHelper {

    private static Configuration configuration;

    public ConfigurationHelper() {

        TestManager manager = new TestManager();
        configuration = manager.getConfiguration();
    }


    public String getpropertyvalue(String propertyname) {
        String value = "";
        if (propertyname.equalsIgnoreCase("facade")) {
            value = configuration.getFacadeType();
        }

        if (propertyname.equalsIgnoreCase("platformName")) {
            value = configuration.getPlatformName();
        }


        if (propertyname.equalsIgnoreCase("apiendpoint")) {
            value = configuration.getapiEndPoint();
        }

        if (propertyname.equalsIgnoreCase("browserstotest")) {
            value = configuration.getbrowsersToTest();
        }

        return value;

    }
}
