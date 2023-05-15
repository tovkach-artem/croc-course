package ru.croc.course.support.xml;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import java.io.IOException;

public class JacksonXmlDataConverter implements XmlDataConverter {

    private XmlMapper xmlMapper;

    @Override
    public <T> T fromXml(String xml, Class<T> type) throws IOException {
        return getXmlMapper().readValue(xml, type);
    }

    @Override
    public String toXml(Object object) throws IOException {
        return getXmlMapper().writeValueAsString(object);
    }

    private XmlMapper getXmlMapper() {
        if(xmlMapper == null) {
            xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JaxbAnnotationModule());
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
        return xmlMapper;
    }
}
