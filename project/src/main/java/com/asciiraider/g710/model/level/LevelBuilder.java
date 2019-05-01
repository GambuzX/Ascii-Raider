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
	private static final int lvlCount = 3;
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
			}
		}
		levels = levelModels;
	}

	private LevelModel buildLevel(int levelNumber) throws IOException {
		List<String> levelLines = readLevelFile(levelNumber);
		return buildLevelFromFile(levelLines);
	}

	private LevelModel buildLevelFromFile(List<String> levelLines) {
		LevelModel newLevelModel = new LevelModel();

		LevelFacade newLevelFacade = new LevelFacade(newLevelModel);

		for (int row = 0; row < levelLines.size(); row++) {
			for (int col = 0; col < levelLines.get(0).length(); col++) {

				char curr = levelLines.get(row).charAt(col);
				Position pos = new Position(col, row);

				switch(curr) {
					case 'W':
						newLevelFacade.addWall(new Wall(pos));
						break;
					case 'S':
						newLevelFacade.addStoneBlock(new StoneBlock(pos));
						break;
					case 'B':
						newLevelFacade.addBoulder(new Boulder(pos));
						break;
					case 'P':
						newLevelFacade.setPlayer(new Player(pos));
						break;
					case 'E':
						newLevelFacade.addEnemy(new Enemy(pos));
						break;
					case 'T':
						newLevelFacade.addTNT(new TNT(pos));
						break;
					case 's':
						newLevelFacade.addSandBlock(new Sand(pos));
						break;
					case 'K':
						newLevelFacade.addKey(new LevelKey(pos));
						break;
					case 'D':
						newLevelFacade.setExitDoor(new ExitDoor(pos));
						break;
					case 'd':
						newLevelFacade.setDoor(new Door(pos));
						break;
					case 'k':
						newLevelFacade.setDoorKey(new DoorKey(pos));
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
