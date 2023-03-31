package ru.croc.course.support.repository;

import ru.croc.course.support.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/** Дефолтная реализация интерфейса {@link Repository} для всех репозиториев, работающих с хранилищем в виде {@link ArrayList}.
 * Данный класс позволяет избежать дублирования кода, так как реализация основных операций работы с хранилищами для разных объектов
 * весьма схожая. Если необходимо кастомное поведение всегда можно переопределить метод в классе наследнике.
 */
public abstract class DefaultArrayListBasedRepository<T extends BaseEntity<ID>, ID> implements Repository<T, ID> {
    private final List<T> entities = new ArrayList<>();

    @Override
    public Optional<T> findById(ID id) {
        return entities.stream()
                .filter(entity ->  entity.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return entities;
    }

    @Override
    public Optional<T> save(T entity) {
        entities.add(entity);
        return Optional.of(entity);
    }

    @Override
    public boolean delete(T entity) {
        return entities.remove(entity);
    }


}

