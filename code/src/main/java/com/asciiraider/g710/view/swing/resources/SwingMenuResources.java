package com.asciiraider.g710.view.swing.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SwingMenuResources  implements SwingResource{

    private BufferedImage menuBackground;
    private BufferedImage playButton;
    private BufferedImage playButtonHovered;
    private BufferedImage exitButton;
    private BufferedImage exitButtonHovered;

    public void loadResources()  {
        try {
            menuBackground = ImageIO.read(SwingMenuResources.class.getResource("/swing/menu/menu.png"));
            playButton = ImageIO.read(SwingMenuResources.class.getResource("/swing/menu/play_btn.png"));
            playButtonHovered = ImageIO.read(SwingMenuResources.class.getResource("/swing/menu/play_btn_hovered.png"));
            exitButton = ImageIO.read(SwingMenuResources.class.getResource("/swing/menu/exit_btn.png"));
            exitButtonHovered = ImageIO.read(SwingMenuResources.class.getResource("/swing/menu/exit_btn_hovered.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getMenuBackground() {
        return menuBackground;
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
