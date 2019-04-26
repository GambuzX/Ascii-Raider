package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.element.Player;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private List<Element> elements = new ArrayList<>();
    private Player player;

    public Level() {

    }

    public void addElement(Element e) {
        elements.add(e);
    }

    public void setPlayer(Player p) {
        player = p;
    }

    public void reset() {
        elements.clear();
        player = null;
    }

    public List<Element> getElements() {
        return elements;
    }

    public Player getPlayer() {
        return player;
    }
}
