package ru.croc.course.report;

import ru.croc.course.support.Model;

/**
 * Данный класс представляет собой высокоуровневый сервис по работе с отчетами
 */
public class ReportService {

    /**
     * Диспетчер поставщиков отчетов
     */
    private ReportProviderDispatcher reportProviderDispatcher;

    public ReportService(ReportProviderDispatcher reportProviderDispatcher) {
        this.reportProviderDispatcher = reportProviderDispatcher;
    }

    /**
     * Возвращает обработанный отчет. Внутри метод использует {@link ReportProviderDispatcher} для отправки запроса
     * соответствующему поставщику отчетов в зависимости от типа отчета.
     */
    public String getReport(ReportType reportType, Model model) {
        return reportProviderDispatcher.getReport(reportType, model);
    }

}
