package ru.croc.course.support.db;

import ru.croc.course.support.property.PropertiesUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Данный класс является инициализатором базы данных. Он содержит методы для инициализации схемы и импорта тестовых
 * данных. Класс использует {@link DataSourceProvider}, чтобы получить соединение с базой данных.
 */
public class DatabaseInitializer {

    private static final String SCHEMA_SCRIPT = "db.schema.script";
    private static final String DATA_SCRIPT = "db.data.script";

    private DataSourceProvider dataSourceProvider;

    public DatabaseInitializer(DataSourceProvider dataSourceProvider) {
        this.dataSourceProvider = dataSourceProvider;
    }

    /**
     * Данный метод инициализирует базу данных
     */
    public void init() throws URISyntaxException, IOException {
        prepareDatabaseScheme();
        importTestData();
    }

    /**
     * Данный метод загружает SQL-скрипт из ресурсов по имени файла. Затем выполняет скрипт, создавая схему базы данных.
     */
    private void prepareDatabaseScheme() throws URISyntaxException, IOException {
        String schemaSqlScript = Files.readString(Path.of(ClassLoader.getSystemResource(PropertiesUtil.get(SCHEMA_SCRIPT)).toURI()));
        try (Connection connection = dataSourceProvider.getDataSource().getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(schemaSqlScript);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Данный метод загружает SQL-скрипт из ресурсов по имени файла. Затем выполняет скрипт, импортируя тестовые данные.
     */
    private void importTestData() throws URISyntaxException, IOException {
        String dataSqlScript = Files.readString(Path.of(ClassLoader.getSystemResource(PropertiesUtil.get(DATA_SCRIPT)).toURI()));
        try (Connection connection = dataSourceProvider.getDataSource().getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(dataSqlScript);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
