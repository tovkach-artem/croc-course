package ru.croc.course.decommission;

import ru.croc.course.support.repository.DefaultArrayListBasedRepository;
/** Репозиторий для работы с документом списание товаров, основанный на внутреннем хранилище в виде {@link java.util.ArrayList} */
public class ArrayListBasedVehicleDecommissionRepository extends DefaultArrayListBasedRepository<VehicleDecommission, Long> implements VehicleDecommissionRepository {

}
