package com.asciiraider.g710.view.swing.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SwingGameOverResources implements SwingResource {

    private BufferedImage gameOverBackground;

    @Override
    public void loadResources() {

        try {
            gameOverBackground = ImageIO.read(SwingMenuResources.class.getResource("/swing/gameover/gameOver.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getGameOverBackground() {
        return gameOverBackground;
    }
}
