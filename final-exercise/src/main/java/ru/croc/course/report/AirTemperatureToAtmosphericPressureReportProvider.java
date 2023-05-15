package ru.croc.course.report;

import ru.croc.course.support.Model;
import ru.croc.course.support.ReferenceModel;
import ru.croc.course.support.ReferenceModelSet;
import ru.croc.course.support.xml.XmlDataConverter;
import ru.croc.course.weather.MeteorologicalData;
import ru.croc.course.weather.MeteorologicalDataService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Function;

/**
 * Данный класс является поставщиком {@link ReportProvider} отчета об соотношении температуры воздуха к атмосферному
 * давлению за выбранный промежуток времени. Он предоставляет отчет в XML формате.
 */
public class AirTemperatureToAtmosphericPressureReportProvider implements ReportProvider {
    /** Преобразователь данных из XML в объектную модель и обратно */
    private final XmlDataConverter xmlDataConverter;

    /** Сервис предоставляющий метеорологический данные */
    private final MeteorologicalDataService meteorologicalDataService;

    public AirTemperatureToAtmosphericPressureReportProvider(XmlDataConverter xmlDataConverter, MeteorologicalDataService meteorologicalDataService) {
        this.xmlDataConverter = xmlDataConverter;
        this.meteorologicalDataService = meteorologicalDataService;
    }
    /**
     * Отражает информацию, что данный поставщик обслуживает тип отчета {@link ReportType#AIR_TEMPERATURE_TO_ATMOSPHERIC_PRESSURE}
     */
    @Override
    public ReportType getServicedReportType() {
        return ReportType.AIR_TEMPERATURE_TO_ATMOSPHERIC_PRESSURE;
    }

    /**
     * Данный метод возвращает функцию, которая принимает объект модели и возвращает строку. Внутри метода функция
     * используется для создания отчета на основе данных о метеорологических изменениях, полученных с помощью сервиса
     * {@link MeteorologicalDataService}. Для создания отчета вычисляются минимальные и максимальные значения для
     * температуры воздуха и атмосферного давления, а также для соотношения температуры воздуха и атмосферного давления.
     * Затем создается объект отчета {@link ru.croc.course.report.AirTemperatureToAtmosphericPressureReport},
     * заполняются его поля на основе вычисленных значений и объект преобразуется в формат XML с помощью
     * {@link XmlDataConverter}
     */
    @Override
    public Function<Model, String> getReportRenderFunction() {
        Function<Model, String> renderReportFunction = model -> {

            List<MeteorologicalData> byMeasurementDateBetween = meteorologicalDataService.findByMeasurementDateBetween(LocalDateTime.parse(model.getAttribute("startDate")), LocalDateTime.parse(model.getAttribute("endDate")));

            DoubleSummaryStatistics temperatureStatistic = byMeasurementDateBetween.stream()
                    .mapToDouble(MeteorologicalData::getAirTemperature)
                    .summaryStatistics();
            DoubleSummaryStatistics pressureStatistic = byMeasurementDateBetween.stream()
                    .mapToDouble(MeteorologicalData::getAirTemperature)
                    .summaryStatistics();
            DoubleSummaryStatistics temperatureToPressureStatistic = byMeasurementDateBetween.stream()
                    .mapToDouble(value -> value.getAirTemperature() / value.getAtmosphericPressure())
                    .summaryStatistics();


            var report = new AirTemperatureToAtmosphericPressureReport();
            report.getMeteorologicalDataSlice().setStartDate(model.getAttribute("startDate"));
            report.getMeteorologicalDataSlice().setEndDate(model.getAttribute("endDate"));
            report.getMeteorologicalDataSlice().getAirTemperature().setMin(temperatureStatistic.getMin());
            report.getMeteorologicalDataSlice().getAirTemperature().setMax(temperatureStatistic.getMax());
            report.getMeteorologicalDataSlice().getAtmosphericPressure().setMin(pressureStatistic.getMin());
            report.getMeteorologicalDataSlice().getAtmosphericPressure().setMax(pressureStatistic.getMax());
            report.getMeteorologicalDataSlice().getAitTemperatureToAtmospherePressure().setMax(temperatureToPressureStatistic.getMax());
            report.getMeteorologicalDataSlice().getAitTemperatureToAtmospherePressure().setMin(temperatureToPressureStatistic.getMin());
            try {
                return xmlDataConverter.toXml(report);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        return renderReportFunction;
    }
    /**
     * Определяет список значений модели данных, которые должны быть заполнены для построения отчета:
     * <ul>
     *     <li>startDate - дата начала выборки</li>
     *     <li>endDate - дата окончания выборки</li>
     * </ul>
     */
    @Override
    public ReferenceModel getReferenceModel() {
        ReferenceModel referenceModel = new ReferenceModelSet();
        referenceModel.addAttribute("startDate");
        referenceModel.addAttribute("endDate");
        return referenceModel;
    }
}
