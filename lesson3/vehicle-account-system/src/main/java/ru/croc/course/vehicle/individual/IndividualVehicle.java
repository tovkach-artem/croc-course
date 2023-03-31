package ru.croc.course.vehicle.individual;

import ru.croc.course.vehicle.Vehicle;
import ru.croc.course.vehicle.VehicleCategory;

public abstract class IndividualVehicle extends Vehicle {
    private static final VehicleCategory DEFAULT_VEHICLE_CATEGORY = VehicleCategory.INDIVIDUAL;
    public IndividualVehicle(String number) {
        super(number, VehicleCategory.INDIVIDUAL);
    }
}
