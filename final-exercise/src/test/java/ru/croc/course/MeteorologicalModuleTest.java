package ru.croc.course;

import ru.croc.course.service.MeteorologicalDataService;
import ru.croc.course.service.ReportService;

public class MeteorologicalModuleTest {



    private MeteorologicalDataService meteorologicalDataService;
    private ReportService reportService;
//
//    @BeforeEach
//    public void prepare() throws URISyntaxException, IOException {
//
//        //Инициализация базы данных
//        DataSourceProvider dataSourceProvider = new H2DataSourceProvider();
//        DatabaseInitializer databaseInitializer = new DatabaseInitializer(dataSourceProvider);
//        databaseInitializer.init();
//
//        //Инициализация сервиса по обработке XML
//        XmlDataConverter xmlDataConverter = new JacksonXmlDataConverter();
//
//        //Инициализация сервиса по работе с метеорологическими данными
//        MeteorologicalDataRepository repository = new MeteorologicalDataRepository(dataSourceProvider);
//        this.meteorologicalDataService = new MeteorologicalDataService(repository);
//
//        //Инициализация сервис по работе с отчетами
//        ReportProvider reportProvider = new AirTemperatureToAtmosphericPressureReportProvider(xmlDataConverter, meteorologicalDataService);
//        ReportProvider testReportProvider = new TestReportProvider();
//        ReportProviderRegister reportProviderRegister = new ReportProviderRegister(List.of(reportProvider, testReportProvider));
//        ReportProviderDispatcher reportProviderDispatcher = new ReportProviderDispatcher(reportProviderRegister);
//        this.reportService = new ReportService(reportProviderDispatcher);
//    }
//
//    @Test
//    public void shouldReadMeteorologicalDataFromFDatabaseAndProvideXmlReport() throws IOException {
//        //Достаем данные из базы
//        LocalDateTime startDate = LocalDateTime.of(2023, 05, 15, 00, 00);
//        LocalDateTime endDate = LocalDateTime.of(2023, 05, 17, 13, 17);
//        List<MeteorologicalData> byMeasurementDateBetween = meteorologicalDataService.findByMeasurementDateBetween(startDate, endDate);
//        assertThat(byMeasurementDateBetween).hasSize(3);
//        assertThat(byMeasurementDateBetween.stream().map(MeteorologicalData::getId).collect(Collectors.toList())).contains(2, 3, 4);
//
//        //Генерируем отчет
//        Model model = new ModelMap();
//        model.addAttribute("startDate", startDate.toString());
//        model.addAttribute("endDate", endDate.toString());
//        String actualReport = reportService.getReport(ReportType.AIR_TEMPERATURE_TO_ATMOSPHERIC_PRESSURE, model);
//        String expectedReport = Files.readString(Path.of( "src", "test", "resources", "air-temperature-to-atmosphere-pressure-report-example.xml"));
//        assertThat(actualReport).isEqualTo(expectedReport);
//
//    }

}
