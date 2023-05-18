package ru.croc.course.database.init.script;

import ru.croc.course.database.datasource.DataSourceProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DataScriptDatabaseInitializer extends AbstractScriptDatabaseInitializer {

    private final static ScriptType SCRIPT_TYPE = ScriptType.DATA;

    public DataScriptDatabaseInitializer(Path pathToScript, DataSourceProvider dataSourceProvider) {
        super(pathToScript, SCRIPT_TYPE, dataSourceProvider);
    }

    @Override
    public void initializeDatabase() {
        try (Connection connection = getDataSourceProvider().getDataSource().getConnection()) {
            String dataSqlScript = Files.readString(getPathToScript());
            Statement statement = connection.createStatement();
            statement.executeUpdate(dataSqlScript);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
