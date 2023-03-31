package ru.croc.course.rental;

import ru.croc.course.decommission.VehicleDecommission;
import ru.croc.course.support.repository.Repository;
/** Интерфейс содержит общее поведение для всех репозиториев, работающих с документом аренда транспортного средства {@link VehicleRental} */
public interface VehicleRentalRepository extends Repository<VehicleRental, Long> {
}
