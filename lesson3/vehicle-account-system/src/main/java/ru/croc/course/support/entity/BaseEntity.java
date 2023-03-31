package ru.croc.course.support.entity;

public interface BaseEntity<T> {
    T getId();

    void setId(T id);
}
