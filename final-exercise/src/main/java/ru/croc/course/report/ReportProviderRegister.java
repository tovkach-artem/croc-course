package ru.croc.course.report;

import java.util.ArrayList;
import java.util.List;

/**
 * Данный класс представляет собой реестр поставщиков отчетов {@link ReportProvider}. Цель класса заключается в
 * отслеживании и обеспечении доступа к зарегистрированным в приложении поставщикам отчетов.
 */
public class ReportProviderRegister {

    /**
     * Зарегистрированные поставщики отчетов
     */
    private List<ReportProvider> reportProviders = new ArrayList<>();

    public ReportProviderRegister(List<ReportProvider> reportProviders) {
        this.reportProviders.addAll(reportProviders);
    }

    /**
     * Возвращает всех зарегистрированных поставщиков отчетов
     */
    public List<ReportProvider> getReportProviders() {
        return reportProviders;
    }

    /**
     * Регистрирует нового поставщика отчетов
     */
    public void register(ReportProvider reportProvider) {
        reportProviders.add(reportProvider);
    }
}
