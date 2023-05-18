package ru.croc.course.database.init.script;

import ru.croc.course.database.datasource.DataSourceProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class SchemaScriptDatabaseInitializer extends AbstractScriptDatabaseInitializer {

    private final static ScriptType SCRIPT_TYPE = ScriptType.SCHEMA;

    public SchemaScriptDatabaseInitializer(Path pathToScript, DataSourceProvider dataSourceProvider) {
        super(pathToScript, SCRIPT_TYPE, dataSourceProvider);
    }

    @Override
    public void initializeDatabase() {
        try (Connection connection = getDataSourceProvider().getDataSource().getConnection()) {
            String schemaSqlScript = Files.readString(getPathToScript());
            Statement statement = connection.createStatement();
            statement.execute(schemaSqlScript);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
