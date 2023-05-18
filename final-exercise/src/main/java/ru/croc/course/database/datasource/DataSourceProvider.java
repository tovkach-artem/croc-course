package ru.croc.course.database.datasource;

import javax.sql.DataSource;

public interface DataSourceProvider {

    DataSource getDataSource();

}
