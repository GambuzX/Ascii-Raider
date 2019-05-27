package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.infobar.InfoBarModel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SwingInfoBarComponent extends JPanel {

    private InfoBarModel infoBarModel;

    private JProgressBar progressBar;

    public SwingInfoBarComponent() {
        //this.setLayout(new GridBagLayout());
        //this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        //this.setLayout(new GridLayout(1, 18));
        this.setLayout(new GridBagLayout());
        //this.setMinimumSize(new Dimension(GlobalConfigs.LEVEL_WIDTH * GlobalConfigs.SWING_SIZE_FACTOR, GlobalConfigs.INFOBAR_HEIGHT * GlobalConfigs.SWING_SIZE_FACTOR));

        this.setBounds(0, 0, 18* GlobalConfigs.SWING_SIZE_FACTOR, 1* GlobalConfigs.SWING_SIZE_FACTOR);

        progressBar = new JProgressBar();

        GridBagConstraints c = new GridBagConstraints();

        /*ImageIcon rButton = createImageIcon("/symbols/retry.png");
        restartButton = new JButton(rButton);
        restartButton.addActionListener(actionEvent -> System.out.println("Restart button clicked!"));*/

        c.gridx =5;
        c.gridy = 0;
        c.gridwidth = GlobalConfigs.SWING_SIZE_FACTOR;
        c.gridheight = GlobalConfigs.SWING_SIZE_FACTOR;
        //this.add(progressBar);
        c.gridx = 12;
        this.add(new JButton("test 1"), c);
        c.gridx = 14;
        this.add(new JButton("test 2"), c);
        c.gridx = 18;
        this.add(new JButton("test 3"), c);
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
        this.progressBar.setValue((int) ((float) infoBarModel.getLives() / GlobalConfigs.PLAYER_HP * 100));

    }

    protected static ImageIcon createImageIcon(String path) {
        URL imgURL = SwingInfoBarComponent.class.getResource(path);
        return new ImageIcon(imgURL);
    }
}
