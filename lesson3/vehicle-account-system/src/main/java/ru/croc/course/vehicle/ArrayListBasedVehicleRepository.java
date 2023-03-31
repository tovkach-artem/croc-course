package ru.croc.course.vehicle;

import ru.croc.course.support.repository.DefaultArrayListBasedRepository;
/** Репозиторий для работы с транспортными средствами, основанный на внутреннем хранилище в виде {@link java.util.ArrayList} */
public class ArrayListBasedVehicleRepository extends DefaultArrayListBasedRepository<Vehicle, Long>implements VehicleRepository {
}
