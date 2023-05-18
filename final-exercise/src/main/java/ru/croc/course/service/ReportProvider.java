package ru.croc.course.service;

import ru.croc.course.model.dto.Report;

public abstract class ReportProvider<T extends Report> {

    private final Class<T> processType;

    public abstract String getCompletedReport(T rawReport);

    public ReportProvider(Class<T> processType) {
        this.processType = processType;
    }

    public Class<T> getProcessType() {
        return processType;
    }
}
