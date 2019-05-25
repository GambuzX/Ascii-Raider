package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.infobar.InfoBarModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SwingInfoBarComponent extends JPanel {

    private final static int SIZE_FACTOR = 60;
    private final static int N_COLS = 18;

    private final static int WIDTH = N_COLS * SIZE_FACTOR;

    private InfoBarModel infoBarModel;

    private JTextField levelIndicator;
    private JProgressBar progressBar;
    private JButton restartButton;

    SwingInfoBarComponent() {
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
        return new Dimension(WIDTH, SIZE_FACTOR);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if (infoBarModel == null) return;

        this.levelIndicator.setText("Level " + infoBarModel.getCurrentLevel());
        this.progressBar.setValue((int) ((float) infoBarModel.getLives() / infoBarModel.getMaxLives() * 100));

    }

    protected static ImageIcon createImageIcon(String path) {
        URL imgURL = SwingInfoBarComponent.class.getResource(path);
        return new ImageIcon(imgURL);
    }
}
