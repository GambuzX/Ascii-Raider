package com.asciiraider.g710.model.level;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.controller.element.interaction.*;
import com.asciiraider.g710.controller.level.LevelFacade;
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
			LevelModel newLevel = new LevelModel();
			try {
				buildLevel(newLevel, i);
				levelModels.add( newLevel );
			} catch (InvalidLevelException e) {
				System.out.println("Error building level " + i);
			}
		}
		return levelModels;
	}

	public void buildLevel(LevelModel levelModel, int levelNumber) throws InvalidLevelException {
		List<String> levelLines = null;
		try {
			levelLines = readLevelFile(levelNumber);
			buildLevelFromFile(levelModel, levelLines);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void buildLevelFromFile(LevelModel newLevelModel, List<String> levelLines) throws InvalidLevelException {

		newLevelModel.setTime(Integer.parseInt(levelLines.get(0)));

		if (levelLines.size() != GlobalConfigs.LEVEL_HEIGHT + 1) throw new InvalidLevelException();

		int playerCount = 0, doorCount = 0, doorKeyCount = 0, exitDoorCount = 0;
		for (int row = 1; row < levelLines.size(); row++) {

			if (levelLines.get(row).length() != GlobalConfigs.LEVEL_WIDTH) throw new InvalidLevelException();
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
						boulder.setPlayerInteraction(new PushInteraction(boulder, new LevelFacade(newLevelModel)));
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
						tnt.setPlayerInteraction(new PushInteraction(tnt, new LevelFacade(newLevelModel)));
						newLevelModel.addTNT(tnt);
						break;
					case 's':
						Sand sand = new Sand(pos);
						sand.setPlayerInteraction(new SandInteraction(sand, new LevelFacade(newLevelModel)));
						newLevelModel.addSandBlock(sand);
						break;
					case 'K':
						LevelKey levelKey = new LevelKey(pos);
						levelKey.setPlayerInteraction(new PushInteraction(levelKey, new LevelFacade(newLevelModel)));
						newLevelModel.addLevelKey(levelKey);
						break;
					case 'D':
						ExitDoor exitDoor = new ExitDoor(pos);
						exitDoor.setPlayerInteraction(new BarrierInteraction(exitDoor));
						newLevelModel.setExitDoor(exitDoor);
						exitDoorCount++;
						break;
					case 'd':
						Door door = new Door(pos);
						door.setPlayerInteraction(new BarrierInteraction(door));
						newLevelModel.setDoor(door);
						doorCount++;
						break;
					case 'k':
						DoorKey doorKey = new DoorKey(pos);
						doorKey.setPlayerInteraction(new DoorKeyInteraction(doorKey, new LevelFacade(newLevelModel)));
						newLevelModel.setDoorKey(doorKey);
						doorKeyCount++;
						break;
				}
			}
		}

		if (playerCount != 1 || !(doorCount == 0 || doorCount == 1) || (doorCount != doorKeyCount) || (exitDoorCount != 1) )
			throw new InvalidLevelException();
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
