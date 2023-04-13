package ru.croc.course.support.shell;

import ru.croc.course.support.shell.exception.UnsupportedShellCommand;

import java.util.List;
import java.util.Optional;

public class ShellCommandDispatcher {

    private final ShellCommandParser shellCommandParser;
    private final ShellCommandRegister shellCommandRegister;

    public ShellCommandDispatcher(ShellCommandParser shellCommandParser, ShellCommandRegister shellCommandRegister) {
        this.shellCommandParser = shellCommandParser;
        this.shellCommandRegister = shellCommandRegister;
    }

    public void process(String shellCommand) {
        ShellCommandParsingResult shellCommandParsingResult = shellCommandParser.parse(shellCommand);
        Optional<ShellCommand> processedCommand = shellCommandRegister.getShellCommands().stream()
                .filter(command -> command.getName().equals(shellCommandParsingResult.getName()))
                .filter(command -> shellCommandParsingResult.getArgumentNameToValue().keySet().containsAll(command.getArgumentsNames()))
                .findFirst();
        if(processedCommand.isPresent()) {
            processedCommand.get().handle(shellCommandParsingResult);
        } else {
            throw new UnsupportedShellCommand();
        }
    }
}
