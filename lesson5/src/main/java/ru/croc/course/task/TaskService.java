package ru.croc.course.task;

import ru.croc.course.support.io.ObjectIOManipulationService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
/** Сервис по работе с задачами */
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

    /** Создает новую задачу в хранилище (локальном) */
    public void create(Task task) {
        tasksRepository.save(task);
    }
    /** Сохраняет результат работы в хранилище (файл) */
    public void saveProgress() throws IOException {
        objectIOManipulationService.writeObjectsToFile(tasksRepository.findAll(), new File(taskStorageConfig.getPathToStorage()));
    }
    /** Выгружает данные из хранилища (файл) в локальное */
    private void initializeTasksFromStorage() {
        try {
            tasksRepository.saveAll(objectIOManipulationService.readObjectsFromFile(new File(taskStorageConfig.getPathToStorage())));
            System.out.println("\u001B[32m Данные из хранилища " + new File(taskStorageConfig.getPathToStorage()).getAbsolutePath() + " успешно проинициализированы \u001B[0m");
        } catch (Exception exception) {
            System.out.println("\u001B[31m Не удалось проинициализировать данные из хранилища " + new File(taskStorageConfig.getPathToStorage()).getAbsolutePath() + " по причине: " + exception.getMessage() + " \u001B[0m");
        }
    }
    /** Получает список всех задач, которые сейчас в локальном хранилище*/
    public List<Task> findAll() {
        return tasksRepository.findAll();
    }
    /** Удаляет задачу по номеру из локального хранилища */
    public void deleteByNumber(String number) {
        tasksRepository.deleteByNumber(number);
    }
    /** Обновляет задачу по номеру в локальном хранилище */
    public void updateByNumber(String number, Task task) {
        tasksRepository.updateByNumber(number, task);
    }
    /** Получает задачу по номеру из локального хранилища */
    public Optional<Task> findByNumber(String number) {
        return tasksRepository.findByNumber(number);
    }
}
