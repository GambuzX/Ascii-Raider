package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.infobar.InfoBarModel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SwingInfoBarComponent extends JPanel {

    private InfoBarModel infoBarModel;

    private JTextField levelIndicator;
    private JProgressBar progressBar;
    private JButton restartButton;

    public SwingInfoBarComponent() {
        levelIndicator = new JTextField(5);

        progressBar = new JProgressBar();

        ImageIcon rButton = createImageIcon("/symbols/retry.png");
        restartButton = new JButton(rButton);
        restartButton.addActionListener(actionEvent -> System.out.println("Restart button clicked!"));

        this.add(levelIndicator);
        this.add(progressBar);
        this.add(restartButton);
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

        this.levelIndicator.setText("Level " + infoBarModel.getCurrentLevel());
        // TODO: refactoring do maxLifes
        this.progressBar.setValue((int) ((float) infoBarModel.getLives() / GlobalConfigs.PLAYER_HP * 100));

    }

    protected static ImageIcon createImageIcon(String path) {
        URL imgURL = SwingInfoBarComponent.class.getResource(path);
        return new ImageIcon(imgURL);
    }
}
