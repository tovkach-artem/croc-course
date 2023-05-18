package ru.croc.course.database.init.script.impl;

import ru.croc.course.database.datasource.DataSourceProvider;
import ru.croc.course.database.init.script.DataScriptDatabaseInitializer;
import ru.croc.course.property.PropertyContainer;

import java.net.URISyntaxException;
import java.nio.file.Path;

public class BasicResourcesDataScriptDatabaseInitializer extends DataScriptDatabaseInitializer {

    private static final String BASIC_DATA_SCRIPT_KEY = "db.data.script";
    private static final Path PATH_TO_BASIC_RESOURCES_DATA_SCRIPT;

    static {
        try {
            PATH_TO_BASIC_RESOURCES_DATA_SCRIPT = Path.of(ClassLoader.getSystemResource(PropertyContainer.getProperty(BASIC_DATA_SCRIPT_KEY)).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public BasicResourcesDataScriptDatabaseInitializer(DataSourceProvider dataSourceProvider) {
        super(PATH_TO_BASIC_RESOURCES_DATA_SCRIPT, dataSourceProvider);
    }
}
