package com.asciiraider.g710.view.swing.resources;

import com.asciiraider.g710.model.element.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SwingLevelResources implements SwingResource{

    private enum Elements {
        WALL(0, "/swing/elements/hardSand.png"),
        PLAYER(1, "/swing/elements/guy.png"),
        STONEBLOCK(2, "/swing/elements/granite.png"),
        LEVELKEY (3, "/swing/elements/orb.png"),
        EXITDOOR(4, "/swing/elements/portal.png"),
        SAND(5, "/swing/elements/softSand.png"),
        BOULDER(6, "/swing/elements/rock.png"),
        SKULLENEMY(7, "/swing/elements/fly.png"),
        MUMMYENEMY(8, "/swing/elements/mummy.png"),
        DOOR(9, "/swing/elements/door.png"),
        DOORKEY(10, "/swing/elements/key.png"),
        TNT(11, "/swing/elements/bomb.png"),
        EXPLOSION_BIG(12, "/swing/elements/explosion-big.png"),
        EXPLOSION_MEDIUM(13, "/swing/elements/explosion-medium.png"),
        EXPLOSION_SMALL(14, "/swing/elements/explosion-small.png"),
        BACKGROUND(15, "/swing/elements/background.png");

        public final int index;
        public final String resource;

        Elements(int index, String resource) {
            this.index = index;
            this.resource = resource;
        }
    }

    List<BufferedImage> elementsImages = new ArrayList<>();

    public void loadResources() {
        elementsImages.clear();
        for (Elements ele : Elements.values()) {
            try {
                elementsImages.add(ImageIO.read(SwingLevelResources.class.getResource(ele.resource)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public BufferedImage getElementImage(Element element) {
        if (element instanceof Wall) return elementsImages.get(Elements.WALL.index);
        if (element instanceof Player) return elementsImages.get(Elements.PLAYER.index);
        if (element instanceof StoneBlock) return elementsImages.get(Elements.STONEBLOCK.index);
        if (element instanceof LevelKey) return elementsImages.get(Elements.LEVELKEY.index);
        if (element instanceof ExitDoor) return elementsImages.get(Elements.EXITDOOR.index);
        if (element instanceof Sand) return elementsImages.get(Elements.SAND.index);
        if (element instanceof Boulder) return elementsImages.get(Elements.BOULDER.index);
        if (element instanceof SkullEnemy) return elementsImages.get(Elements.SKULLENEMY.index);
        if (element instanceof MummyEnemy) return elementsImages.get(Elements.MUMMYENEMY.index);
        if (element instanceof Door) return elementsImages.get(Elements.DOOR.index);
        if (element instanceof DoorKey) return elementsImages.get(Elements.DOORKEY.index);
        if (element instanceof TNT) return elementsImages.get(Elements.TNT.index);
        if (element instanceof Explosion) {
            Explosion explosion = (Explosion) element;
            if (explosion.getSymbol().getAscii() == '●') return elementsImages.get(Elements.EXPLOSION_BIG.index);
            if (explosion.getSymbol().getAscii() == '⦁') return elementsImages.get(Elements.EXPLOSION_MEDIUM.index);
            if (explosion.getSymbol().getAscii() == '٠') return elementsImages.get(Elements.EXPLOSION_SMALL.index);
        }
        return elementsImages.get(Elements.BACKGROUND.index);
    }
}
