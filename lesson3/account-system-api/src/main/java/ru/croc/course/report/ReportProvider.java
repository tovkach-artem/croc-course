package ru.croc.course.report;

import java.time.LocalDate;

/**
 * Интерфейс говорящий о том, что имплементирующий объект обязан предоставлять отчет.
 * Задумывалось так, интерфейс должны имплементировать объекты сервисного слоя,
 * так как они обладают наибольшей информацией об объектной модели.
 * @param <T> показывает как тип отчета должен возвращать наш провайдер.
 */
public interface ReportProvider<T extends Report> {
    /** Возвращает актуальный отчет, который должен предоставить провайдер отчетов.
     * По умолчанию актуальным считается отчет, дата созданий, которого - сегодня.
     */
    default T getActualReport()  {
        return getReportOnDate(LocalDate.now());
    }
    /** Возвращает отчет, который должен предоставить провайдер отчетов на определенную дату*/
    T getReportOnDate(LocalDate date);

}
