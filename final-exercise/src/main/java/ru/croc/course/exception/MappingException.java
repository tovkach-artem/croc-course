package ru.croc.course.exception;

public class MappingException extends RuntimeException{

    public MappingException(Throwable cause) {
        super("Ну удалось произвести маппинг: " + cause);
    }
}
