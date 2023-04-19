package ru.croc.course.report.employee.work.experience;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/** Опыт работы человека */
@XmlRootElement(name = "person")
public class PersonWorkExperience {

    /** Имя человека */
    @XmlElement(name = "name")
    private String name;
    @XmlElementWrapper(name = "projects")
    @XmlElement(name = "project")
    /** Мета информация о проекте, на котором работал человек */
    private List<ProjectMetaData> projectMetaDatas = new ArrayList<>();
    /** Используется для jackson */
    public PersonWorkExperience() {
    }

    public PersonWorkExperience(String name, List<ProjectMetaData> projectMetaDatas) {
        this.name = name;
        this.projectMetaDatas = projectMetaDatas;
    }
    /** Получает имя человека */
    public String getName() {
        return name;
    }
    /** Устанавливает имя человека */
    public void setName(String name) {
        this.name = name;
    }
    /** Получает мета информацию о проектах */
    public List<ProjectMetaData> getProjectMetaDatas() {
        return projectMetaDatas;
    }
    /** Устанавливает мета информацию о проектах */
    public void setProjectMetaDatas(List<ProjectMetaData> projectMetaDatas) {
        this.projectMetaDatas = projectMetaDatas;
    }
    /** Добавляет мета информацию о новом проекте */
    public void addProjectMetaData(ProjectMetaData projectMetaData) {
        projectMetaDatas.add(projectMetaData);
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "name='" + name + '\'' +
                ", projectMetaDatas=" + projectMetaDatas +
                '}';
    }
}
