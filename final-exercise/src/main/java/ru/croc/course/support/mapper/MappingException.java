package ru.croc.course.support.mapper;

public class MappingException extends RuntimeException{

    public MappingException(Throwable cause) {
        super("Ну удалось произвести маппинг: " + cause);
    }
}
