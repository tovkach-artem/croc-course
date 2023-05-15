package ru.croc.course.support;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModelMap extends LinkedHashMap<String, String> implements Model {

    public ModelMap() {
    }

    public ModelMap(String attributeName, String attributeValue) {
        addAttribute(attributeName, attributeValue);
    }

    @Override
    public Model addAttribute(String attributeName, String attributeValue) {
        put(attributeName, attributeValue);
        return this;
    }

    @Override
    public boolean containsAttribute(String attributeName) {
        return containsKey(attributeName);
    }

    @Override
    public String getAttribute(String attributeName) {
        return get(attributeName);
    }

    @Override
    public Map<String, String> asMap() {
        return this;
    }

}
