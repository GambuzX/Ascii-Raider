package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.model.element.AnimatedElement;

public class AnimationController {

    private LevelController levelController;

    public AnimationController(LevelController levelController) {
        this.levelController = levelController;
    }

    public void handleAnimations(int fps){
        LevelFacade levelFacade = levelController.getLevelManager().getCurrentLevelFacade();
        for(AnimatedElement animated : levelFacade.getAnimatedElements())
            if(!animated.updateAnimation(fps))
                levelFacade.removeAnimation(animated.getPosition());
    }
}
