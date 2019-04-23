package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.element.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

// TODO: continuar a testar
public class LevelManager {

    private static LevelManager instance;
    private final static int lvlCount = 2;

    private List<Level> levels = new ArrayList<>();
    private int currentLevel;

    public static LevelManager getInstance() {
        if (instance == null) {
            instance = new LevelManager();
        }
        return instance;
    }

    public void resetLevel() {
        currentLevel = 0;
    }

    public Level nextLevel() {
        return levels.get((currentLevel++) % levels.size());
    }

    public int getCurrentLevel() {
        return currentLevel;
    }


    private LevelManager() {
        currentLevel = 0;
        buildAllLevels();
    }

    private void buildAllLevels() {
        for (int i = 1 ; i <= lvlCount; i++) {
            try {
                buildLevel(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void buildLevel(int levelNumber) throws IOException {
        List<String> levelLines = readLevelFile(levelNumber);
        levels.add(buildLevelFromFile(levelLines));
    }

    private Level buildLevelFromFile(List<String> levelLines) {
        Level newLevel = new Level();
        for (int row = 0; row < levelLines.size(); row++) {
            for (int col = 0; col < levelLines.get(0).length(); col++) {

                char curr = levelLines.get(row).charAt(col);
                Position pos = new Position(col, row);
                Element newEle = null;

                switch(curr) {
                    case 'W':
                        newEle = new Wall(pos);
                        break;
                    case 'S':
                        newEle = new StoneBlock(pos);
                        break;
                    case 'B':
                        newEle = new Boulder(pos);
                        break;
                    case 'P':
                        newEle = new Player(pos);
                        break;
                    case 'E':
                        newEle = new Enemy(pos);
                        break;
                    case 'T':
                        newEle = new TNT(pos);
                        break;
                    case 's':
                        newEle = new Sand(pos);
                        break;
                    case 'K':
                        newEle = new LevelKey(pos);
                        break;
                    case 'D':
                        newEle = new ExitDoor(pos);
                        break;
                }

                if (newEle != null) newLevel.addElement(newEle);
            }
        }
        return newLevel;
    }

    private List<String> readLevelFile(int levelNumber) throws IOException {
        URL resource = LevelManager.class.getResource("/levels/" + levelNumber + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);

        return lines;
    }
}
