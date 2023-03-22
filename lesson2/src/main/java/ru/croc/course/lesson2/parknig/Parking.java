package ru.croc.course.lesson2.parknig;

import ru.croc.course.lesson2.car.Car;
import ru.croc.course.lesson2.parknig.attempt.ParkingAttempt;
import ru.croc.course.lesson2.parknig.attempt.ParkingAttemptResolution;
import ru.croc.course.lesson2.support.ArrayOperations;

import java.util.Arrays;
import java.util.Objects;

/**
 * Паркинг
 */

public class Parking {

    /** Значение по умолчанию для инициализации массива автоматов контроля въезда*/
    private static final int DEFAULT_EXIT_POINT_COUNT = 2;
    /** Значение по умолчанию для инициализации массива автоматов контроля выезда*/
    private static final int DEFAULT_ENTRY_POINT_COUNT = 2;
    /** всего мест на парковке */
    private int totalSpaces;
    /** действительное значение припаркованных автомобилей */
    private int parkedCarsCount;
    /** действительное значение попыток заехать на территорию парковки*/
    private int parkingAttemptCount;
    /** действительное значение количества автоматов контроля въезда */
    private int exitPointCount;
    /** действительное значение количества автоматов контроля выезд */
    private int entryPointCount;
    /** Хранилище зарегистрированных автоматов контроля въезда */
    private ExitPoint[] exitPoints = new ExitPoint[DEFAULT_EXIT_POINT_COUNT];
    /** Хранилище зарегистрированных автоматов контроля выезда */
    private ParkingAttempt[] parkingAttempts;
    /** Хранилище зарегистрированных попыток заехать на территорию парковки */
    private EntryPoint[] entryPoints = new EntryPoint[DEFAULT_ENTRY_POINT_COUNT];


    /**
     * Конструктор для создания паркинга инициализирующий количество мест и размер массива {@link Parking#parkingAttempts}
     * @param totalSpaces количество мест на парковке
     */
    public Parking(int totalSpaces) {
        this.totalSpaces = totalSpaces;
        parkingAttempts = new ParkingAttempt[totalSpaces];
    }
    /** Отражает возможность заезда автомобиля на парковку */
    public boolean canEnter() {
        return parkedCarsCount < totalSpaces;
    }
    /** Возвращает количество свободных мест на парковке */
    public int getFreeSpacesCount() {
        return totalSpaces - parkedCarsCount;
    }
    /** Добавляет автомат контроля выезда с парковки.
     * Если необходимо увеличивает размерность массива {{@link Parking#exitPoints}}
     */
    public void addExitPoint(ExitPoint  exitPoint) {
        exitPoints = ArrayOperations.getFullnessSizeBasedArray(exitPointCount, exitPoints);
        exitPoints[exitPointCount++] = exitPoint;
    }
    /** Добавляет попытку выезда автомобиля на парковку.
     * Если необходимо увеличивает размерность массива {{@link Parking#parkingAttempts}}
     */
    public void addParkingAttempt(ParkingAttempt parkingAttempt) {
        parkingAttempts = ArrayOperations.getFullnessSizeBasedArray(parkingAttemptCount, parkingAttempts);
        if(parkingAttempt.getResolution().equals(ParkingAttemptResolution.SUCCEED)) {
            parkedCarsCount++;
        }
        parkingAttempts[parkingAttemptCount++] = parkingAttempt;

    }

    /** Добавляет автомат контроля въезда на парковку.
     * Если необходимо увеличивает размерность массива {{@link Parking#entryPoints}}
     */
    public void addEntryPoint(EntryPoint  entryPoint) {
        entryPoints = ArrayOperations.getFullnessSizeBasedArray(entryPointCount, entryPoints);
        entryPoints[entryPointCount++] = entryPoint;
    }

    /**
     * отражает функциональность выезда с парковки
     */
    public void leave(Car car) {
        parkedCarsCount--;
    }


    /** Возвращает массив всех попыток попасть на территорию парковки
     * @param resolutionFilter характеристика попытки {@link ParkingAttemptResolution}
     */
    public ParkingAttempt[] getArrayBasedParkingAttemptLog(ParkingAttemptResolution resolutionFilter) {
        return Arrays.stream(parkingAttempts)
                .filter(Objects::nonNull)
                .filter(attempt -> attempt.getResolution().equals(resolutionFilter))
                .toArray(ParkingAttempt[]::new);
    }
    /** Позволяет получить количество парковочных мест */
    public int getTotalSpaces() {
        return totalSpaces;
    }
    /** Позволяет установить количество парковочных мест */
    public void setTotalSpaces(int totalSpaces) {
        this.totalSpaces = totalSpaces;
    }
    /** Позволяет получить хранилище автоматов контроля выезда */
    public ExitPoint[] getExitPoints() {
        return exitPoints;
    }
    /** Позволяет установить хранилище автоматов контроля выезда */
    public void setExitPoints(ExitPoint[] exitPoints) {
        this.exitPoints = exitPoints;
    }
    /** Позволяет получить хранилище попыток заехать на территорию паркинга */
    public ParkingAttempt[] getParkingAttempts() {
        return parkingAttempts;
    }
    /** Позволяет установить хранилище попыток заехать на территорию паркинга */
    public void setParkingAttempts(ParkingAttempt[] parkingAttempts) {
        this.parkingAttempts = parkingAttempts;
    }
    /** Позволяет получить хранилище автоматов контроля въезда */
    public EntryPoint[] getEntryPoints() {
        return entryPoints;
    }
    /** Позволяет установить хранилище автоматов контроля въезда */
    public void setEntryPoints(EntryPoint[] entryPoints) {
        this.entryPoints = entryPoints;
    }
}
