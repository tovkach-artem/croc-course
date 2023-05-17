package ru.croc.course.dto.report;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Данный класс используется для определения отчетов, которые могут быть сгенерированы в системе. Он может быть
 * сериализован в XML формат. Этот класс используется в качестве базового класса для конкретных отчетов.
 */
@XmlRootElement(name = "report")
public abstract class Report {

    /**
     * Тип отчета
     */
    @XmlAttribute(name = "type")
    private final String servicedReportType;

    public Report(String servicedReportType) {
        this.servicedReportType = servicedReportType;
    }

    /**
     * Возвращает тип отчета
     */
    public String getServicedReportType() {
        return servicedReportType;
    }

}
