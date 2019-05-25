package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.element.*;

public class SymbolMapper {

    public static String elementResource(Element element) {

        if (element instanceof Wall) return "/symbols/hardSand.png";
        if (element instanceof Player) return "/symbols/guy.png";
        if (element instanceof StoneBlock) return "/symbols/granite.png";
        if (element instanceof LevelKey) return "/symbols/orb.png";
        if (element instanceof ExitDoor) return "/symbols/portal.png";
        if (element instanceof Sand) return "/symbols/softSand.png";
        if (element instanceof Boulder) return "/symbols/rock.png";
        if (element instanceof SkullEnemy) return "/symbols/fly.png";
        if (element instanceof MummyEnemy) return "/symbols/mummy.png";
        if (element instanceof Door) return "/symbols/door.png";
        if (element instanceof DoorKey) return "/symbols/key.png";
        if (element instanceof TNT) return "/symbols/bomb.png";

        return "/symbols/background.png";
    }
}
