package ru.croc.course.converter;

import java.io.IOException;

public interface XmlConverter {

    public <T> T fromXml(String xml, Class<T> type) throws IOException;

    public String toXml(Object object) throws IOException;

}
