package ru.croc.course.mapper;

import ru.croc.course.database.entity.MeteorologicalData;
import ru.croc.course.mapper.Mapper;
import ru.croc.course.exception.MappingException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Данный класс является реализацией интерфейса {@link Mapper}, который отображает {@link ResultSet} в объект {@link MeteorologicalData}.
 */
public class ResultSetToMeteorologicalDateMapper implements Mapper<ResultSet, MeteorologicalData> {
    /**
     * Принимает объект {@link ResultSet} и возвращает новый объект {@link MeteorologicalData}, устанавливая его поля значениями из {@link ResultSet}.
     */
    @Override
    public MeteorologicalData mapFrom(ResultSet resultSet) {
        try {
            MeteorologicalData meteorologicalData = new MeteorologicalData();
            meteorologicalData.setId(resultSet.getInt("id"));
            meteorologicalData.setAirTemperature(resultSet.getDouble("air_temperature"));
            meteorologicalData.setMeasurementDate(resultSet.getTimestamp("measurement_date").toLocalDateTime());
            meteorologicalData.setAtmosphericPressure(resultSet.getDouble("atmospheric_pressure"));
            return meteorologicalData;
        } catch (SQLException exception) {
            throw new MappingException(exception);
        }

    }
}
