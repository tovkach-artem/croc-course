package ru.croc.course.model.entity;

import ru.croc.course.annotation.Column;
import ru.croc.course.annotation.Table;
import ru.croc.course.support.AnnotationBasedSqlQueryGenerator;

import java.time.LocalDateTime;

/**
 * Данный класс является моделью данных для использования метеорологических данных. Может быть использован утилитарным
 * классом {@link AnnotationBasedSqlQueryGenerator}.
 */
@Table(name = "METEOROLOGICAL_DATA")
public class MeteorologicalData {
    /**
     * Уникальный идентификатор записи
     */
    @Column(name = "id")
    private Integer id;
    /**
     * Дата измерения
     */
    @Column(name = "measurement_date")
    private LocalDateTime measurementDate;
    /**
     * Температура воздуха
     */
    @Column(name = "air_temperature")
    private Double airTemperature;

    /**
     * Атмосферное давление
     */
    @Column(name = "atmospheric_pressure")
    private Double atmosphericPressure;

    public MeteorologicalData() {
    }

    public MeteorologicalData(Integer id, LocalDateTime measurementDate, Double airTemperature, Double atmosphericPressure) {
        this.id = id;
        this.measurementDate = measurementDate;
        this.airTemperature = airTemperature;
        this.atmosphericPressure = atmosphericPressure;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(LocalDateTime measurementDate) {
        this.measurementDate = measurementDate;
    }

    public Double getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(Double airTemperature) {
        this.airTemperature = airTemperature;
    }

    public Double getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(Double atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }

    @Override
    public String toString() {
        return "MeteorologicalData{" +
                "id=" + id +
                ", measurementDatabase=" + measurementDate +
                ", airTemperature=" + airTemperature +
                ", atmosphericPressure=" + atmosphericPressure +
                '}';
    }
}
