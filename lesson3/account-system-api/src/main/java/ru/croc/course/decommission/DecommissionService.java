package ru.croc.course.decommission;

import java.util.List;

/** Интерфейс содержит общее поведение для всех сервисов списания.
 * Стоит отметить, что такого рода сервисы могут работать только с обслуживаемым объектами {@link  Serviceable}*/
public interface DecommissionService<T extends Serviceable> {
    /** позволяет списать объект и возвращает информацию о том, прошло ли списание успешно*/
    boolean writeOff(T serviceable);
    /** Позволяет получить список все списанных сервисом обслуживаемых объектов */
    List<T> getAllDecommissioned();

}
