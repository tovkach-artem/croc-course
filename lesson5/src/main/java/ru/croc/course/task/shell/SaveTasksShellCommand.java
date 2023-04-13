package ru.croc.course.task.shell;

import ru.croc.course.support.shell.ShellCommand;
import ru.croc.course.support.shell.ShellCommandParsingResult;
import ru.croc.course.task.TaskService;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/** Консольная программа для сохранения прогресса  */
public class SaveTasksShellCommand implements ShellCommand {

    private final TaskService taskService;

    public SaveTasksShellCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String getName() {
        return "saveTasks";
    }

    @Override
    public String getDescription() {
        return "сохраняет задачи в базу данных";
    }

    @Override
    public List<String> getArgumentsNames() {
        return Collections.emptyList();
    }

    @Override
    public void handle(ShellCommandParsingResult shellCommandParsingResult) {
        try {
            taskService.saveProgress();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
