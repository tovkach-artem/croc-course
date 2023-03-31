package ru.croc.course.rental;

import ru.croc.course.support.repository.DefaultArrayListBasedRepository;
/** Репозиторий для работы с документом аренда транспортного, основанный на внутреннем хранилище в виде {@link java.util.ArrayList} */
public class ArrayListBasedVehicleRentalRepository extends DefaultArrayListBasedRepository<VehicleRental, Long> implements VehicleRentalRepository {
}

