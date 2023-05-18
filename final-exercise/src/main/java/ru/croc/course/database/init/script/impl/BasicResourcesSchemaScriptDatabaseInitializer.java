package ru.croc.course.database.init.script.impl;

import ru.croc.course.database.datasource.DataSourceProvider;
import ru.croc.course.database.init.script.SchemaScriptDatabaseInitializer;
import ru.croc.course.property.PropertyContainer;

import java.net.URISyntaxException;
import java.nio.file.Path;

public class BasicResourcesSchemaScriptDatabaseInitializer extends SchemaScriptDatabaseInitializer {
    private static final String BASIC_SCHEMA_SCRIPT_KEY = "db.schema.script";
    private static final Path PATH_TO_BASIC_RESOURCES_SCHEMA_SCRIPT;

    static {
        try {
            PATH_TO_BASIC_RESOURCES_SCHEMA_SCRIPT = Path.of(ClassLoader.getSystemResource(PropertyContainer.getProperty(BASIC_SCHEMA_SCRIPT_KEY)).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public BasicResourcesSchemaScriptDatabaseInitializer(DataSourceProvider dataSourceProvider) {
        super(PATH_TO_BASIC_RESOURCES_SCHEMA_SCRIPT, dataSourceProvider);
    }
}
