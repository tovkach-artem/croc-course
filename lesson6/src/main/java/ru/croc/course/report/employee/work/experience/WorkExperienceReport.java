package ru.croc.course.report.employee.work.experience;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "people")
/** Является оберткой для сериализация и десериализации коллекции {@link PersonWorkExperience}*/
public class WorkExperienceReport {

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "person")
    /** Сотрудники и их опыт работы */
    private List<PersonWorkExperience> personWorkExperiences;
    /** Используется для jackson */
    public WorkExperienceReport() {
    }

    public WorkExperienceReport(List<PersonWorkExperience> personWorkExperiences) {
        this.personWorkExperiences = personWorkExperiences;
    }
    /** Получает сотрудников и их опыт работы */
    public List<PersonWorkExperience> getPersonWorkExperiences() {
        return personWorkExperiences;
    }
    /** Устанавливает сотрудников и их опыт работы */
    public void setPersonWorkExperiences(List<PersonWorkExperience> personWorkExperiences) {
        this.personWorkExperiences = personWorkExperiences;
    }
}
