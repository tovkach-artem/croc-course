package ru.croc.course.support.shell;

import java.util.Map;

public class ShellCommandParsingResult {
    private String name;
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
