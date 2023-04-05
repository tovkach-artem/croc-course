package ru.croc.course.entiry;

import java.util.Objects;

/** Сотрудники */
public class Employee {
    /** Уникальный идентификатор */
    private Integer id;
    /** Имя */
    private String name;
    /** Руководитель */
    Employee manager;

    public Employee(Integer id, String name, Employee manager) {
        this.id = id;
        this.name = name;
        this.manager = manager;
    }

    public boolean isDirector() {
        return manager == null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager=" + manager +
                '}' ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
