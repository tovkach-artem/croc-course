package ru.croc.course.property;

import java.io.IOException;
import java.util.Properties;

public final class PropertyContainer {

    private static final Properties APPLICATION_PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    public static String getProperty(String key) {
        return APPLICATION_PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try(var inputStream = PropertyContainer.class.getClassLoader().getResourceAsStream("application.properties")){
            APPLICATION_PROPERTIES.load(inputStream);
        }catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
