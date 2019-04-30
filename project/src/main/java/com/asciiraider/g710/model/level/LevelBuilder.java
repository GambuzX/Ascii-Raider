package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.utilities.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LevelBuilder {
	private static final int lvlCount = 2;

	// TODO: ver isto de protected vs package-private
	List<LevelModel> buildAllLevels() {
		List<LevelModel> levelModels = new ArrayList<>();
		for (int i = 1 ; i <= lvlCount; i++) {
			try {
				levelModels.add( buildLevel(i) );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return levelModels;
	}

	private LevelModel buildLevel(int levelNumber) throws IOException {
		List<String> levelLines = readLevelFile(levelNumber);
		return buildLevelFromFile(levelLines);
	}

	private LevelModel buildLevelFromFile(List<String> levelLines) {
		LevelModel newLevelModel = new LevelModel();
		for (int row = 0; row < levelLines.size(); row++) {
			for (int col = 0; col < levelLines.get(0).length(); col++) {

				char curr = levelLines.get(row).charAt(col);
				Position pos = new Position(col, row);

				switch(curr) {
					case 'W':
						Wall wall = new Wall(pos);
						newLevelModel.addWall(wall);
						newLevelModel.addElement(wall);
						break;
					case 'S':
						StoneBlock stoneBlock = new StoneBlock(pos);
						newLevelModel.addStoneBlock(stoneBlock);
						newLevelModel.addElement(stoneBlock);
						break;
					case 'B':
						Boulder boulder = new Boulder(pos);
						newLevelModel.addBoulder(boulder);
						newLevelModel.addElement(boulder);
						break;
					case 'P':
						Player player = new Player(pos);
						newLevelModel.setPlayer(player);
						newLevelModel.addElement(player);
						break;
					case 'E':
						Enemy enemy = new Enemy(pos);
						newLevelModel.addEnemy(enemy);
						newLevelModel.addElement(enemy);
						break;
					case 'T':
						TNT tnt = new TNT(pos);
						newLevelModel.addTNT(tnt);
						newLevelModel.addElement(tnt);
						break;
					case 's':
						Sand sand =  new Sand(pos);
						newLevelModel.addSandBlock(sand);
						newLevelModel.addElement(sand);
						break;
					case 'K':
						LevelKey key = new LevelKey(pos);
						newLevelModel.addKey(key);
						newLevelModel.addElement(key);
						break;
					case 'D':
						ExitDoor exitDoor = new ExitDoor(pos);
						newLevelModel.setExitDoor(exitDoor);
						newLevelModel.addElement(exitDoor);
						break;
				}
			}
		}
		return newLevelModel;
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
