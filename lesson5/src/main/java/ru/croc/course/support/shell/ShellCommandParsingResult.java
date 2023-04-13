package ru.croc.course.support.shell;

import java.util.Map;

/** Класс характеризует результат парсинга команды */
public class ShellCommandParsingResult {
    /** Название команды */
    private String name;
    /** Аргументы и их значения */
    private Map<String, String> argumentNameToValue;

    public ShellCommandParsingResult(String name, Map<String, String> argumentNameToValue) {
        this.name = name;
        this.argumentNameToValue = argumentNameToValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getArgumentNameToValue() {
        return argumentNameToValue;
    }

    public void setArgumentNameToValue(Map<String, String> argumentNameToValue) {
        this.argumentNameToValue = argumentNameToValue;
    }
}
