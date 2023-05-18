package ru.croc.course.config;

import ru.croc.course.database.datasource.DataSourceProvider;
import ru.croc.course.property.PropertyContainer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {

    private static final String SCHEMA_SCRIPT = "db.schema.script";
    private static final String DATA_SCRIPT = "db.data.script";

    private DataSourceProvider dataSourceProvider;


    public DatabaseConfig(DataSourceProvider dataSourceProvider) {
        this.dataSourceProvider = dataSourceProvider;
        initDatabase();
    }

    public DataSourceProvider getDataSourceProvider() {
        return dataSourceProvider;
    }

    private void initDatabase() {
        try {
            prepareDatabaseScheme();
            importTestData();
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void prepareDatabaseScheme() throws URISyntaxException, IOException {
        String schemaSqlScript = Files.readString(Path.of(ClassLoader.getSystemResource(PropertyContainer.getProperty(SCHEMA_SCRIPT)).toURI()));
        try (Connection connection = dataSourceProvider.getDataSource().getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(schemaSqlScript);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void importTestData() throws URISyntaxException, IOException {
        String dataSqlScript = Files.readString(Path.of(ClassLoader.getSystemResource(PropertyContainer.getProperty(DATA_SCRIPT)).toURI()));
        try (Connection connection = dataSourceProvider.getDataSource().getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(dataSqlScript);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
