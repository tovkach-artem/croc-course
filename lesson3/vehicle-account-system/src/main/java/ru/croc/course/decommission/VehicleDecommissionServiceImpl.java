package ru.croc.course.decommission;

import ru.croc.course.vehicle.Vehicle;

import java.util.List;

public class VehicleDecommissionServiceImpl implements VehicleDecommissionService {

    private final VehicleDecommissionRepository  decommissionRepository;

    public VehicleDecommissionServiceImpl(VehicleDecommissionRepository decommissionRepository) {
        this.decommissionRepository = decommissionRepository;
    }

    @Override
    public boolean writeOff(Vehicle vehicle) {
        if(vehicle.isFaulty()) {
            VehicleDecommission decommission = new VehicleDecommission(vehicle);
            decommissionRepository.save(decommission);
            return true;
        }
        return false;
    }

    @Override
    public List<Vehicle> getAllDecommissioned() {
        return decommissionRepository.findAll().stream().map(VehicleDecommission::getVehicle).toList();
    }
}
