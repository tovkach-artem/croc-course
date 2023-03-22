package ru.croc.course.lesson2.parknig.attempt;

import ru.croc.course.lesson2.car.Car;
/** Класс отражающий проваленную попытку заезда на парковку */
public class FailedParkingAttempt extends AbstractParkingAttempt {


    public FailedParkingAttempt(Car car) {
        super(car);
    }

    @Override
    public ParkingAttemptResolution getResolution() {
        return ParkingAttemptResolution.FAILED;
    }
}
