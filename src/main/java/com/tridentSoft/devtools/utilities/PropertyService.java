package com.tridentSoft.devtools.utilities;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertyService {

    private final Environment environment;

    public PropertyService(Environment environment) {
        this.environment = environment;
    }

    /**
     * Fetch property by name at runtime
     */
    public String getProperty(String propertyName) {
        return environment.getProperty(propertyName);
    }

    /**
     * Fetch property with default value
     */
    public String getProperty(String propertyName, String defaultValue) {
        return environment.getProperty(propertyName, defaultValue);
    }

    /**
     * Fetch and convert to Integer
     */
    public Integer getIntProperty(String propertyName, Integer defaultValue) {
        return environment.getProperty(propertyName, Integer.class, defaultValue);
    }

    /**
     * Fetch and convert to Boolean
     */
    public Boolean getBooleanProperty(String propertyName, Boolean defaultValue) {
        return environment.getProperty(propertyName, Boolean.class, defaultValue);
    }
}