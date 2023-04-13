package ru.croc.course;

import ru.croc.course.support.shell.*;
import ru.croc.course.task.TaskService;
import ru.croc.course.task.TaskStorageConfig;
import ru.croc.course.task.TasksRepository;
import ru.croc.course.task.shell.*;

import java.util.List;

public class TaskTrackerShellApplication {

    public static void main(String[] args) {
        TaskStorageConfig taskStorageConfig = new TaskStorageConfig();
        TasksRepository tasksRepository = new TasksRepository();
        TaskService taskService = new TaskService(taskStorageConfig, tasksRepository);
        ShellCommand createTaskShellCommand = new CreateTaskShellCommand(taskService);
        ShellCommand updateTaskShellCommand = new UpdateTaskShellCommand(taskService);
        ShellCommand deleteTaskShellCommand = new DeleteTaskShellCommand(taskService);
        ShellCommand showTasksShellCommand = new ShowTasksShellCommand(taskService);
        ShellCommand saveTasksShellCommand = new SaveTasksShellCommand(taskService);
        ShellCommand exitTaskShellCommand = new ExitShellCommand();
        ShellCommandParser shellCommandParser = new ShellCommandParser();
        ShellCommandRegister shellCommandRegister = new ShellCommandRegister(
                List.of(createTaskShellCommand, updateTaskShellCommand,
                deleteTaskShellCommand, showTasksShellCommand,
                saveTasksShellCommand, exitTaskShellCommand));
        ShellCommandDispatcher shellCommandDispatcher = new ShellCommandDispatcher(shellCommandParser,shellCommandRegister);
        ShellApplicationRunner shellApplicationRunner = new ShellApplicationRunner(shellCommandDispatcher);
        shellApplicationRunner.run();
    }

}
