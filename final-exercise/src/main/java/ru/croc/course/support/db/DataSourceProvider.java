package ru.croc.course.support.db;

import javax.sql.DataSource;

/**
 * Цель данного интерфейса предоставить классами способ получения объекта {@link DataSource}, который можно использовать
 * для установления соединения с источником данных, например базой данных.
 */
public interface DataSourceProvider {

    DataSource getDataSource();

}
