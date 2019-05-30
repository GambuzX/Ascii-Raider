package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.view.swing.utilities.SymbolMapper;

import javax.swing.*;
import java.awt.*;

public class SwingLevelComponent extends JPanel {

    private LevelModel levelModel;
    private SymbolMapper symbolMapper;

    public final static int WIDTH = GlobalConfigs.LEVEL_WIDTH * GlobalConfigs.SWING_SIZE_FACTOR;
    public final static int HEIGHT = GlobalConfigs.LEVEL_HEIGHT * GlobalConfigs.SWING_SIZE_FACTOR;

    public SwingLevelComponent() {
        symbolMapper = new SymbolMapper();
    }

    public void setLevelModel(LevelModel levelModel) {
        this.levelModel = levelModel;
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if (levelModel == null) return;

        for (int row = 0; row < GlobalConfigs.LEVEL_HEIGHT; row++) {
            for (int col = 0; col < GlobalConfigs.LEVEL_WIDTH; col++) {
                drawElement(graphics, levelModel.findElement(new Position(col,row)), col, row);
            }
        }

    }

    // TODO: se desse para fazer aqui refactoring e separar para SwingElementView como no Lanterna era fixe
    public void drawElement(Graphics graphics, Element ele, int x, int y) {
        graphics.drawImage(symbolMapper.getElementImage(ele), x * GlobalConfigs.SWING_SIZE_FACTOR, y * GlobalConfigs.SWING_SIZE_FACTOR, null);
    }
}
