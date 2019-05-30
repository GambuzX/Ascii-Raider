package com.asciiraider.g710.view.swing.menu;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SwingMenuResources {

    private BufferedImage menuImg;
    private BufferedImage playButton;
    private BufferedImage playButtonHovered;
    private BufferedImage exitButton;
    private BufferedImage exitButtonHovered;


    public SwingMenuResources() {
        try {
            preLoadResources();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void preLoadResources() throws IOException {
        menuImg = ImageIO.read(SwingMenuResources.class.getResource("/symbols/menu.png"));
        playButton = ImageIO.read(SwingMenuResources.class.getResource("/symbols/play_btn.png"));
        playButtonHovered = ImageIO.read(SwingMenuResources.class.getResource("/symbols/play_btn_hovered.png"));
        exitButton = ImageIO.read(SwingMenuResources.class.getResource("/symbols/exit_btn.png"));
        exitButtonHovered = ImageIO.read(SwingMenuResources.class.getResource("/symbols/exit_btn_hovered.png"));
    }

    public BufferedImage getMenuImg() {
        return menuImg;
    }

    public BufferedImage getPlayButton() {
        return playButton;
    }

    public BufferedImage getPlayButtonHovered() {
        return playButtonHovered;
    }

    public BufferedImage getExitButton() {
        return exitButton;
    }

    public BufferedImage getExitButtonHovered() {
        return exitButtonHovered;
    }
}
