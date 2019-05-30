package com.asciiraider.g710.view.swing.resources;

import com.asciiraider.g710.view.swing.game.SwingInfoBarComponent;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SwingInfoBarResources {

    private BufferedImage background;
    private BufferedImage player;
    private BufferedImage playerDead;
    private BufferedImage rButton;
    private BufferedImage pharaoh;


    public void loadResources()  {
        try {
            background = ImageIO.read(SwingInfoBarComponent.class.getResource("/symbols/infobar_background.png"));
            player = ImageIO.read(SwingInfoBarComponent.class.getResource("/symbols/guy_infobar.png"));
            playerDead = ImageIO.read(SwingInfoBarComponent.class.getResource("/symbols/guy_infobar_dark.png"));
            rButton = ImageIO.read(SwingInfoBarComponent.class.getResource("/symbols/r_button.png"));
            pharaoh = ImageIO.read(SwingInfoBarComponent.class.getResource("/symbols/pharaoh.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBackground() {
        return background;
    }

    public BufferedImage getPlayer() {
        return player;
    }

    public BufferedImage getPlayerDead() {
        return playerDead;
    }

    public BufferedImage getRButton() {
        return rButton;
    }

    public BufferedImage getPharaoh() {
        return pharaoh;
    }
}
