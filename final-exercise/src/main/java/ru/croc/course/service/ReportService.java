package ru.croc.course.service;

import ru.croc.course.model.dto.Report;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Данный класс представляет собой высокоуровневый сервис по работе с отчетами
 */
public class ReportService {

    private final Map<Class<?>, ReportProvider<?>> reportHandlerMap;

    public ReportService(List<ReportProvider<?>> reportProviders) {
        this.reportHandlerMap = reportProviders.stream()
                .collect(Collectors.toMap(ReportProvider::getProcessType, Function.identity()));
    }

    public <T extends Report> String getReport(T report) {
        ReportProvider<T> reportProvider = (ReportProvider<T>) reportHandlerMap.get(report.getClass());
        return reportProvider.getCompletedReport(report);
    }
}
