package ru.croc.course.support.shell;

import java.util.ArrayList;
import java.util.List;
/** Регистратор команд.
 * Позволяет зарегистрировать команды, чтобы она обслуживалась консольным приложением.
 */
public class ShellCommandRegister {
    private List<ShellCommand> shellCommands = new ArrayList<>();

    /** Конструктор для создания регистратора.
     * Дополнительно передает команды для {@link HelpShellCommand} и добавляет команду help по-умолчанию.
     */
    public ShellCommandRegister(List<ShellCommand> shellCommands) {
        this.shellCommands.addAll(shellCommands);
        HelpShellCommand helpShellCommand = new HelpShellCommand(this.shellCommands);
        this.shellCommands.add(helpShellCommand);
    }

    public List<ShellCommand> getShellCommands() {
        return shellCommands;
    }
}
