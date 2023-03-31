package ru.croc.course.rental;

import ru.croc.course.support.entity.BaseEntity;
import ru.croc.course.vehicle.Vehicle;

import java.time.LocalDate;

public class VehicleRental implements BaseEntity<Long> {
    private Long id;
    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;

    public VehicleRental(Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
