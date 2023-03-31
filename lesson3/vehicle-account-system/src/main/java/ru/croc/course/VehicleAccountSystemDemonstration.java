package ru.croc.course;


import ru.croc.course.decommission.ArrayListBasedVehicleDecommissionRepository;
import ru.croc.course.decommission.VehicleDecommissionRepository;
import ru.croc.course.decommission.VehicleDecommissionService;
import ru.croc.course.decommission.VehicleDecommissionServiceImpl;
import ru.croc.course.rental.ArrayListBasedVehicleRentalRepository;
import ru.croc.course.rental.VehicleRentalRepository;
import ru.croc.course.rental.VehicleRentalService;
import ru.croc.course.rental.VehicleRentalServiceImpl;
import ru.croc.course.vehicle.*;
import ru.croc.course.vehicle.aircraft.BusinessJet;
import ru.croc.course.vehicle.aircraft.Helicopter;
import ru.croc.course.vehicle.automobile.PassengerCar;
import ru.croc.course.vehicle.automobile.Truck;
import ru.croc.course.vehicle.individual.Monowheel;

import java.time.LocalDate;

public class VehicleAccountSystemDemonstration {
    public static void main(String[] args) {

        VehicleRepository  vehicleRepository = new ArrayListBasedVehicleRepository();
        VehicleRentalRepository vehicleRentalRepository = new ArrayListBasedVehicleRentalRepository();
        VehicleDecommissionRepository vehicleDecommissionRepository = new ArrayListBasedVehicleDecommissionRepository();

        VehicleRentalService vehicleRentalService = new VehicleRentalServiceImpl(vehicleRentalRepository);
        VehicleDecommissionService  vehicleDecommissionService = new VehicleDecommissionServiceImpl(vehicleDecommissionRepository);
        VehicleService vehicleService = new VehicleService(vehicleRepository, vehicleDecommissionService, vehicleRentalService);

        Vehicle auto = new PassengerCar("ABC123");
        Vehicle monowheel = new Monowheel("BCD234");
        Vehicle helicopter = new Helicopter("CDE345");
        Vehicle businessJet = new BusinessJet("DEF456");
        Vehicle truck = new Truck("EFG567");

        vehicleService.register(auto);
        vehicleService.register(monowheel);
        vehicleService.register(helicopter);
        vehicleService.register(businessJet);
        vehicleService.register(truck);

        vehicleService.writeOff(helicopter);

        vehicleRentalService.rent(monowheel, LocalDate.of(2023,3,20),LocalDate.of(2023,4,  10));
        vehicleRentalService.rent(truck, LocalDate.of(2023,3,20),LocalDate.of(2023,4,  10));

        System.out.println("Арендованные: " +  vehicleRentalService.getRentedByDate(LocalDate.of(2023, 3, 31)));
        System.out.println("Свободные автомобили: " + vehicleService.getFreeByCategoryAndDate(VehicleCategory.AUTOMOBILE, LocalDate.of(2023, 3, 31)));
        System.out.println("Списанные: " + vehicleDecommissionService.getAllDecommissioned());

        System.out.println(vehicleService.getActualReport().getContent());
        System.out.println(vehicleService.getReportOnDate(LocalDate.of(2023, 10, 10)).getContent());



    }
}
