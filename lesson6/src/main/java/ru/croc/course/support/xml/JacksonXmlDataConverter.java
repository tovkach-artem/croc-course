package ru.croc.course.support.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import java.io.IOException;
/**
 * Сериализация и десериализация в/из xml.
 */
public class JacksonXmlDataConverter implements XmlDataConverter {
    /** Маппер. */
    private XmlMapper xmlMapper;
    /**
     * Десериализация xml в объект.
     *
     * @param xml xml
     * @param type тип объекта
     * @return объект
     * @param <T> ожидаемый тип объекта
     */
    public <T> T fromXml(String xml, Class<T> type) throws IOException {
        return getXmlMapper().readValue(xml, type);
    }
    /**
     * Сериалиазция объекта в xml.
     *
     * @param obj объект
     * @return xml
     */
    public String toXml(Object object) throws JsonProcessingException {
        return getXmlMapper().writeValueAsString(object);
    }

    private XmlMapper getXmlMapper() {
        if(xmlMapper == null) {
            xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JaxbAnnotationModule());
//            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
        return xmlMapper;
    }
}
