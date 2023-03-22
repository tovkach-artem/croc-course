package ru.croc.course.lesson2.parknig.attempt;

import ru.croc.course.lesson2.car.Car;

import java.time.LocalDateTime;
/** Класс объявляет состояние и поведение, присущее всем попытками паркинга */
public abstract class AbstractParkingAttempt implements ParkingAttempt {
    /** Информация о машине, которая хочет заехать на парковку */
    private Car car;
    /** Дата и время попытки заезда */
    private LocalDateTime dateTime;
    /** Конструктор позволяет установить при создании конкретную машину, а также устанавливает текущее время*/
    public AbstractParkingAttempt(Car car) {
        this.car = car;
        dateTime = LocalDateTime.now();
    }
    /** Позволяет получить описание используемое для логирования */
    public String getLoggingDescription() {
        if(getResolution().equals(ParkingAttemptResolution.SUCCEED)) {
            return String.format("Машина %s заехала на парковку в %s", car.getNumber(), dateTime);
        } else{
            return String.format("Машине %s запрещен въезд на парковку  в %s", car.getNumber(), dateTime);
        }
    };
    /** Позволяет получить информацию о машине, которая хочет заехать на парковку */
    public Car getCar() {
        return car;
    }
    /** Позволяет установить информацию о машине, которая хочет заехать на парковку */
    public void setCar(Car car) {
        this.car = car;
    }
    /** Позволяет получить дату и время попытки заезда*/
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    /** Позволяет установить дату и время попытки заезда*/
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
