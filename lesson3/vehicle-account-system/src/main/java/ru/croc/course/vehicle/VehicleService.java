package ru.croc.course.vehicle;

import ru.croc.course.decommission.VehicleDecommissionService;
import ru.croc.course.rental.VehicleRentalService;
import ru.croc.course.report.ReportProvider;
import ru.croc.course.report.StringBasedReport;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService implements ReportProvider<StringBasedReport> {
    private final VehicleRepository vehicleRepository;
    private final VehicleDecommissionService decommissionService;
    private final VehicleRentalService rentalService;

    public VehicleService(VehicleRepository vehicleRepository, VehicleDecommissionService decommissionService, VehicleRentalService rentalService) {
        this.vehicleRepository = vehicleRepository;
        this.decommissionService = decommissionService;
        this.rentalService = rentalService;
    }


    public void register(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public boolean writeOff(Vehicle vehicle) {
        if (decommissionService.writeOff(vehicle)) {
            vehicleRepository.delete(vehicle);
            return true;
        }
        return false;
    }

    public List<Vehicle> getFreeByCategoryAndDate(VehicleCategory vehicleCategory, LocalDate date) {
        return vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getVehicleCategory().equals(vehicleCategory))
                .filter(vehicle -> !rentalService.isRentedOnDate(vehicle, date))
                .collect(Collectors.toList());
    }

    public List<Vehicle> getRentedByCategoryAndDate(VehicleCategory vehicleCategory, LocalDate date) {
        return vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getVehicleCategory().equals(vehicleCategory))
                .filter(vehicle -> rentalService.isRentedOnDate(vehicle, date))
                .collect(Collectors.toList());
    }


    @Override
    public StringBasedReport getReportOnDate(LocalDate date) {
        String reportContent = "Отчет за " + date + "\n" + Arrays.stream(VehicleCategory.values())
                .map(category -> {
                    List<Vehicle> freeVehicle = getFreeByCategoryAndDate(category, date);
                    List<Vehicle> rentedVehicle = getRentedByCategoryAndDate(category, date);
                    return String.format("Категория: %s\nСвободных [%d]: %s\nАрендованных [%d]: %s\n",
                            category, freeVehicle.size(), freeVehicle, rentedVehicle.size(), rentedVehicle);
                }).collect(Collectors.joining());
        return () -> reportContent;
    }
}
