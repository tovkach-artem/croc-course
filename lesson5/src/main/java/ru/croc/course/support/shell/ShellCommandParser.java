package ru.croc.course.support.shell;

import ru.croc.course.support.shell.exception.IncorrectShellCommandFormat;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Парсер команд.
 */
public class ShellCommandParser {

    /** Шаблон для разделения названия команды и ее аргументов */
    private static final Pattern COMMAND_TO_ARGUMENTS = Pattern.compile("^(\\w+)\\s*(.*)$");
    /** Шаблон для разделения названия аргументов и их значений */
    private static final Pattern ARGUMENT_NAME_TO_VALUE = Pattern.compile("(\\w+)=(\\w+)");
    /** Обрабатывает строку и формирует из нее объект {@link ShellCommandParsingResult}.
     * Если строка не соответствует объявленным паттернам, то выбрасывает
     * исключение о том, что формат строки не верный. */
    public ShellCommandParsingResult parse(String shellCommand) {
        ShellCommandParsingResult shellCommandParsingResult;

        Matcher matcher = COMMAND_TO_ARGUMENTS.matcher(shellCommand);
        if(matcher.matches()) {
            String commandName = matcher.group(1);
            String commandArguments = matcher.group(2);
            Map<String, String> argumentNameToValue = new HashMap<>();
            Matcher argumentsMatcher = ARGUMENT_NAME_TO_VALUE.matcher(commandArguments);
            while(argumentsMatcher.find()) {
                argumentNameToValue.put(argumentsMatcher.group(1), argumentsMatcher.group(2));
            }
            shellCommandParsingResult = new ShellCommandParsingResult(commandName, argumentNameToValue);
            return shellCommandParsingResult;
        } else {
            throw new IncorrectShellCommandFormat();
        }

    }

}
