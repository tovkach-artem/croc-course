package ru.croc.course.rental;

import java.time.LocalDate;
import java.util.List;
/**
 * Интерфейс содержит общее поведение для всех сервисов аренды
 */
public interface RentalService<T extends Rentable> {
    /** Позволяет арендовать объект (который можно арендовать -> имплементирующий интерфейс {@link Rentable}*/
    void rent(T rentable, LocalDate startDate, LocalDate endDate);
    /** Позволяет определить арендован ли объект на определенную дату*/
    boolean isRentedOnDate(T rentable, LocalDate date);
    /** Позволяет получить все объекты арендованные на определенную дату*/
    List<T> getRentedByDate(LocalDate date);

}
