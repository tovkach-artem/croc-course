package ru.croc.course.database.datasource;

import org.h2.jdbcx.JdbcDataSource;
import ru.croc.course.property.PropertyContainer;

import javax.sql.DataSource;
import java.util.Objects;

public class H2DataSourceProvider implements DataSourceProvider{

    private static final String PASSWORD_KEY = "db.password";
    private static final String USERNAME_KEY = "db.username";
    private static final String URL_KEY = "db.url";

    private DataSource dataSource;

    @Override
    public DataSource getDataSource() {
        if(Objects.isNull(dataSource)) {
            JdbcDataSource jdbcDataSource = new JdbcDataSource();
            jdbcDataSource.setUrl(PropertyContainer.getProperty(URL_KEY));
            jdbcDataSource.setUser(PropertyContainer.getProperty(USERNAME_KEY));
            jdbcDataSource.setPassword(PropertyContainer.getProperty(PASSWORD_KEY));
            dataSource = jdbcDataSource;
        }
        return dataSource;
    }

}
