package ru.croc.course.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/** Репозиторий для работы с хранилищем задач.
 * После запуска приложения данные из файла выгружаются из файла
 * в локальное хранилище, которое здесь и представлено.
 */
public class TasksRepository {

    private final List<Task> tasks = new ArrayList<>();
    /** Получает список всех задач */
    public List<Task> findAll() {
        return tasks;
    }
    /** Сохраняет задачу */
    public void save(Task task) {
        tasks.add(task);
    }
    /** Сохраняет список задач */
    public void saveAll(List<Task> tasks) {
        this.tasks.addAll(tasks);
    }
    /** Удаляет задачу по номеру */
    public void deleteByNumber(String number) {
        findByNumber(number).ifPresent(tasks::remove);
    }
    /** Ищет задачу по номеру */
    public Optional<Task> findByNumber(String number) {
        return tasks.stream()
                .filter(task -> task.getNumber().equals(number))
                .findFirst();
    }

    /** Обновляет задачу по номеру */
    public void updateByNumber(String number, Task updatedTask) {
        findByNumber(number).ifPresent(task -> {
            task.setNumber(updatedTask.getNumber());
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setExecutor(updatedTask.getExecutor());
            task.setTaskStatus(updatedTask.getTaskStatus());
        });
    }
}
