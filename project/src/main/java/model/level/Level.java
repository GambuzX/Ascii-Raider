package model.level;

import model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class Level {

    private List<Element> elements = new ArrayList<Element>();

    public Level() {

    }

    public void addElement(Element e) {
        elements.add(e);
    }

    public void reset() {
        elements = new ArrayList<Element>();
    }
}
