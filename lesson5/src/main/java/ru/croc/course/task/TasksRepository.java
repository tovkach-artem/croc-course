package ru.croc.course.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TasksRepository {

    private final List<Task> tasks = new ArrayList<>();

    public List<Task> findAll() {
        return tasks;
    }

    public void save(Task task) {
        tasks.add(task);
    }

    public void saveAll(List<Task> tasks) {
        this.tasks.addAll(tasks);
    }

    public void deleteByNumber(String number) {
        findByNumber(number).ifPresent(tasks::remove);
    }

    public Optional<Task> findByNumber(String number) {
        return tasks.stream()
                .filter(task -> task.getNumber().equals(number))
                .findFirst();
    }

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
