package com.asciiraider.g710;

import com.asciiraider.g710.model.level.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World");

        LevelDirector levelDirector = new LevelDirector();
        LevelBuilder levelOne = new LevelOneBuilder();
        LevelBuilder levelTwo = new LevelTwoBuilder();

        levelDirector.buildLevel(levelOne);
        levelDirector.buildLevel(levelTwo);

        Level level1 = levelOne.getResult();
        Level level2 = levelTwo.getResult();

    }
}
