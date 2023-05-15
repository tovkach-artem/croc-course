package ru.croc.course.support.sql;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Данный класс является генератором SQL-запросов для работы с объектами аннотированными аннотациями {@link Table} и
 * {@link Column}. Необходимо отметить, что при использовании данного класса получение значений полей стоит осуществлять
 * с помощью названий, а не с помощью индексов.
 */
public class SqlQueryGenerator {

    /**
     * Генерирует SQl-запрос INSERT для добавления объекта в базу данных. Получает объект типа 'T' в качестве параметра,
     * аннотацию {@link Table} с помощью рефлексии извлекает из класса, аннотированного типом 'T'. Далее извлекает
     * переменные, аннотированные {@link Column}, и используя методы {@link SqlQueryGenerator#getFieldNames(Field[])}
     * и {@link SqlQueryGenerator#getFieldValues(Object, Field[])}  формирует строку запроса INSERT INTO с именами
     * столбцов и значениями.
     */
    public static <T> String generateInsert(T type) {
        String template = "INSERT INTO %s.%s (%s) VALUES (%s);";
        Table table = type.getClass().getAnnotation(Table.class);
        Field[] fields = type.getClass().getDeclaredFields();
        return String.format(template, table.schema(), table.name(), getFieldNames(fields), getFieldValues(type, fields));
    }

    /**
     *  Генерирует SQL-запрос SELECT для извлечения всех записей из таблицы. Получает класс типа 'T' в качестве
     *  параметра, аннотацию {@link Table} с помощью рефлексии извлекает из класса, аннотированного типом 'T'.
     *  Далее извлекает переменные, аннотированные {@link Column}, и используя метод
     *  {@link SqlQueryGenerator#getFieldNames(Field[])} формирует строку запроса SELECT с именами столбцов.
     */
    public static <T> String generateSelectAll(Class<T> clazz) {
        String template = "SELECT %s FROM %s.%s;";
        Table table = clazz.getAnnotation(Table.class);
        Field[] fields = clazz.getDeclaredFields();
        return String.format(template, getFieldNames(fields), table.schema(), table.name());
    }

    /**
     * Извлекает поля, аннотированные {@link Column}, и с помощью Stream API формирует строку с их именами,
     * отсортированными по алфавиту.
     */
    private static String getFieldNames(Field[] fields) {
        return Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .sorted(Comparator.comparing(Field::getName))
                .map(field -> field.getAnnotation(Column.class))
                .map(Column::name)
                .collect(Collectors.joining(", "));
    }

    private static <T> String getFieldValues(T type, Field[] fields) {
        return Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .sorted(Comparator.comparing(Field::getName))
                .map(field -> getMethodName(type, field))
                .map(method -> {
                    try {
                        return method.invoke(type);
                    } catch (IllegalAccessException | InvocationTargetException exception) {
                        throw new RuntimeException(exception);
                    }
                })
                .map(value -> "'" + value + "'")
                .collect(Collectors.joining(", "));
    }

    /**
     *  Возвращает соответствующий getter-метод для переменной, используя имя поля и метод {@link Class#getMethod(String, Class[])}.
     */
    private static <T> Method getMethodName(T type, Field field) {
        String name = field.getName();
        try {
            return type.getClass().getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
