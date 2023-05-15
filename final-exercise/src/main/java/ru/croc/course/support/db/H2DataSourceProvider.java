package ru.croc.course.support.db;

import org.h2.jdbcx.JdbcDataSource;
import ru.croc.course.support.property.PropertiesUtil;

import javax.sql.DataSource;
import java.util.Objects;

/**
 * Данный класс предоставляет реализацию интерфейса {@link DataSourceProvider}. Он создает и предоставляет экземпляр
 * {@link JdbcDataSource}, который используется для подключения к базе данных H2.
 */
public final class H2DataSourceProvider implements DataSourceProvider {

    /**
     * Ключ в настройках для значения пароля
     */
    private static final String PASSWORD_KEY = "db.password";
    /**
     * Ключ в настройках для значения пользователя
     */
    private static final String USERNAME_KEY = "db.username";
    /**
     * Ключ в настройках для значения url
     */
    private static final String URL_KEY = "db.url";

    private JdbcDataSource dataSource;

    @Override
    public DataSource getDataSource() {
        if(Objects.isNull(dataSource)) {
            dataSource = new JdbcDataSource();
            dataSource.setUrl(PropertiesUtil.get(URL_KEY));
            dataSource.setUser(PropertiesUtil.get(USERNAME_KEY));
            dataSource.setPassword(PropertiesUtil.get(PASSWORD_KEY));
        }
        return dataSource;
    }
}
