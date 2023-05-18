package ru.croc.course;

import ru.croc.course.database.datasource.DataSourceProvider;
import ru.croc.course.database.datasource.H2DataSourceProvider;
import ru.croc.course.converter.JacksonXmlConverter;
import ru.croc.course.converter.XmlConverter;
import ru.croc.course.database.init.script.impl.BasicResourcesDataScriptDatabaseInitializer;
import ru.croc.course.database.init.script.impl.BasicResourcesSchemaScriptDatabaseInitializer;
import ru.croc.course.database.init.DatabaseInitializer;
import ru.croc.course.model.dto.AirTemperatureToAtmosphericPressureReport;
import ru.croc.course.repository.MeteorologicalDataRepository;
import ru.croc.course.service.MeteorologicalDataService;
import ru.croc.course.service.ReportService;
import ru.croc.course.service.AirTemperatureToAtmosphericPressureReportProvider;
import ru.croc.course.service.ReportProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class MeteorologicalModuleApplication {

    public static void main(String[] args) throws IOException {

        DataSourceProvider dataSourceProvider = new H2DataSourceProvider();

        var basicResourcesSchemaScriptDatabaseInitializer = new BasicResourcesSchemaScriptDatabaseInitializer(dataSourceProvider);
        var basicResourcesDataScriptDatabaseInitializer = new BasicResourcesDataScriptDatabaseInitializer(dataSourceProvider);
        DatabaseInitializer databaseInitializer = new DatabaseInitializer(List.of(basicResourcesDataScriptDatabaseInitializer, basicResourcesSchemaScriptDatabaseInitializer));

        MeteorologicalDataRepository meteorologicalDataRepository = new MeteorologicalDataRepository(dataSourceProvider);
        MeteorologicalDataService meteorologicalDataService = new MeteorologicalDataService(meteorologicalDataRepository);

        XmlConverter xmlConverter = new JacksonXmlConverter();
        ReportProvider reportProvider = new AirTemperatureToAtmosphericPressureReportProvider(xmlConverter, meteorologicalDataService);
        ReportService reportService = new ReportService(List.of(reportProvider));

        LocalDateTime startDate = LocalDateTime.of(2023, 05, 15, 10, 00);
        LocalDateTime endDate = LocalDateTime.of(2023, 05, 18, 11, 00);


        var airTemperatureToAtmosphericPressureReport = new AirTemperatureToAtmosphericPressureReport(startDate, endDate);

        String xmlFormattedReport = reportService.getReport(airTemperatureToAtmosphericPressureReport);
        System.out.println(xmlFormattedReport);


    }

}
