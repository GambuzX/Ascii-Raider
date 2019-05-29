package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.view.swing.menu.SwingMenuResources;
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

    private JLabel levelLabel;
    private JLabel scoreLabel;
    private JProgressBar keysProgressBar;
    private JLabel timeLabel;
    private JLabel livesLabel;
    private JLabel rLabel;

    BufferedImage background;

    public SwingInfoBarComponent() {

        this.setLayout(new MigLayout("wrap 18, insets 0 0, gap 0 0, fill, align 0% 0%", "[][][][][][][][][][][][][][][][][][]"));

        Font labelsFont = new Font("Serif", Font.PLAIN, GlobalConfigs.FONT_SIZE);

        levelLabel = new JLabel();
        scoreLabel = new JLabel();
        keysProgressBar = new JProgressBar();
        timeLabel = new JLabel();
        livesLabel = new JLabel();
        rLabel = new JLabel();

        levelLabel.setFont(labelsFont);
        scoreLabel.setFont(labelsFont);
        keysProgressBar.setFont(labelsFont);
        timeLabel.setFont(labelsFont);
        livesLabel.setFont(labelsFont);
        rLabel.setFont(labelsFont);

        levelLabel.setForeground(Color.BLACK);
        scoreLabel.setForeground(Color.BLACK);
        keysProgressBar.setForeground(Color.BLUE);
        livesLabel.setForeground(Color.RED);
        timeLabel.setForeground(Color.BLACK);
        rLabel.setForeground(Color.BLACK);

        levelLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        livesLabel.setHorizontalAlignment(JLabel.CENTER);
        rLabel.setHorizontalAlignment(JLabel.CENTER);

        keysProgressBar.setFocusable(false);
        keysProgressBar.setStringPainted(true);

        this.add(levelLabel, "span 1, cell 1 0");

        this.add(scoreLabel,  "span 1, cell 3 0");

        this.add(keysProgressBar,  "span 2, cell 6 0, hmax " + HEIGHT);

        this.add(timeLabel, "span 3, cell 10 0");

        this.add(livesLabel, "span 3, cell 14 0");

        this.add(rLabel, "span 1, cell 17 0");

        try {
            background = ImageIO.read(SwingInfoBarComponent.class.getResource("/symbols/infobar_background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setInfoBarModel(InfoBarModel infoBarModel) {
        this.infoBarModel = infoBarModel;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawImage(background, 0, 0, null);

        if (infoBarModel == null) return;

        // TODO: refactoring do maxLifes
        levelLabel.setText("Level " + infoBarModel.getCurrentLevel());
        scoreLabel.setText("" + infoBarModel.getScore());
        timeLabel.setText("" + infoBarModel.getTime());
        rLabel.setText("R");

        livesLabel.setText("");
        for (int i = 0 ; i < infoBarModel.getLives(); i++)
            livesLabel.setText(livesLabel.getText() + "♥");

        keysProgressBar.setMaximum(infoBarModel.getMaxKeys());
        keysProgressBar.setValue(infoBarModel.getKeys());
        keysProgressBar.setString(infoBarModel.getKeys() + " / " + infoBarModel.getMaxKeys());
    }

    protected static ImageIcon createImageIcon(String path) {
        URL imgURL = SwingInfoBarComponent.class.getResource(path);
        return new ImageIcon(imgURL);
    }
}
