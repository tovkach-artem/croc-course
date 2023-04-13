package ru.croc.course.task.shell;

import ru.croc.course.support.shell.ShellCommand;
import ru.croc.course.support.shell.ShellCommandParsingResult;
import ru.croc.course.task.TaskService;

import java.util.List;
/** Консольная программа для удаления задач  */
public class DeleteTaskShellCommand implements ShellCommand {

    private final TaskService taskService;

    public DeleteTaskShellCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String getName() {
        return "deleteTask";
    }

    @Override
    public String getDescription() {
        return "удаляет задачу по ее номеру";
    }

    @Override
    public List<String> getArgumentsNames() {
        return List.of("number");
    }

    @Override
    public void handle(ShellCommandParsingResult shellCommandParsingResult) {
        taskService.deleteByNumber(shellCommandParsingResult.getArgumentNameToValue().get("number"));
    }

}
