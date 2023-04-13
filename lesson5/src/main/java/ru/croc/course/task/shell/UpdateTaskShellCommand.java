package ru.croc.course.task.shell;

import ru.croc.course.support.shell.ShellCommand;
import ru.croc.course.support.shell.ShellCommandParsingResult;
import ru.croc.course.task.NoSuchTaskException;
import ru.croc.course.task.Task;
import ru.croc.course.task.TaskService;
import ru.croc.course.task.TaskStatus;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UpdateTaskShellCommand implements ShellCommand {

    private final TaskService taskService;

    public UpdateTaskShellCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String getName() {
        return "updateTask";
    }

    @Override
    public String getDescription() {
        return "обновляет задачу по ее номеру";
    }

    @Override
    public List<String> getArgumentsNames() {
        return List.of("number");
    }

    @Override
    public void handle(ShellCommandParsingResult shellCommandParsingResult) {
        Scanner scanner = new Scanner(System.in);
        String taskNumber = shellCommandParsingResult.getArgumentNameToValue().get("number");
        Task taskForUpdate = taskService.findByNumber(taskNumber).orElseThrow(() -> new NoSuchTaskException(taskNumber));
        System.out.print("Введите номер: (предыдущее значение  "+ taskForUpdate.getNumber() +") ");
        String updatedNumber = scanner.nextLine();
        if(!updatedNumber.isEmpty()) {
            taskForUpdate.setNumber(updatedNumber);
        }
        System.out.print("Введите заголовок: (предыдущее значение "+ taskForUpdate.getTitle() +") ");
        String updatedTitle = scanner.nextLine();
        if(!updatedTitle.isEmpty()) {
            taskForUpdate.setTitle(updatedTitle);
        }
        System.out.print("Введите описание: (предыдущее значение "+ taskForUpdate.getDescription() +") ");
        String updatedDescription = scanner.nextLine();
        if(!updatedDescription.isEmpty()) {
            taskForUpdate.setDescription(updatedDescription);
        }
        System.out.print("Введите исполнителя: (предыдущее значение "+ taskForUpdate.getExecutor() +") ");
        String updatedExecutor = scanner.nextLine();
        if(!updatedExecutor.isEmpty()) {
            taskForUpdate.setExecutor(updatedExecutor);
        }
        System.out.print("Введите статус "+ Set.of(TaskStatus.values()) +": (предыдущее значение "+ taskForUpdate.getTaskStatus() +") ");
        String updatedStatus = scanner.nextLine();
        if(!updatedStatus.isEmpty()) {
            taskForUpdate.setTaskStatus(TaskStatus.valueOf(updatedStatus));
        }
    }
}
