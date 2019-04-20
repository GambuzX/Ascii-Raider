package model.level;

import model.element.Element;
import model.element.Position;

public abstract class LevelBuilder {
    private Level result = new Level();

    protected Level getResult() {
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
    protected void createHorizontalLine(Element element, int size, Position initial) {
        Element provEl = element;
        provEl.setPosition(initial);
        for(int i = 0; i < size; i++) {
            provEl.getPosition().setX(initial.getX() + i);
            result.addElement(provEl);
        }
    }
    // TODO: por tudo numa so com
    protected void createVerticalLine(Element element, int size, Position initial){
        Element provEl = element;
        provEl.setPosition(initial);
        for(int i = 0; i < size; i++) {
            provEl.getPosition().setY(initial.getY() + i);
            result.addElement(provEl);
        }
    }

    protected void createRectangle(Element element, int sizeX, int sizeY, Position initial){
        Element provEl = element;
        provEl.setPosition(initial);
        for(int i = 0; i < sizeY; i++){
            provEl.getPosition().setY(initial.getY() + i);
            createHorizontalLine(provEl, sizeX, initial);
        }
    }
}
