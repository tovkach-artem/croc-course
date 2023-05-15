package ru.croc.course.support;

import java.util.Map;

/**
 * Данный интерфейс представляет собой модель, которую можно использовать для хранения атрибутов в виде пар
 * ключ-значение. Данный интерфейс можно использовать для передачи данных между разными слоями приложения.
 */
public interface Model {

    Model addAttribute(String attributeName, String attributeValue);
    boolean containsAttribute(String attributeName);
    String getAttribute(String attributeName);
    Map<String, String> asMap();
}
