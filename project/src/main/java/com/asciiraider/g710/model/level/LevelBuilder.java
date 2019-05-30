package com.asciiraider.g710.model.level;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.controller.element.interaction.*;
import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.utilities.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LevelBuilder {

	// TODO: ver isto de protected vs package-private
	public List<LevelModel> buildAllLevels() {
		List<LevelModel> levelModels = new ArrayList<>();
		for (int i = 1; i <= GlobalConfigs.LEVEL_COUNT; i++) {
			LevelModel newLevel = buildLevel(i);
			if (newLevel != null)
				levelModels.add( newLevel );

		}
		return levelModels;
	}

	public LevelModel buildLevel(int levelNumber){
		List<String> levelLines = null;
		LevelModel levelModel = null;
		try {
			levelLines = readLevelFile(levelNumber);
			levelModel = buildLevelFromFile(levelLines);

		} catch (IOException | InvalidLevelException e) {
			e.printStackTrace();
		}
		return levelModel;
	}

	private LevelModel buildLevelFromFile(List<String> levelLines) throws InvalidLevelException {
		LevelModel newLevelModel = new LevelModel();

		// TODO make sure dimensions are okay
		newLevelModel.setTime(Integer.parseInt(levelLines.get(0)));

		int playerCount = 0, doorCount = 0, doorKeyCount = 0;
		for (int row = 1; row < levelLines.size(); row++) {
			for (int col = 0; col < levelLines.get(row).length(); col++) {

				char curr = levelLines.get(row).charAt(col);
				Position pos = new Position(col, row - 1);
				switch(curr) {
					case 'W':
						Wall wall = new Wall(pos);
						wall.setPlayerInteraction(new BarrierInteraction(wall));
						newLevelModel.addWall(wall);
						break;
					case 'S':
						StoneBlock stoneBlock = new StoneBlock(pos);
						stoneBlock.setPlayerInteraction(new BarrierInteraction(stoneBlock));
						newLevelModel.addStoneBlock(stoneBlock);
						break;
					case 'B':
						Boulder boulder = new Boulder(pos);
						boulder.setPlayerInteraction(new PushInteraction(boulder,newLevelModel));
						newLevelModel.addBoulder(boulder);
						break;
					case 'P':
						newLevelModel.setPlayer(new Player(pos));
						playerCount++;
						break;
					case 'E':
						SkullEnemy skullEnemy = new SkullEnemy(pos);
						skullEnemy.setPlayerInteraction(new DeathInteraction(skullEnemy));
						newLevelModel.addEnemy(skullEnemy);
						break;
					case 'M':
						MummyEnemy mummyEnemy = new MummyEnemy(pos);
						mummyEnemy.setPlayerInteraction(new DeathInteraction(mummyEnemy));
						newLevelModel.addEnemy(mummyEnemy);
						break;
					case 'T':
						TNT tnt = new TNT(pos);
						tnt.setPlayerInteraction(new PushInteraction(tnt, newLevelModel));
						newLevelModel.addTNT(tnt);
						break;
					case 's':
						Sand sand = new Sand(pos);
						sand.setPlayerInteraction(new SandInteraction(sand, newLevelModel));
						newLevelModel.addSandBlock(sand);
						break;
					case 'K':
						LevelKey levelKey = new LevelKey(pos);
						levelKey.setPlayerInteraction(new PushInteraction(levelKey, newLevelModel));
						newLevelModel.addLevelKey(levelKey);
						break;
					case 'D':
						ExitDoor exitDoor = new ExitDoor(pos);
						exitDoor.setPlayerInteraction(new BarrierInteraction(exitDoor));
						newLevelModel.setExitDoor(exitDoor);
						break;
					case 'd':
						Door door = new Door(pos);
						door.setPlayerInteraction(new BarrierInteraction(door));
						newLevelModel.setDoor(door);
						doorCount++;
						break;
					case 'k':
						DoorKey doorKey = new DoorKey(pos);
						doorKey.setPlayerInteraction(new DoorKeyInteraction(doorKey, newLevelModel));
						newLevelModel.setDoorKey(doorKey);
						doorKeyCount++;
						break;
				}
			}
		}

		if (playerCount != 1 || !((doorCount == 0 && doorKeyCount == 0) || (doorCount == 1 && doorKeyCount == 1))) {
			throw new InvalidLevelException();
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
