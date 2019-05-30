package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.view.swing.resources.SwingInfoBarResources;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SwingInfoBarComponent extends JPanel {

    private InfoBarModel infoBarModel;

    public final static int WIDTH = GlobalConfigs.LEVEL_WIDTH * GlobalConfigs.SWING_SIZE_FACTOR;
    public final static int HEIGHT = GlobalConfigs.INFOBAR_HEIGHT * GlobalConfigs.SWING_SIZE_FACTOR;

    private JLabel levelValue;
    private JLabel scoreValue;
    private JLabel timeValue;
    private JProgressBar keysProgressBar;

    private SwingInfoBarResources infoBarResources;

    public SwingInfoBarComponent(SwingInfoBarResources infoBarResources) {

        this.infoBarResources = infoBarResources;

        this.setLayout(new MigLayout("wrap 17, insets 0 0, gap 0 0, fill", "[][][][][][][][][][][][][][][][][][]"));

        Font labelsFont = new Font("Serif", Font.PLAIN, GlobalConfigs.SWING_FONT_SIZE);
        UIManager.put("Label.font", labelsFont);
        UIManager.put("ProgressBar.font", labelsFont);
        UIManager.put("Label.foreground", Color.YELLOW);
        UIManager.put("ProgressBar.foreground", new Color(49, 126, 249));

        levelValue = new JLabel();
        scoreValue = new JLabel();
        timeValue = new JLabel();

        levelValue.setForeground(Color.WHITE);
        scoreValue.setForeground(Color.WHITE);
        timeValue.setForeground(Color.WHITE);

        keysProgressBar = new JProgressBar();
        keysProgressBar.setFocusable(false);
        keysProgressBar.setStringPainted(true);

        this.add(new JLabel("LEVEL"), "span 1, cell 2 0, right");
        this.add(levelValue, "span 1, cell 3 0, left");

        this.add(new JLabel("SCORE "),  "span 1, cell 4 0, right");
        this.add(scoreValue, "span 1, cell 5 0, left");

        this.add(new JLabel("ENERGY "), "span 1, cell 6 0, right");
        this.add(keysProgressBar,  "span 1, cell 7 0, left, hmax " + HEIGHT);

        this.add(new JLabel("TIME "), "span 1, cell 8 0, right");
        this.add(timeValue, "span 1, cell 9 0, left");
    }

    public void setInfoBarModel(InfoBarModel infoBarModel) {
        this.infoBarModel = infoBarModel;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawImage(infoBarResources.getBackground(), 0, 0, null);

        if (infoBarModel == null) return;

        levelValue.setText("" + infoBarModel.getCurrentLevel());
        scoreValue.setText("" + infoBarModel.getScore());
        timeValue.setText("" + infoBarModel.getTime());

        keysProgressBar.setMaximum(infoBarModel.getMaxKeys());
        keysProgressBar.setValue(infoBarModel.getKeys());
        keysProgressBar.setString(infoBarModel.getKeys() + " / " + infoBarModel.getMaxKeys());

        for (int i = 0 ; i < GlobalConfigs.PLAYER_HP; i++) {
            BufferedImage toDraw = infoBarModel.getLives() > i ? infoBarResources.getPlayer() : infoBarResources.getPlayerDead();
            graphics.drawImage(toDraw, (14 + i) * GlobalConfigs.SWING_SIZE_FACTOR, 0, null);
        }

        graphics.drawImage(infoBarResources.getPharaoh(), 0, 0, null);
        graphics.drawImage(infoBarResources.getRButton(), 17 * GlobalConfigs.SWING_SIZE_FACTOR, 0, null);

    }
}
