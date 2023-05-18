package ru.croc.course.service;

import ru.croc.course.converter.XmlConverter;
import ru.croc.course.model.dto.AirTemperatureToAtmosphericPressureReport;
import ru.croc.course.model.entity.MeteorologicalData;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.DoubleSummaryStatistics;

public class AirTemperatureToAtmosphericPressureReportProvider extends ReportProvider<AirTemperatureToAtmosphericPressureReport> {


    private final XmlConverter xmlConverter;

    private MeteorologicalDataService meteorologicalDataService;

    public AirTemperatureToAtmosphericPressureReportProvider(XmlConverter xmlConverter, MeteorologicalDataService meteorologicalDataService) {
        super(AirTemperatureToAtmosphericPressureReport.class);
        this.xmlConverter = xmlConverter;
        this.meteorologicalDataService = meteorologicalDataService;
    }

    @Override
    public String getCompletedReport(AirTemperatureToAtmosphericPressureReport report) {

        LocalDateTime startDate = LocalDateTime.parse(report.getMeteorologicalDataSlice().getStartDate());
        LocalDateTime endDate = LocalDateTime.parse(report.getMeteorologicalDataSlice().getEndDate());

        var meteorologicalData = meteorologicalDataService.findByMeasurementDateBetween(startDate, endDate);
        DoubleSummaryStatistics temperatureStatistic = meteorologicalData.stream()
                .mapToDouble(MeteorologicalData::getAirTemperature)
                .summaryStatistics();
        DoubleSummaryStatistics pressureStatistic = meteorologicalData.stream()
                .mapToDouble(MeteorologicalData::getAtmosphericPressure)
                .summaryStatistics();
        DoubleSummaryStatistics temperatureToPressureStatistic = meteorologicalData.stream()
                .mapToDouble(value -> value.getAirTemperature() / value.getAtmosphericPressure())
                .summaryStatistics();

        report.getMeteorologicalDataSlice().getAirTemperature().setMin(temperatureStatistic.getMin());
        report.getMeteorologicalDataSlice().getAirTemperature().setMax(temperatureStatistic.getMax());
        report.getMeteorologicalDataSlice().getAtmosphericPressure().setMin(pressureStatistic.getMin());
        report.getMeteorologicalDataSlice().getAtmosphericPressure().setMax(pressureStatistic.getMax());
        report.getMeteorologicalDataSlice().getAitTemperatureToAtmospherePressure().setMax(temperatureToPressureStatistic.getMax());
        report.getMeteorologicalDataSlice().getAitTemperatureToAtmospherePressure().setMin(temperatureToPressureStatistic.getMin());

        try {
            return xmlConverter.toXml(report);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
