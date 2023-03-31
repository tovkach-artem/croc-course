package ru.croc.course.vehicle.automobile;

import ru.croc.course.vehicle.Vehicle;
import ru.croc.course.vehicle.VehicleCategory;

public abstract  class Automobile extends Vehicle {
    private static final VehicleCategory DEFAULT_VEHICLE_CATEGORY =  VehicleCategory.AUTOMOBILE;

    public Automobile(String number) {
        super(number, DEFAULT_VEHICLE_CATEGORY);
    }
}
