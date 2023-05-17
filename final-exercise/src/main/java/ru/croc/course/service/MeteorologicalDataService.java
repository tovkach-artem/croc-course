package ru.croc.course.service;

import ru.croc.course.database.entity.MeteorologicalData;
import ru.croc.course.database.repository.MeteorologicalDataRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Данный класс представляет собой высокоуровневый сервис для работы с метеорологическими данными
 */
public class MeteorologicalDataService {

    private MeteorologicalDataRepository meteorologicalDataRepository;

    public MeteorologicalDataService(MeteorologicalDataRepository meteorologicalDataRepository) {
        this.meteorologicalDataRepository = meteorologicalDataRepository;
    }

    /**
     * Возвращает список всех метеорологических данных, которые хранятся в репозитории
     */
    public List<MeteorologicalData> findAll() {
        return meteorologicalDataRepository.findAll();
    }

    /**
     * Создает новые метеорологические данные в репозитории
     */
    public void create(MeteorologicalData meteorologicalData) {
        meteorologicalDataRepository.create(meteorologicalData);
    }

    /**
     * Возвращает список метеорологических данных, измеренных между двумя датами, которые передаются в параметрах
     */
    public List<MeteorologicalData> findByMeasurementDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return meteorologicalDataRepository.findAllByMeasurementDateBetween(startDate, endDate);
    }
}
