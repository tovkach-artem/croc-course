package ru.croc.course.task;

import ru.croc.course.support.io.ObjectIOManipulationService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TaskService {

    private final TaskStorageConfig taskStorageConfig;
    private final ObjectIOManipulationService<Task> objectIOManipulationService;
    private final TasksRepository tasksRepository;
    public TaskService(TaskStorageConfig taskStorageConfig, TasksRepository tasksRepository) {
        this.taskStorageConfig = taskStorageConfig;
        this.objectIOManipulationService = new ObjectIOManipulationService<>();
        this.tasksRepository = tasksRepository;
        initializeTasksFromStorage();
    }

    public void create(Task task) {
        tasksRepository.save(task);
    }

    public void saveProgress() throws IOException {
        objectIOManipulationService.writeObjectsToFile(tasksRepository.findAll(), new File(taskStorageConfig.getPathToStorage()));
    }

    private void initializeTasksFromStorage() {
        try {
            tasksRepository.saveAll(objectIOManipulationService.readObjectsFromFile(new File(taskStorageConfig.getPathToStorage())));
            System.out.println("\u001B[32m Данные из хранилища " + new File(taskStorageConfig.getPathToStorage()).getAbsolutePath() + " успешно проинициализированы \u001B[0m");
        } catch (Exception exception) {
            System.out.println("\u001B[31m Не удалось проинициализировать данные из хранилища " + new File(taskStorageConfig.getPathToStorage()).getAbsolutePath() + " по причине: " + exception.getMessage() + " \u001B[0m");
        }
    }

    public List<Task> findAll() {
        return tasksRepository.findAll();
    }

    public void deleteByNumber(String number) {
        tasksRepository.deleteByNumber(number);
    }

    public void updateByNumber(String number, Task task) {
        tasksRepository.updateByNumber(number, task);
    }

    public Optional<Task> findByNumber(String number) {
        return tasksRepository.findByNumber(number);
    }
}
