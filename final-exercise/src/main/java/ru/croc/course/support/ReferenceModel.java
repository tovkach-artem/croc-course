package ru.croc.course.support;

import java.util.Set;

/**
 * Данный интерфейс представляет собой эталонную модель. Под эталонной моделью понимается набор данных необходимых для
 * нормального функционирования какого-либо объекта (Зачастую такие объект могут понадобиться в сервисах).
 * Данный интерфейс можно использовать для передачи данных между разными слоями приложения.
 */
public interface ReferenceModel {

    ReferenceModel addAttribute(String attributeName);
    Set<String> asSet();

}
