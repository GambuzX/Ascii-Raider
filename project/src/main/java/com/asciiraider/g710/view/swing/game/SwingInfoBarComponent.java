package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.infobar.InfoBarModel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SwingInfoBarComponent extends JPanel {

    private InfoBarModel infoBarModel;

    private JLabel levelLabel;
    private JLabel scoreLabel;
    private JProgressBar keysProgressBar;
    private JLabel timeLabel;
    private JLabel livesLabel;
    private JLabel rLabel;

    public SwingInfoBarComponent() {
        this.setLayout(new GridLayout(1, 18));
        this.setBackground(Color.GRAY);

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

        this.add(levelLabel);
        this.add(scoreLabel);
        this.add(keysProgressBar);
        this.add(timeLabel);
        this.add(livesLabel);
        this.add(rLabel);
    }

    public void setInfoBarModel(InfoBarModel infoBarModel) {
        this.infoBarModel = infoBarModel;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(GlobalConfigs.LEVEL_WIDTH * GlobalConfigs.SWING_SIZE_FACTOR, GlobalConfigs.INFOBAR_HEIGHT * GlobalConfigs.SWING_SIZE_FACTOR);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

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
