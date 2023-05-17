package ru.croc.course.config;

import java.io.IOException;
import java.util.Properties;

public final class ApplicationPropertiesConfig {

    private static final Properties APPLICATION_PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    public static String get(String key) {
        return APPLICATION_PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try(var inputStream = ApplicationPropertiesConfig.class.getClassLoader().getResourceAsStream("application.properties")){
            APPLICATION_PROPERTIES.load(inputStream);
        }catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
