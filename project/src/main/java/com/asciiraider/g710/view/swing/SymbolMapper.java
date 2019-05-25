package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.element.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SymbolMapper {

    private enum Elements {
        WALL(0, "/symbols/hardSand.png"),
        PLAYER(1, "/symbols/guy.png"),
        STONEBLOCK(2, "/symbols/granite.png"),
        LEVELKEY (3, "/symbols/orb.png"),
        EXITDOOR(4, "/symbols/portal.png"),
        SAND(5, "/symbols/softSand.png"),
        BOULDER(6, "/symbols/rock.png"),
        SKULLENEMY(7, "/symbols/fly.png"),
        MUMMYENEMY(8, "/symbols/mummy.png"),
        DOOR(9, "/symbols/door.png"),
        DOORKEY(10, "/symbols/key.png"),
        TNT(11, "/symbols/bomb.png"),
        EXPLOSION_BIG(12, "/symbols/explosion-big.png"),
        EXPLOSION_MEDIUM(13, "/symbols/explosion-medium.png"),
        EXPLOSION_SMALL(14, "/symbols/explosion-small.png"),
        BACKGROUND(15, "/symbols/background.png");

        public final int index;
        public final String resource;

        Elements(int index, String resource) {
            this.index = index;
            this.resource = resource;
        }
    }

    List<BufferedImage> elementsImages = new ArrayList<>();

    public SymbolMapper() {
        try {
            preLoadImages();
        } catch (IOException e) {
            e.printStackTrace();
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

    private void preLoadImages() throws IOException {
        for (Elements ele : Elements.values()) {
            elementsImages.add(ImageIO.read(SymbolMapper.class.getResource(ele.resource)));
        }
    }
}
