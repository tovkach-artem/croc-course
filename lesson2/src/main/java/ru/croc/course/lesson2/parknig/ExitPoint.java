package ru.croc.course.lesson2.parknig;

import ru.croc.course.lesson2.car.Car;
import ru.croc.course.lesson2.support.ArrayOperations;

import java.util.Arrays;
import java.util.Objects;

public class ExitPoint {
    private static final int DEFAULT_SIZE_OF_EXITED_CARS = 10;
    private int number;
    private String description;
    private Parking parking;
    private int  leavedCarsCount;
    private Car[] leavedCars =  new Car[DEFAULT_SIZE_OF_EXITED_CARS];

    public ExitPoint(Parking parking, int number, String description) {
        this.parking = parking;
        this.number = number;
        this.description = description;
    }

    public void exit(Car car) {
        addLeavedCar(car);
        parking.leave();
    }

    public void addLeavedCar(Car leavedCar) {
        leavedCars = ArrayOperations.getFullnessSizeBasedArray(leavedCarsCount,  leavedCars);
        leavedCars[leavedCarsCount++] = leavedCar;
    }

    public Car[] getArrayBasedLeavedCarsLog() {
        return Arrays.stream(leavedCars)
                .filter(Objects::nonNull)
                .toArray(Car[]::new);
    }
}
