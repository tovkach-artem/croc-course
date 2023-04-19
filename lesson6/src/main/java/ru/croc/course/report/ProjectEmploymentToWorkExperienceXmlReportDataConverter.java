package ru.croc.course.report;

import ru.croc.course.report.employee.Manager;
import ru.croc.course.report.employee.Role;
import ru.croc.course.report.employee.Specialist;
import ru.croc.course.report.employee.project.employment.Project;
import ru.croc.course.report.employee.project.employment.Projects;
import ru.croc.course.report.employee.work.experience.ProjectMetaData;
import ru.croc.course.report.employee.work.experience.PersonWorkExperience;
import ru.croc.course.report.employee.work.experience.WorkExperienceReport;
import ru.croc.course.support.xml.XmlDataConverter;

import java.io.IOException;
import java.util.*;
/** Сервис предназначен для преобразования входной строки, отражающего информацию о проекте и его сотрудниках,
 * в выходящую строку, отражающую информацию об опыте работы сотрдуников  */
public class ProjectEmploymentToWorkExperienceXmlReportDataConverter implements XmlReportDataConverter {

    /** Преобразователь xml в объектную модель */
    private final XmlDataConverter xmlDataConverter;

    public ProjectEmploymentToWorkExperienceXmlReportDataConverter(XmlDataConverter xmlDataConverter) {
        this.xmlDataConverter = xmlDataConverter;
    }
    /** Преобразует входную строки, отражающего информацию о проекте и его сотрудниках,
     * в выходящую строку, отражающую информацию об опыте работы сотрудников */
    @Override
    public String convert(String source) throws IOException {
        Projects projects = xmlDataConverter.fromXml(source, Projects.class);
        Map<String, PersonWorkExperience> personNameToWorkExperience = new HashMap<>();
        for (Project project : projects.getProjects()) {
            fillManagerInformation(project, personNameToWorkExperience);
        }

        List<PersonWorkExperience> personWorkExperiences = new ArrayList<>(personNameToWorkExperience.values());
        personWorkExperiences.sort(Comparator.comparing(PersonWorkExperience::getName));
        WorkExperienceReport workExperienceReport = new WorkExperienceReport(personWorkExperiences);
        String generatedXml = xmlDataConverter.toXml(workExperienceReport);
        return generatedXml;
    }
    /** Заполняет информацию о менеджерах и их опыте работы, а также об их подчиненных*/
    private void fillManagerInformation(Project project, Map<String, PersonWorkExperience> personNameToWorkExperience) {
        for (Manager manager : project.getManagers()) {
            String managerName = manager.getName();
            PersonWorkExperience managerPersonWorkExperience = new PersonWorkExperience();
            managerPersonWorkExperience.setName(managerName);
            ProjectMetaData projectMetaData = new ProjectMetaData();
            projectMetaData.setRole(Role.MANAGER);
            projectMetaData.setTitle(project.getTitle());
            managerPersonWorkExperience.addProjectMetaData(projectMetaData);
            if(personNameToWorkExperience.containsKey(managerName)) {
                personNameToWorkExperience.get(managerName).addProjectMetaData(projectMetaData);
            } else {
                personNameToWorkExperience.put(managerName, managerPersonWorkExperience);
            }
            fillSpecialistInformation(project, manager, personNameToWorkExperience);
        }

    }
    /** Заполняет информацию о специалистах и их опыте работы, а также об их менеджерах*/
    private void fillSpecialistInformation(Project project, Manager manager, Map<String, PersonWorkExperience> personNameToWorkExperience) {
        for (Specialist specialist : manager.getSpecialists()) {
            String specialistName = specialist.getName();
            PersonWorkExperience specialistPersonWorkExperience = new PersonWorkExperience();
            specialistPersonWorkExperience.setName(specialistName);
            ProjectMetaData specialistProjectMetaData = new ProjectMetaData();
            specialistProjectMetaData.setTitle(project.getTitle());
            specialistProjectMetaData.setManagerName(manager.getName());
            specialistProjectMetaData.setRole(Role.SPECIALIST);
            specialistPersonWorkExperience.addProjectMetaData(specialistProjectMetaData);
            List<PersonWorkExperience> specialistPersonWorkExperiences = new ArrayList<>();
            specialistPersonWorkExperiences.add(specialistPersonWorkExperience);

            if(personNameToWorkExperience.containsKey(specialistName)) {
                personNameToWorkExperience.get(specialistName).addProjectMetaData(specialistProjectMetaData);
            } else {
                personNameToWorkExperience.put(specialistName, specialistPersonWorkExperience);
            }
        }
    }

    public XmlDataConverter getXmlDataConverter() {
        return xmlDataConverter;
    }
}
