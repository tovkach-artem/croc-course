package ru.croc.course.vehicle.aircraft;

import ru.croc.course.vehicle.Vehicle;
import ru.croc.course.vehicle.VehicleCategory;
/** Базовая сущность для всех транспортных средств, которые попадают под категорию "летательный аппарат" {@link VehicleCategory}*/
public abstract class Aircraft extends Vehicle {
    private static final VehicleCategory DEFAULT_VEHICLE_CATEGORY = VehicleCategory.AIRCRAFT;

    public Aircraft(String number) {
        super(number, DEFAULT_VEHICLE_CATEGORY);
    }
}
