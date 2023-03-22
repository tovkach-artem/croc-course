package ru.croc.course.lesson2.parknig.attempt;

import ru.croc.course.lesson2.car.Car;

public class SuccessfulParkingAttempt extends AbstractParkingAttempt {

    public SuccessfulParkingAttempt(Car car) {
        super(car);
    }

    @Override
    public ParkingAttemptResolution getResolution() {
        return ParkingAttemptResolution.SUCCEED;
    }
}
