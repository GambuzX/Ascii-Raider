package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.view.swing.resources.SwingInfoBarResources;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SwingInfoBarComponent extends JPanel {

    private InfoBarModel infoBarModel;

    public final static int WIDTH = GlobalConfigs.LEVEL_WIDTH * GlobalConfigs.SWING_SIZE_FACTOR;
    public final static int HEIGHT = GlobalConfigs.INFOBAR_HEIGHT * GlobalConfigs.SWING_SIZE_FACTOR;

    private JLabel levelLabel, levelValue;
    private JLabel scoreLabel, scoreValue;
    private JLabel keysLabel;
    private JProgressBar keysProgressBar;
    private JLabel timeLabel, timeValue;

    private SwingInfoBarResources infoBarResources;

    public SwingInfoBarComponent(SwingInfoBarResources infoBarResources) {

        this.infoBarResources = infoBarResources;

        this.setLayout(new MigLayout("wrap 17, insets 0 0, gap 0 0, fill", "[][][][][][][][][][][][][][][][][][]"));

        Font labelsFont = new Font("Serif", Font.PLAIN, GlobalConfigs.SWING_FONT_SIZE);

        levelLabel = new JLabel("LEVEL ");
        levelValue = new JLabel();
        scoreLabel = new JLabel("SCORE ");
        scoreValue = new JLabel();
        keysLabel = new JLabel("ENERGY ");
        keysProgressBar = new JProgressBar();
        timeLabel = new JLabel("TIME ");
        timeValue = new JLabel();

        levelLabel.setFont(labelsFont);
        levelValue.setFont(labelsFont);
        scoreLabel.setFont(labelsFont);
        scoreValue.setFont(labelsFont);
        keysLabel.setFont(labelsFont);
        keysProgressBar.setFont(labelsFont);
        timeLabel.setFont(labelsFont);
        timeValue.setFont(labelsFont);

        levelLabel.setForeground(Color.YELLOW);
        levelValue.setForeground(Color.WHITE);
        scoreLabel.setForeground(Color.YELLOW);
        scoreValue.setForeground(Color.WHITE);
        keysLabel.setForeground(Color.YELLOW);
        keysProgressBar.setForeground(new Color(49, 126, 249));
        timeLabel.setForeground(Color.YELLOW);
        timeValue.setForeground(Color.WHITE);

        keysProgressBar.setFocusable(false);
        keysProgressBar.setStringPainted(true);

        this.add(levelLabel, "span 1, cell 2 0, right");
        this.add(levelValue, "span 1, cell 3 0, left");

        this.add(scoreLabel,  "span 1, cell 4 0, right");
        this.add(scoreValue, "span 1, cell 5 0, left");

        this.add(keysLabel, "span 1, cell 6 0, right");
        this.add(keysProgressBar,  "span 1, cell 7 0, left, hmax " + HEIGHT);

        this.add(timeLabel, "span 1, cell 8 0, right");
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

        // TODO: refactoring do maxLifes
        levelValue.setText("" + infoBarModel.getCurrentLevel());
        scoreValue.setText("" + infoBarModel.getScore());
        timeValue.setText("" + infoBarModel.getTime());

        keysProgressBar.setMaximum(infoBarModel.getMaxKeys());
        keysProgressBar.setValue(infoBarModel.getKeys());
        keysProgressBar.setString(infoBarModel.getKeys() + " / " + infoBarModel.getMaxKeys());

        for (int i = 0 ; i < GlobalConfigs.PLAYER_HP; i++) {
            if (infoBarModel.getLives() > i)
                graphics.drawImage(infoBarResources.getPlayer(), (14 + i) * GlobalConfigs.SWING_SIZE_FACTOR, 0, null);
            else
                graphics.drawImage(infoBarResources.getPlayerDead(), (14 + i) * GlobalConfigs.SWING_SIZE_FACTOR, 0, null);
        }

        graphics.drawImage(infoBarResources.getPharaoh(), 0, 0, null);
        graphics.drawImage(infoBarResources.getRButton(), 17 * GlobalConfigs.SWING_SIZE_FACTOR, 0, null);

    }
}
