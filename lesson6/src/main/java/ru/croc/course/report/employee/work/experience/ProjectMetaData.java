package ru.croc.course.report.employee.work.experience;

import ru.croc.course.report.employee.Role;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "project")
/** Мета информация о проекте, используемая для отражения опыта работы сотрудника {@link PersonWorkExperience} */
public class ProjectMetaData {
    /** Название проекта */
    @XmlAttribute(name = "title")
    private String title;
    /** Роль человека на этом проекте */
    @XmlElement(name = "role")
    private Role role;
    /** Имя менеджера проекта, если есть */
    @XmlElement(name = "manager")
    private String managerName = "";

    /** Используется для jackson */
    public ProjectMetaData() {
    }

    public ProjectMetaData(String title, Role role, String managerName) {
        this.title = title;
        this.role = role;
        this.managerName = managerName;
    }

    /** Получает название проекта */
    public String getTitle() {
        return title;
    }
    /** Устанавливает название проекта */
    public void setTitle(String title) {
        this.title = title;
    }
    /** Получает роль сотрудника на проекте */

    public Role getRole() {
        return role;
    }
    /** Устанавливает роль сотрудника на проекте */
    public void setRole(Role role) {
        this.role = role;
    }
    /** Получает имя менеджера проекта */

    public String getManagerName() {
        return managerName;
    }
    /** Устанавливает имя менеджера на проекте */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return "ProjectMetaData{" +
                "title='" + title + '\'' +
                ", role=" + role +
                ", managerName='" + managerName + '\'' +
                '}';
    }
}
