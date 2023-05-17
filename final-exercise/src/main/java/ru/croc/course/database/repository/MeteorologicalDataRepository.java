package ru.croc.course.database.repository;

import ru.croc.course.database.entity.MeteorologicalData;
import ru.croc.course.support.db.DataSourceProvider;
import ru.croc.course.support.sql.SqlQueryGenerator;
import ru.croc.course.weather.ResultSetToMeteorologicalDateMapper;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Данный класс является репозиторием для получения метеорологических данных из базы {@link MeteorologicalData}.
 */
public class MeteorologicalDataRepository {

    private DataSourceProvider dataSourceProvider;


    private static final String FIND_BY_MEASUREMENT_DATE_BETWEEN = """
            SELECT id,
                measurement_date,
                air_temperature,
                atmospheric_pressure
            FROM meteorological_data
            WHERE measurement_date BETWEEN ? and ?;
            """;

    public MeteorologicalDataRepository(DataSourceProvider dataSourceProvider) {
        this.dataSourceProvider = dataSourceProvider;
    }

    /**
     * Возвращает все метеорологические данные из базы
     */
    public List<MeteorologicalData> findAll() {
        try (Connection connection = dataSourceProvider.getDataSource().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQueryGenerator.generateSelectAll(MeteorologicalData.class));
            List<MeteorologicalData> meteorologicalData = new ArrayList<>();
            while (resultSet.next()) {
                meteorologicalData.add(new ResultSetToMeteorologicalDateMapper().mapFrom(resultSet));
            }
            return meteorologicalData;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Создает новую запись о метеорологических данных в базе
     */
    public void create(MeteorologicalData meteorologicalData) {
        try (Connection connection = dataSourceProvider.getDataSource().getConnection()) {

            Statement statement = connection.createStatement();
            statement.executeUpdate(SqlQueryGenerator.generateInsert(meteorologicalData));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Возвращает все метеорологические данные из базы, у которых дата изменения находится в заданном диапазоне
     */
    public List<MeteorologicalData> findAllByMeasurementDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        try (Connection connection = dataSourceProvider.getDataSource().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_MEASUREMENT_DATE_BETWEEN);
            preparedStatement.setObject(1, startDate);
            preparedStatement.setObject(2, endDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<MeteorologicalData> meteorologicalData = new ArrayList<>();
            while (resultSet.next()) {
                meteorologicalData.add(new ResultSetToMeteorologicalDateMapper().mapFrom(resultSet));
            }
            return meteorologicalData;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
