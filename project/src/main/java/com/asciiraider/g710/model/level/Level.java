package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class Level {

    private List<Element> elements = new ArrayList<>();

    public Level() {

    }

    public void addElement(Element e) {
        elements.add(e);
    }

    public void reset() {
        elements.clear();
    }

    public List<Element> getElements() {
        return elements;
    }
}
