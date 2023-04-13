package ru.croc.course.task.shell;

import ru.croc.course.support.shell.ShellCommand;
import ru.croc.course.support.shell.ShellCommandParsingResult;
import ru.croc.course.task.Task;
import ru.croc.course.task.TaskService;

import java.util.Collections;
import java.util.List;

/** Консольная программа для вывода на экран всех задач  */
public class ShowTasksShellCommand implements ShellCommand {

    private final TaskService taskService;

    public ShowTasksShellCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String getName() {
        return "showTasks";
    }

    @Override
    public String getDescription() {
        return "Выводит на экран все задачи";
    }

    @Override
    public List<String> getArgumentsNames() {
        return Collections.emptyList();
    }

    @Override
    public void handle(ShellCommandParsingResult shellCommandParsingResult) {
        List<Task> tasks = taskService.findAll();
        for (Task task : tasks) {
            System.out.println("-------------------------------------");
            System.out.printf("Задача № %s\nЗаголовок: %s\nОписание: %s\nИсполнитель: %s\nСтатус: %s\n",
                    task.getNumber(), task.getTitle(),  task.getDescription(), task.getExecutor(), task.getTaskStatus());
        }
        System.out.println("-------------------------------------");
    }
}
