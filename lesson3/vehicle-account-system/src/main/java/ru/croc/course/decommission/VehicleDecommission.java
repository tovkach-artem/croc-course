package ru.croc.course.decommission;

import ru.croc.course.support.entity.BaseEntity;
import ru.croc.course.vehicle.Vehicle;

public class VehicleDecommission implements BaseEntity<Long> {

    private Long id;
    private Vehicle vehicle;

    public VehicleDecommission(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
