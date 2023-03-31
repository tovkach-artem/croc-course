package ru.croc.course.rental;

import ru.croc.course.decommission.VehicleDecommissionService;
import ru.croc.course.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.List;
/** Реализация интерфейса {@link VehicleDecommissionService} работающая с репозиторием документов "аренда транспортного средства"*/
public class VehicleRentalServiceImpl implements VehicleRentalService {

    private final VehicleRentalRepository rentalRepository;

    public VehicleRentalServiceImpl(VehicleRentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }
    /** Позволяет арендовать объект (который можно арендовать -> имплементирующий интерфейс {@link Rentable}.
     * Создает документ "аренда транспортного средства" и сохраняет его в репозитории.
     */
    @Override
    public void rent(Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        VehicleRental vehicleRental = new VehicleRental(vehicle, startDate,endDate);
        rentalRepository.save(vehicleRental);
    }
    /** Позволяет определить арендован ли объект на определенную дату.*/
    @Override
    public boolean isRentedOnDate(Vehicle vehicle, LocalDate date) {
        return getRentedByDate(date).contains(vehicle);
    }
    /** Позволяет получить все объекты арендованные на определенную дату.
     * Получает все документы об аренде транспортных средств и извлекает из них информацию об арендованных объектах.
     */
    @Override
    public List<Vehicle> getRentedByDate(LocalDate date) {
        return rentalRepository.findAll().stream()
                .filter(rental -> rental.getEndDate().isAfter(date))
                .map(VehicleRental::getVehicle)
                .toList();
    }


}
