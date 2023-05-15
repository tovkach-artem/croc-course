package ru.croc.course.support;

import java.util.LinkedHashSet;
import java.util.Set;

public class ReferenceModelSet extends LinkedHashSet<String> implements ReferenceModel {
    @Override
    public ReferenceModel addAttribute(String attributeName) {
        add(attributeName);
        return this;
    }

    @Override
    public Set<String> asSet() {
        return this;
    }
}
