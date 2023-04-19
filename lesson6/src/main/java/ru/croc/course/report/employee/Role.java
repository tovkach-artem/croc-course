package ru.croc.course.report.employee;

import javax.xml.bind.annotation.*;


@XmlType
@XmlEnum(String.class)
/** Роли сотрудников */
public enum Role {

    @XmlEnumValue("Менеджер") MANAGER,
    @XmlEnumValue("Специалист") SPECIALIST;


}
