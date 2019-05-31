package com.asciiraider.g710.view.swing.gameover;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.view.swing.resources.SwingGameOverResources;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class SwingGameOverComponent extends JPanel {

    final static int WIDTH = GlobalConfigs.LEVEL_WIDTH * GlobalConfigs.SWING_SIZE_FACTOR;
    final static int HEIGHT = (GlobalConfigs.LEVEL_HEIGHT + GlobalConfigs.INFOBAR_HEIGHT) * GlobalConfigs.SWING_SIZE_FACTOR;

    private GameOverModel gameOverModel;
    private SwingGameOverResources gameOverResources;

    private JLabel scoreValue;

    public SwingGameOverComponent(SwingGameOverResources gameOverResources) {
        this.gameOverResources = gameOverResources;

        this.setLayout(new MigLayout("wrap 17, insets 0 0, gap 0 0, fill", "[][][][][][][][][][][][][][][][][][]","[][][][][][][][][][][][]"));

        Font labelsFont = new Font("Serif", Font.PLAIN, GlobalConfigs.SWING_FONT_SIZE*2);
        UIManager.put("Label.font", labelsFont);
        UIManager.put("Label.foreground", Color.YELLOW);

        scoreValue = new JLabel();
        scoreValue.setForeground(Color.WHITE);

        this.add(new JLabel("SCORE  "),  "span 1, cell 8 10, center");
        this.add(scoreValue, "span 1, cell 9 10, center");
    }

    public void setGameOverModel(GameOverModel gameOverModel) {
        this.gameOverModel = gameOverModel;

        this.scoreValue.setText(gameOverModel.getFinalScore().toString());
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawImage(gameOverResources.getGameOverBackground(), 0, 0, null);

    }
}
