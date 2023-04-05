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

    /** Определяет, является ли сотрудник директором:
     * директором является сотрудник у которого нет менеджера.
     */
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

    /** Переопределяет метод equals на основе id так как оно поле уникальное */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }
    /** Переопределяет метод hashCode на основе id так как оно поле уникальное */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
