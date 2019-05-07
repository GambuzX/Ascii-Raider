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
	private static final int lvlCount = 8;
	private List<LevelModel> levels = new ArrayList<>();

	public LevelBuilder() {
		this.buildAllLevels();
	}

	public List<LevelModel> getLevels() {
		return levels;
	}

	public LevelModel getLevel(int levelNumber) {
		return levels.get(levelNumber%levels.size());
	}

	// TODO: ver isto de protected vs package-private
	private void buildAllLevels() {
		List<LevelModel> levelModels = new ArrayList<>();
		for (int i = 1 ; i <= lvlCount; i++) {
			try {
				levelModels.add( buildLevel(i) );
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidLevelException ile) {
				System.out.println("Tried to build invalid level");
			}

		}
		levels = levelModels;
	}

	private LevelModel buildLevel(int levelNumber) throws IOException, InvalidLevelException {
		List<String> levelLines = readLevelFile(levelNumber);
		return buildLevelFromFile(levelLines);
	}

	private LevelModel buildLevelFromFile(List<String> levelLines) throws InvalidLevelException {
		LevelModel newLevelModel = new LevelModel(new Position(levelLines.get(0).length(), levelLines.size()));
		
		// TODO make sure dimensions are okay
		int playerCount = 0, doorCount = 0, doorKeyCount = 0;
		for (int row = 0; row < levelLines.size(); row++) {
			for (int col = 0; col < levelLines.get(0).length(); col++) {

				char curr = levelLines.get(row).charAt(col);
				Position pos = new Position(col, row);

				switch(curr) {
					case 'W':
						newLevelModel.addWall(new Wall(pos));
						break;
					case 'S':
						newLevelModel.addStoneBlock(new StoneBlock(pos));
						break;
					case 'B':
						newLevelModel.addBoulder(new Boulder(pos));
						break;
					case 'P':
						newLevelModel.setPlayer(new Player(pos));
						playerCount++;
						break;
					case 'E':
						newLevelModel.addEnemy(new SkullEnemy(pos));
						break;
					case 'M':
						newLevelModel.addEnemy(new MummyEnemy(pos));
						break;
					case 'T':
						newLevelModel.addTNT(new TNT(pos));
						break;
					case 's':
						newLevelModel.addSandBlock(new Sand(pos));
						break;
					case 'K':
						newLevelModel.addLevelKey(new LevelKey(pos));
						break;
					case 'D':
						newLevelModel.setExitDoor(new ExitDoor(pos));
						break;
					case 'd':
						newLevelModel.setDoor(new Door(pos));
						doorCount++;
						break;
					case 'k':
						newLevelModel.setDoorKey(new DoorKey(pos));
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
