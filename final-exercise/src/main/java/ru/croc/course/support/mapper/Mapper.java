package ru.croc.course.support.mapper;

/**
 * Данный интерфейс предназначен для реализации классами,
 * которые служат для преобразования объектов типа `F` в объекты типа `T`
 */
public interface Mapper <F, T>{

    T mapFrom (F object);

}
