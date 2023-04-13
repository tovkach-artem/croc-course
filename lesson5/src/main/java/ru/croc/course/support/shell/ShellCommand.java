package ru.croc.course.support.shell;

import java.util.List;

public interface ShellCommand {

    String getName();
    String getDescription();
    List<String> getArgumentsNames();
    void handle(ShellCommandParsingResult shellCommandParsingResult);


}
