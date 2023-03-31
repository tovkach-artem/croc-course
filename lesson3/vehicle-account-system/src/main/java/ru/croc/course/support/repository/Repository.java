package ru.croc.course.support.repository;

import ru.croc.course.support.entity.BaseEntity;

import java.util.List;
import java.util.Optional;
/** Интерфейс содержит общее поведение для всех репозиториев */
public interface Repository <T extends BaseEntity<ID>, ID>{
    /** Позволяет найти объект по его уникальному идентификатору */
    Optional<T> findById(ID id);
    /** Позволяет получить список всех объектов, которые хранятся в репозитории */
    List<T> findAll();
    /** Позволяет сохранить объект в репозитории.
     * Возвращает объект с установленным уникальным идентификатором.
     */
    Optional<T> save(T entity);
    /** Позволяет удалить объект из репозитория */
    boolean delete(T entity);
}
