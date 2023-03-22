package ru.croc.course.lesson2.parknig;

import ru.croc.course.lesson2.parknig.attempt.ParkingAttempt;
import ru.croc.course.lesson2.parknig.attempt.ParkingAttemptResolution;
import ru.croc.course.lesson2.support.ArrayOperations;

import java.util.Arrays;
import java.util.Objects;

public class Parking {
    private static final int DEFAULT_ENTRY_POINT_COUNT = 2;
    private static final int DEFAULT_EXIT_POINT_COUNT = 2;
    private int totalSpaces;
    private int parkedCarsCount;
    private int parkingAttemptCount;
    private int entryPointCount;
    private int exitPointCount;
    private EntryPoint[] entryPoints = new EntryPoint[DEFAULT_ENTRY_POINT_COUNT];
    private ExitPoint[] exitPoints = new ExitPoint[DEFAULT_EXIT_POINT_COUNT];
    private ParkingAttempt[] parkingAttempts;


    public Parking(int totalSpaces) {
        this.totalSpaces = totalSpaces;
        parkingAttempts = new ParkingAttempt[totalSpaces];
    }

    public boolean canEnter() {
        return parkedCarsCount < totalSpaces;
    }
    public int getFreeSpacesCount() {
        return totalSpaces - parkedCarsCount;
    }

    public void addEntryPoint(EntryPoint  entryPoint) {
        entryPoints = ArrayOperations.getFullnessSizeBasedArray(entryPointCount, entryPoints);
        entryPoints[entryPointCount++] = entryPoint;
    }
    public void addExitPoint(ExitPoint  exitPoint) {
        exitPoints = ArrayOperations.getFullnessSizeBasedArray(exitPointCount, exitPoints);
        exitPoints[exitPointCount++] = exitPoint;
    }

    public void addParkingAttempt(ParkingAttempt parkingAttempt) {
        parkingAttempts = ArrayOperations.getFullnessSizeBasedArray(parkingAttemptCount, parkingAttempts);
        if(parkingAttempt.getResolution().equals(ParkingAttemptResolution.SUCCEED)) {
            parkedCarsCount++;
        }
        parkingAttempts[parkingAttemptCount++] = parkingAttempt;

    }

    public void leave() {
        parkedCarsCount--;
    }



    public ParkingAttempt[] getArrayBasedParkingAttemptLog(ParkingAttemptResolution resolutionFilter) {
        return Arrays.stream(parkingAttempts)
                .filter(Objects::nonNull)
                .filter(attempt -> attempt.getResolution().equals(resolutionFilter))
                .toArray(ParkingAttempt[]::new);
    }



}
