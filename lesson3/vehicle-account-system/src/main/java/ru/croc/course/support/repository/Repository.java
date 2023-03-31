package ru.croc.course.support.repository;

import ru.croc.course.support.entity.BaseEntity;

import javax.management.relation.InvalidRelationIdException;
import java.util.List;
import java.util.Optional;

public interface Repository <T extends BaseEntity<ID>, ID>{
    Optional<T> findById(ID id);
    List<T> findAll();
    Optional<T> save(T entity);
    boolean delete(T entity);
}
