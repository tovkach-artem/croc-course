package ru.croc.course.lesson2.parknig.attempt;

import ru.croc.course.lesson2.support.LoggingRequired;

public interface ParkingAttempt extends LoggingRequired {

    ParkingAttemptResolution getResolution();

}
