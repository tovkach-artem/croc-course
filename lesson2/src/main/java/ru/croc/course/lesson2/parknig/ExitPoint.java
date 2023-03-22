package ru.croc.course.lesson2.parknig;

import ru.croc.course.lesson2.car.Car;
import ru.croc.course.lesson2.support.ArrayOperations;

import java.util.Arrays;
import java.util.Objects;
/** Автомат контроля выезда */
public class ExitPoint {
    /** Значение по умолчанию для инициализации размера хранилища всех выехавших машин через автомат */
    private static final int DEFAULT_SIZE_OF_EXITED_CARS = 10;
    /** Номер автомата */
    private int number;
    /** Описание автомата */
    private String description;
    /** Паркинг, который обслуживает автомат */
    private Parking parking;
    /** действительное значение всех выехавших через автомат машин */
    private int  leavedCarsCount;
    /** Хранилище информации о машинах, которые выехали с парковки через автомат */
    private Car[] leavedCars =  new Car[DEFAULT_SIZE_OF_EXITED_CARS];

    public ExitPoint(Parking parking, int number, String description) {
        this.parking = parking;
        this.number = number;
        this.description = description;
    }

    /** Выезд машины с территории паркинга */
    public void exit(Car car) {
        addLeavedCar(car);
        parking.leave(car);
    }

    /** Добавляет машину в хранилище выехавших {@link ExitPoint#leavedCars} */
    public void addLeavedCar(Car leavedCar) {
        leavedCars = ArrayOperations.getFullnessSizeBasedArray(leavedCarsCount,  leavedCars);
        leavedCars[leavedCarsCount++] = leavedCar;
    }
    /** Возвращает массив машин, которые выехали через автомат */
    public Car[] getArrayBasedLeavedCarsLog() {
        return Arrays.stream(leavedCars)
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
    /** Позволяет получить хранилище выехавших машин */
    public Car[] getLeavedCars() {
        return leavedCars;
    }
    /** Позволяет установить хранилище выехавших машин */
    public void setLeavedCars(Car[] leavedCars) {
        this.leavedCars = leavedCars;
    }
}
