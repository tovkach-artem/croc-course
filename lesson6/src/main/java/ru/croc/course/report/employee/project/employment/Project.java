package ru.croc.course.report.employee.project.employment;

import ru.croc.course.report.employee.Manager;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
@XmlType(name = "project")
/** Информация о проекте */
public class Project {

    /** Название проекта */
    private String title;
    /** Описание проекта */
    private String description;
    /** Менеджеры проекта */
    private List<Manager> managers = new ArrayList<>();

    /** Используется для jackson */
    public Project() {
    }

    public Project(String title, String description, List<Manager> managers) {
        this.title = title;
        this.description = description;
        this.managers = managers;
    }
    /** Получает название проекта */
    public String getTitle() {
        return title;
    }
    /** Устанавливает название проекта */
    @XmlElement(name = "title")
    public void setTitle(String title) {
        this.title = title;
    }
    /** Получает описание проекта */
    public String getDescription() {
        return description;
    }
    /** Устанавливает описание проекта */
    @XmlElement(name = "description")
    public void setDescription(String description) {
        this.description = description;
    }
    /** Получает менеджеров проекта */
    public List<Manager> getManagers() {
        return managers;
    }
    /** Устанавливает менеджеров проекта */
    @XmlElementWrapper(name = "managers")
    @XmlElement(name = "manager")
    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", managers=" + managers +
                '}';
    }
}
