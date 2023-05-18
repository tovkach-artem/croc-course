package ru.croc.course.model.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDateTime;

/**
 * Данный класс представляет собой объектную модель отчета "СООТНОШЕНИЕ ТЕМПЕРАТУРЫ ВОЗДУХА К АТМОСФЕРНОМУ ДАВЛЕНИЮ"
 */
public class AirTemperatureToAtmosphericPressureReport extends Report {

    /**
     * Тип отчета
     */
    private static final String SERVICED_REPORT_TYPE = "air-temperature-to-atmosphere-pressure";
    /**
     * Сведения о метеорологическом срезе данных
     */
    @XmlElement
    private MeteorologicalDataSlice meteorologicalDataSlice = new MeteorologicalDataSlice();

    public AirTemperatureToAtmosphericPressureReport(LocalDateTime startDate, LocalDateTime endDate) {
        super(SERVICED_REPORT_TYPE);
        this.meteorologicalDataSlice.setStartDate(startDate.toString());
        this.meteorologicalDataSlice.setEndDate(endDate.toString());
    }


    public MeteorologicalDataSlice getMeteorologicalDataSlice() {
        return meteorologicalDataSlice;
    }

    public void setMeteorologicalDataSlice(MeteorologicalDataSlice meteorologicalDataSlice) {
        this.meteorologicalDataSlice = meteorologicalDataSlice;
    }

    /**
     * Данный класс представляет собой объектную модель среза метеорологических данных
     */
    public class MeteorologicalDataSlice {
        /**
         * Начальная дата среза метеорологических данных
         */
        @XmlAttribute
        private String startDate;
        /**
         * Финальная дата среза метеорологических данных
         */
        @XmlAttribute
        private String endDate;
        /**
         * Сведения о температуре воздуха
         */
        @XmlElement
        private AirTemperature airTemperature = new AirTemperature();
        /**
         * Сведения об атмосферном давлении
         */
        @XmlElement
        private AtmosphericPressure atmosphericPressure = new AtmosphericPressure();

        /**
         * Сведения о соотношении температуры воздуха к атмосферному давлению
         */
        @XmlElement
        private AitTemperatureToAtmospherePressure aitTemperatureToAtmospherePressure = new AitTemperatureToAtmospherePressure();



        public MeteorologicalDataSlice() {}

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public AirTemperature getAirTemperature() {
            return airTemperature;
        }

        public void setAirTemperature(AirTemperature airTemperature) {
            this.airTemperature = airTemperature;
        }

        public AtmosphericPressure getAtmosphericPressure() {
            return atmosphericPressure;
        }

        public void setAtmosphericPressure(AtmosphericPressure atmosphericPressure) {
            this.atmosphericPressure = atmosphericPressure;
        }

        public AitTemperatureToAtmospherePressure getAitTemperatureToAtmospherePressure() {
            return aitTemperatureToAtmospherePressure;
        }

        public void setAitTemperatureToAtmospherePressure(AitTemperatureToAtmospherePressure aitTemperatureToAtmospherePressure) {
            this.aitTemperatureToAtmospherePressure = aitTemperatureToAtmospherePressure;
        }

        /**
         * Данный класс является базовым для все классов, которые отражают статистику по какой-либо величине в разрезе
         * минимальных и максимальных значений
         */
        abstract class BaseMinMaxWrapper {
            @XmlAttribute
            private Double max;
            @XmlAttribute
            private Double min;

            public Double getMax() {
                return max;
            }

            public void setMax(double max) {
                this.max = max;
            }

            public Double getMin() {
                return min;
            }

            public void setMin(double min) {
                this.min = min;
            }
        }

        /**
         * Данный класс представляет собой обертку над данными о температуре воздуха
         */
        public class AirTemperature extends BaseMinMaxWrapper {}
        /**
         * Данный класс представляет собой обертку над данными об атмосферном давлении
         */
        public class AtmosphericPressure extends BaseMinMaxWrapper {}
        /**
         * Данный класс представляет собой обертку над данными об соотношении температуры воздуха к атмосферному давлению
         */
        public class AitTemperatureToAtmospherePressure extends BaseMinMaxWrapper {}
    }


}
