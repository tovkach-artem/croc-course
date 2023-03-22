package ru.croc.course.lesson2.parknig;

import ru.croc.course.lesson2.car.Car;
import ru.croc.course.lesson2.parknig.attempt.FailedParkingAttempt;
import ru.croc.course.lesson2.parknig.attempt.SuccessfulParkingAttempt;
import ru.croc.course.lesson2.support.ArrayOperations;

import java.util.Arrays;
import java.util.Objects;

public class EntryPoint{

    private static final int DEFAULT_SIZE_OF_ENTERED_CARS = 10;
    private int number;
    private String description;
    private Parking parking;

    private int enteredCarsCount;
    private Car[] enteredCars = new Car[DEFAULT_SIZE_OF_ENTERED_CARS];

    public EntryPoint(Parking parking, int number, String description) {
        this.parking = parking;
        this.number = number;
        this.description = description;
    }

    public boolean enter(Car car) {
        if(parking.canEnter()) {
            parking.addParkingAttempt(new SuccessfulParkingAttempt(car));
            addEnteredCar(car);
            return true;
        } else {
            parking.addParkingAttempt(new FailedParkingAttempt(car));
            return false;
        }
    }

    private void addEnteredCar(Car enteredCar) {
        enteredCars = ArrayOperations.getFullnessSizeBasedArray(enteredCarsCount, enteredCars);
        enteredCars[enteredCarsCount++] = enteredCar;
    }

    public Car[] getArrayBasedEntryCarsLog() {
        return Arrays.stream(enteredCars)
                .filter(Objects::nonNull)
                .toArray(Car[]::new);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Car[] getEnteredCars() {
        return enteredCars;
    }

    public void setEnteredCars(Car[] enteredCars) {
        this.enteredCars = enteredCars;
    }

}
