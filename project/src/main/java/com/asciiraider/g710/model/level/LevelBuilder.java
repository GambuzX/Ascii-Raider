package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.element.Position;

public abstract class LevelBuilder {
    private Level result = new Level();

    public Level getResult() {
        return result;
    }

    protected void reset(){
        result.reset();
    }

    abstract void createWalls();
    abstract void createSand();
    abstract void createStoneBlocks();
    abstract void createStoneBoulders();
    abstract void createExitDoor();
    abstract void createLevelKeys();
    abstract void createTNT();
    abstract void createEnemies();
    abstract void createPlayer();

    // TODO: verificar que nao esta a mudar o element original
    // TODO: por a verificar parameteros? e position controlar com tamanho de ecra?
    protected void createHorizontalLine(Element element, int size, Position initial) throws CloneNotSupportedException {
        if(element == null)
            throw new IllegalArgumentException("Element can't be null");
        for(int i = 0; i < size; i++) {
            Element provEl = (Element) element.clone();
            provEl.setPosition(new Position(initial));
            provEl.getPosition().setX(initial.getX() + i);
            result.addElement(provEl);
        }
    }
    // TODO: por tudo numa so com
    protected void createVerticalLine(Element element, int size, Position initial) throws CloneNotSupportedException {
        if(element == null)
            throw new IllegalArgumentException("Element can't be null");
        for(int i = 0; i < size; i++) {
            Element provEl = (Element) element.clone();
            provEl.setPosition(new Position(initial));
            provEl.getPosition().setY(initial.getY() + i);
            result.addElement(provEl);
        }
    }

    protected void createRectangle(Element element, int sizeX, int sizeY, Position initial) throws CloneNotSupportedException {
        if(element == null)
            throw new IllegalArgumentException("Element can't be null");
        for(int i = 0; i < sizeY; i++){
            Element provEl = (Element) element.clone();
            provEl.setPosition(new Position(initial));
            provEl.getPosition().setY(initial.getY() + i);
            createHorizontalLine(provEl, sizeX, provEl.getPosition());
        }
    }
}
