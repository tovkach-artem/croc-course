package ru.croc.course.report.employee.project.employment;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "projects")
/** Wrapper для сериализация и десериализации коллекции {@link Project}*/
public class Projects {

    /** Проекты */
    private List<Project> projects;
    /** Используется для jackson */
    public Projects() {
    }

    public Projects(List<Project> projects) {
        this.projects = projects;
    }
    /** Получает проекты */
    public List<Project> getProjects() {
        return projects;
    }

    /** Устанавливает проекты */
    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "project")
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
