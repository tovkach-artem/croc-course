package ru.croc.course.support.shell;

import java.util.Collections;
import java.util.List;
/**
 * Консольная команда exit
 */
public class ExitShellCommand implements ShellCommand {
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Завершает работу программы";
    }

    @Override
    public List<String> getArgumentsNames() {
        return Collections.emptyList();
    }
    /**
     * Завершает работу программы
     */
    @Override
    public void handle(ShellCommandParsingResult shellCommandParsingResult) {
        System.exit(0);
    }
}
