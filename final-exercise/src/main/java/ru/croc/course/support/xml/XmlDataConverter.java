package ru.croc.course.support.xml;

import java.io.IOException;

public interface XmlDataConverter {

    public <T> T fromXml(String xml, Class<T> type) throws IOException;

    public String toXml(Object object) throws IOException;

}
