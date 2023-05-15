package ru.croc.course.report;

import ru.croc.course.support.Model;
import ru.croc.course.support.ReferenceModel;

import java.util.function.Function;


/**
 * Данный интерфейс определяет контракт для объектов, которые предоставляют отчеты на основе модели данных. Он содержит
 * методы для получения отчета на основе модели данных, определения типа отчета, который обслуживается объектом,
 * получения списка значений, необходимых для построения отчета
 */
public interface ReportProvider {

    /**
     * Возвращает строку, представляющую собой отчет на основе переданной модели данных. Если модель данных не содержит
     * необходимых значений, то метод выбрасывает исключение
     */
    default String getReport(Model model) {
        if (canRender(model)) {
            return getReportRenderFunction().apply(model);
        } else {
            throw new RuntimeException("Не удается построить отчет по заданной модели данных: " + model);
        }
    }

    /**
     * Определяет тип отчета, который обрабатывается объектом, реализующим этот интерфейс
     */
    ReportType getServicedReportType();

    /**
     * Возвращает список значений модели данных, которые должны быть заполнены для построения отчета
     */
    ReferenceModel getReferenceModel();

    /**
     * Проверяет, можно ли построить отчет на основе переданной модели данных. На данный момент проверяет наличие
     * необходимых значений в модели данных
     */
    private boolean canRender(Model model) {
        return getReferenceModel().asSet().stream()
                .allMatch(key -> model.asMap().containsKey(key) && model.asMap().get(key) != null);
    }

    /**
     * Возвращает функцию, которая принимает модель данных и возвращает строку, представляющую отчет на основе этой модели
     */
    Function<Model, String> getReportRenderFunction();

}
