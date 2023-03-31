package ru.croc.course.rental;

import ru.croc.course.vehicle.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class VehicleRentalServiceImpl implements VehicleRentalService {

    private final VehicleRentalRepository rentalRepository;

    public VehicleRentalServiceImpl(VehicleRentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public void rent(Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        VehicleRental vehicleRental = new VehicleRental(vehicle, startDate,endDate);
        rentalRepository.save(vehicleRental);
    }

    @Override
    public boolean isRentedOnDate(Vehicle vehicle, LocalDate date) {
        return getRentedByDate(date).contains(vehicle);
    }

    @Override
    public List<Vehicle> getRentedByDate(LocalDate date) {
        return rentalRepository.findAll().stream()
                .filter(rental -> rental.getEndDate().isAfter(date))
                .map(VehicleRental::getVehicle)
                .toList();
    }


}
