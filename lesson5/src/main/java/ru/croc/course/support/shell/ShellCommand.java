package ru.croc.course.support.shell;

import java.util.List;

/**
 * Контракт для консольных команд
 */
public interface ShellCommand {
    /** Получает имя команды */
    String getName();
    /** Получает описание команды */
    String getDescription();
    /** Получает список аргументов команды */
    List<String> getArgumentsNames();
    /** Логика по обработке программы */
    void handle(ShellCommandParsingResult shellCommandParsingResult);


}
