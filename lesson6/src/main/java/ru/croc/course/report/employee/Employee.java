package ru.croc.course.report.employee;

import javax.xml.bind.annotation.XmlTransient;

/** Характеризует человека как сотрудника */
public abstract class Employee extends Person {

    /** Роль сотрудника */
    @XmlTransient
    private Role role;

    public Employee(String name, Role role) {
        super(name);
        this.role = role;
    }
    /** Используется для jackson */
    public Employee() {

    }

    /** Получает роль сотрудника */
    public Role getRole() {
        return role;
    }
    /** Устанавливает роль сотрудника */
    public void setRole(Role role) {
        this.role = role;
    }
}
