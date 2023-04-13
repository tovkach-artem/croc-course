package ru.croc.course.task.shell;

import ru.croc.course.support.shell.ShellCommand;
import ru.croc.course.support.shell.ShellCommandParsingResult;
import ru.croc.course.task.Task;
import ru.croc.course.task.TaskService;
import ru.croc.course.task.TaskStatus;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CreateTaskShellCommand implements ShellCommand {

    private final TaskService taskService;

    public CreateTaskShellCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String getName() {
        return "createNewTask";
    }

    @Override
    public String getDescription() {
        return "создает новую задачу";
    }

    @Override
    public List<String> getArgumentsNames() {
        return Collections.emptyList();
    }

    @Override
    public void handle(ShellCommandParsingResult shellCommandParsingResult) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер: ");
        String number = scanner.nextLine();
        System.out.print("Введите заголовок: ");
        String title = scanner.nextLine();
        System.out.print("Введите описание: ");
        String description = scanner.nextLine();
        System.out.print("Введите исполнителя: ");
        String executor = scanner.nextLine();
        System.out.printf("Введите статус %s: ", Set.of(TaskStatus.values()));
        String status = scanner.nextLine();
        Task task = new Task(number, title, description, executor, TaskStatus.valueOf(status));
        taskService.create(task);
    }
}
