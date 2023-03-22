package ru.croc.course.lesson2.parknig.attempt;

import ru.croc.course.lesson2.car.Car;

import java.time.LocalDateTime;

public abstract class AbstractParkingAttempt implements ParkingAttempt {

    private Car car;
    private LocalDateTime dateTime;

    public AbstractParkingAttempt(Car car) {
        this.car = car;
        dateTime = LocalDateTime.now();
    }

    public String getLoggingDescription() {
        if(getResolution().equals(ParkingAttemptResolution.SUCCEED)) {
            return String.format("Машина %s заехала на парковку в %s", car.getNumber(), dateTime);
        } else{
            return String.format("Машине %s запрещен въезд на парковку  в %s", car.getNumber(), dateTime);
        }
    };

}
