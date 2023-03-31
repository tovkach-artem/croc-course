package ru.croc.course.rental;

import ru.croc.course.support.repository.DefaultArrayListBasedRepository;
import ru.croc.course.vehicle.Vehicle;
import ru.croc.course.vehicle.VehicleRepository;

public class ArrayListBasedVehicleRentalRepository extends DefaultArrayListBasedRepository<VehicleRental, Long> implements VehicleRentalRepository {
}

