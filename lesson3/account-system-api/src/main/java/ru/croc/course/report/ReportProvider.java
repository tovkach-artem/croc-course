package ru.croc.course.report;

import java.time.LocalDate;

public interface ReportProvider<T extends Report> {

    default T getActualReport()  {
        return getReportOnDate(LocalDate.now());
    }
    T getReportOnDate(LocalDate date);

}
