package ru.croc.course.lesson2.parknig.attempt;

import ru.croc.course.lesson2.car.Car;
/** Класс отражающий успешную попытку заезда на парковку */
public class SuccessfulParkingAttempt extends AbstractParkingAttempt {

    public SuccessfulParkingAttempt(Car car) {
        super(car);
    }

    @Override
    public ParkingAttemptResolution getResolution() {
        return ParkingAttemptResolution.SUCCEED;
    }
}
