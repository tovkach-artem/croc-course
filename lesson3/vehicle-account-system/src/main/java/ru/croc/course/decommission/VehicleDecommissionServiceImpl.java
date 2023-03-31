package ru.croc.course.decommission;

import ru.croc.course.vehicle.Vehicle;

import java.util.List;

/** Реализация интерфейса {@link VehicleDecommissionService} работающая с репозиторием документов "списание транспортного средства"*/
public class VehicleDecommissionServiceImpl implements VehicleDecommissionService {

    private final VehicleDecommissionRepository  decommissionRepository;

    public VehicleDecommissionServiceImpl(VehicleDecommissionRepository decommissionRepository) {
        this.decommissionRepository = decommissionRepository;
    }
    /** Позволяет списать объект и возвращает информацию о том, прошло ли списание успешно.
     * В случае, если попытка удачная, создает документ "списание транспортного средства" и сохраняет его в репозитории
     */
    @Override
    public boolean writeOff(Vehicle vehicle) {
        if(vehicle.isFaulty()) {
            VehicleDecommission decommission = new VehicleDecommission(vehicle);
            decommissionRepository.save(decommission);
            return true;
        }
        return false;
    }
    /** Позволяет получить список все списанных сервисом обслуживаемых объектов.
     * Получает все документы о списании транспортных средств и извлекает из них информацию о списанных объектах.
     */
    @Override
    public List<Vehicle> getAllDecommissioned() {
        return decommissionRepository.findAll().stream().map(VehicleDecommission::getVehicle).toList();
    }
}
