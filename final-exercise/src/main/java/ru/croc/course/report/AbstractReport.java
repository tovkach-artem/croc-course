package ru.croc.course.report;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Данный класс используется для определения отчетов, которые могут быть сгенерированы в системе. Он может быть
 * сериализован в XML формат. Этот класс используется в качестве базового класса для конкретных отчетов.
 */
@XmlRootElement(name = "Report")
public abstract class AbstractReport {

    /**
     * Тип отчета
     */
    @XmlAttribute(name = "type")
    private final ReportType servicedReportType;

    public AbstractReport(ReportType servicedReportType) {
        this.servicedReportType = servicedReportType;
    }

    /**
     * Возвращает тип отчета
     */
    public ReportType getServicedReportType() {
        return servicedReportType;
    }

}
