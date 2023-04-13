package ru.croc.course.task;

import java.io.File;

public class TaskStorageConfig {

    private static final String DEFAULT_PATH_TO_STORAGE = "database.txt";

    private String pathToStorage = DEFAULT_PATH_TO_STORAGE;

    public TaskStorageConfig(String pathToStorage) {
        this.pathToStorage = pathToStorage;
        System.out.println("\u001B[33m Путь к базе данных был установлен. Используется файл : " + new File(pathToStorage).getAbsolutePath() + " \u001B[0m");
    }

    public TaskStorageConfig() {
        System.out.println("\u001B[33m Путь к базе данных не был установлен. Используется файл по умолчанию: " + new File("database.txt").getAbsolutePath() + " \u001B[0m");
    }

    public String getPathToStorage() {
        return pathToStorage;
    }

    public void setPathToStorage(String pathToStorage) {
        this.pathToStorage = pathToStorage;
    }
}
