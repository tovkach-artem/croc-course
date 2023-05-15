DROP TABLE IF EXISTS PUBLIC.METEOROLOGICAL_DATA;
CREATE TABLE PUBLIC.METEOROLOGICAL_DATA
(
    id                   int PRIMARY KEY,
    measurement_date datetime,
    air_temperature      double,
    atmospheric_pressure double
);