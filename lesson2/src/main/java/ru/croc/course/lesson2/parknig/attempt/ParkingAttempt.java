package ru.croc.course.lesson2.parknig.attempt;

import ru.croc.course.lesson2.support.LoggingRequired;

/** Контракт для объектов, которые отражают действие попытки выезда на территорию паркинга */
public interface ParkingAttempt extends LoggingRequired {
    /** Позволяет получить результат принятия решения о возможности заезда автомобиля */
    ParkingAttemptResolution getResolution();

}
