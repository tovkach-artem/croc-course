package ru.croc.course.task;

public class NoSuchTaskException extends RuntimeException{

    public NoSuchTaskException(String taskNumber) {
        super("Не найдена запрашиваемая задача " + taskNumber);
    }
}
