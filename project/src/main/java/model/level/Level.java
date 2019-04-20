package model.level;

import model.element.Element;
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
}
