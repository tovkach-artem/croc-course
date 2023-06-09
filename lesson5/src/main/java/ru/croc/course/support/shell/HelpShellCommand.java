package ru.croc.course.support.shell;

import java.util.Collections;
import java.util.List;

/**
 * Консольная команда help
 */
public class HelpShellCommand implements ShellCommand{

    /**
     * Список команд, которые обслуживаются командой help
     */
    private List<ShellCommand> shellCommands;

    public HelpShellCommand(List<ShellCommand> shellCommands) {
        this.shellCommands = shellCommands;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Выводит список всех команд и их описанием";
    }

    @Override
    public List<String> getArgumentsNames() {
        return Collections.emptyList();
    }

    /**
     * Выводить на консоль имя команды, ее описание и аргументы
     */
    @Override
    public void handle(ShellCommandParsingResult shellCommandParsingResult) {
        for (ShellCommand shellCommand : shellCommands) {
            System.out.printf("%s  ->  %s ", shellCommand.getName(),shellCommand.getDescription());
            if(shellCommand.getArgumentsNames().size() != 0) {
                System.out.printf("(параметры %s)", shellCommand.getArgumentsNames());
            }
            System.out.println();

        }
    }
}
