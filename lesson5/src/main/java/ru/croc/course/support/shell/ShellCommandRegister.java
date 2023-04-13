package ru.croc.course.support.shell;

import java.util.ArrayList;
import java.util.List;

public class ShellCommandRegister {
    private List<ShellCommand> shellCommands = new ArrayList<>();

    public ShellCommandRegister(List<ShellCommand> shellCommands) {
        this.shellCommands.addAll(shellCommands);
        HelpShellCommand helpShellCommand = new HelpShellCommand(this.shellCommands);
        this.shellCommands.add(helpShellCommand);
    }

    public List<ShellCommand> getShellCommands() {
        return shellCommands;
    }
}
