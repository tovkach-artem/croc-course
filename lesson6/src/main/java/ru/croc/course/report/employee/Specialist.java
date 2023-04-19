package ru.croc.course.report.employee;

import ru.croc.course.report.employee.Employee;
import ru.croc.course.report.employee.Role;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "specialist")
/** Характеризует сотрудника, как специалиста */
public class Specialist extends Employee {

    public Specialist() {
    }

    public Specialist(String name) {
        super(name, Role.SPECIALIST);
    }


}
