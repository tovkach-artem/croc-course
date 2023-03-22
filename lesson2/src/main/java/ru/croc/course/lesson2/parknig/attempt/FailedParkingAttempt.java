package ru.croc.course.lesson2.parknig.attempt;

import ru.croc.course.lesson2.car.Car;

public class FailedParkingAttempt extends AbstractParkingAttempt {


    public FailedParkingAttempt(Car car) {
        super(car);
    }

    @Override
    public ParkingAttemptResolution getResolution() {
        return ParkingAttemptResolution.FAILED;
    }
}
