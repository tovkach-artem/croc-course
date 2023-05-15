package ru.croc.course.report;

import ru.croc.course.support.Model;

/**
 * Данный класс распределяет запросы на формирование отчета соответствующему {@link ReportProvider} на основании
 * указанного {@link ReportType}. Это делается путем поиска в списке зарезервированных поставщиков отчетов и нахождения
 * того, который обслуживает указанный тип отчета. Как только он находит соответствующего поставщика отчета он вызывает
 * метод {@link ReportProvider#getReport(Model)} для этого объекта, передавая объект {@link Model}, и возвращает
 * результирующий отчет в виде {@link String}.
 */
public class ReportProviderDispatcher {

    private ReportProviderRegister reportProviderRegister;

    public ReportProviderDispatcher(ReportProviderRegister reportProviderRegister) {
        this.reportProviderRegister = reportProviderRegister;
    }

    public String getReport(ReportType reportType, Model model) {
        ReportProvider servicedReportProvider = reportProviderRegister.getReportProviders().stream()
                .filter(reportProvider -> reportProvider.getServicedReportType().equals(reportType))
                .findFirst().orElseThrow(() -> new RuntimeException("Необслуживаемый вид отчета"));
        return servicedReportProvider.getReport(model);
    }

}
