package ru.croc.course.lesson2.parknig;

import ru.croc.course.lesson2.car.Car;
import ru.croc.course.lesson2.parknig.attempt.FailedParkingAttempt;
import ru.croc.course.lesson2.parknig.attempt.SuccessfulParkingAttempt;
import ru.croc.course.lesson2.support.ArrayOperations;

import java.util.Arrays;
import java.util.Objects;
/** Автомат контроля въезда */
public class EntryPoint{
    /** Значение по умолчанию для инициализации размера хранилища всех въехавших машин через автомат */
    private static final int DEFAULT_SIZE_OF_ENTERED_CARS = 10;
    /** Номер автомата */
    private int number;
    /** Описание автомата */
    private String description;
    /** Паркинг, который обслуживает автомат */
    private Parking parking;
    /** действительное значение всех въехавших через автомат машин */
    private int enteredCarsCount;
    /** Хранилище информации о машинах, которые въехали с парковки через автомат */
    private Car[] enteredCars = new Car[DEFAULT_SIZE_OF_ENTERED_CARS];

    public EntryPoint(Parking parking, int number, String description) {
        this.parking = parking;
        this.number = number;
        this.description = description;
    }
    /** Въезд машины на территорию паркинга.
     * @return
     * true в случае, если машине удалось заехать на парковку
     * false в случае, если машине не удалось заехать на парковку
     */
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
    /** Добавляет машину в хранилище въехавших {@link EntryPoint#enteredCars} */
    private void addEnteredCar(Car enteredCar) {
        enteredCars = ArrayOperations.getFullnessSizeBasedArray(enteredCarsCount, enteredCars);
        enteredCars[enteredCarsCount++] = enteredCar;
    }
    /** Возвращает массив машин, которые заехали через автомат */
    public Car[] getArrayBasedEntryCarsLog() {
        return Arrays.stream(enteredCars)
                .filter(Objects::nonNull)
                .toArray(Car[]::new);
    }

    /** Позволяет получить название автомата */
    public int getNumber() {
        return number;
    }

    /** Позволяет установить название автомата */
    public void setNumber(int number) {
        this.number = number;
    }

    /** Позволяет получить описание автомата */
    public String getDescription() {
        return description;
    }

    /** Позволяет установить описание автомата */
    public void setDescription(String description) {
        this.description = description;
    }

    /** Позволяет получить паркинг, который обслуживает автомат */
    public Parking getParking() {
        return parking;
    }

    /** Позволяет установить паркинг, который обслуживает автомат */
    public void setParking(Parking parking) {
        this.parking = parking;
    }
    /** Позволяет получить хранилище заехавших машин */
    public Car[] getEnteredCars() {
        return enteredCars;
    }
    /** Позволяет установить хранилище заехавших машин */
    public void setEnteredCars(Car[] enteredCars) {
        this.enteredCars = enteredCars;
    }

}
