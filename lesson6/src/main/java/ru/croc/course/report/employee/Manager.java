package ru.croc.course.report.employee;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

/** Характеризует сотрудника как менеджера */
public class Manager extends Employee {

    /** Подчиненные специалисты */
    @XmlElementWrapper(name = "specialists")
    @XmlElement(name = "specialist")
    private List<Specialist> specialists = new ArrayList<>();

    public Manager() {

    }

    public Manager(String name, Role role) {
        super(name, role);
    }

    public Manager(String name) {
        super(name, Role.MANAGER);
    }

    /** Позволяет добавить специалиста */
    public void addSpecialist(Specialist specialist) {
        specialists.add(specialist);

    }
    /** Позволяет получить специалистов, с которыми работает Manager */
    public List<Specialist> getSpecialists() {
        return specialists;
    }
}
