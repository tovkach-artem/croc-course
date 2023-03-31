package ru.croc.course.vehicle;

import ru.croc.course.decommission.Serviceable;
import ru.croc.course.rental.Rentable;
import ru.croc.course.support.entity.BaseEntity;
/** Базовая сущность для всех транспортных средств */
public abstract class Vehicle implements Serviceable, Rentable, BaseEntity<Long> {
    private Long id;
    private String number;

    private VehicleCategory vehicleCategory;

    public Vehicle(String number, VehicleCategory vehicleCategory) {
        this.number = number;
        this.vehicleCategory = vehicleCategory;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", vehicleCategory=" + vehicleCategory +
                '}';
    }
    /** Здесь можно добавить кастомную логику по которой будет определяться исправность/неисправность автомобиля*/
    @Override
    public boolean isFaulty() {
        return true;
    }
}
