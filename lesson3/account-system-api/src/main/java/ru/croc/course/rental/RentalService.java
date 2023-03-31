package ru.croc.course.rental;

import java.time.LocalDate;
import java.util.List;

public interface RentalService<T extends Rentable> {

    void rent(T rentable, LocalDate startDate, LocalDate endDate);
    boolean isRentedOnDate(T rentable, LocalDate date);
    List<T> getRentedByDate(LocalDate date);

}
