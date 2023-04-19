package ru.croc.course.report.employee;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "person")
/** Общий класс человека */
public abstract class Person {

    public Person() {
    }
    /** Имя человека */
    @XmlAttribute(name = "name")
    private String name;

    public Person(String name) {
        this.name = name;
    }
    /** Получает имя человека */
    public String getName() {
        return name;
    }
    /** Устанавливает имя человека */
    public void setName(String name) {
        this.name = name;
    }
    /** Переопределяет equals по полю name, так как есть условие, что поле уникальное */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }
    /** Переопределяет hashCode по полю name, так как есть условие, что поле уникальное */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
