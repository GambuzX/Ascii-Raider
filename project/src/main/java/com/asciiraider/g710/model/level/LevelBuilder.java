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
	List<Level> buildAllLevels() {
		List<Level> levels = new ArrayList<>();
		for (int i = 1 ; i <= lvlCount; i++) {
			try {
				levels.add( buildLevel(i) );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return levels;
	}

	private Level buildLevel(int levelNumber) throws IOException {
		List<String> levelLines = readLevelFile(levelNumber);
		return buildLevelFromFile(levelLines);
	}

	private Level buildLevelFromFile(List<String> levelLines) {
		Level newLevel = new Level();
		for (int row = 0; row < levelLines.size(); row++) {
			for (int col = 0; col < levelLines.get(0).length(); col++) {

				char curr = levelLines.get(row).charAt(col);
				Position pos = new Position(col, row);

				switch(curr) {
					case 'W':
						newLevel.addWall(new Wall(pos));
						break;
					case 'S':
						newLevel.addStoneBlock(new StoneBlock(pos));
						break;
					case 'B':
						newLevel.addBoulder(new Boulder(pos));
						break;
					case 'P':
						newLevel.setPlayer(new Player(pos));
						break;
					case 'E':
						newLevel.addEnemy(new Enemy(pos));
						break;
					case 'T':
						newLevel.addTNT(new TNT(pos));
						break;
					case 's':
						newLevel.addSandBlock(new Sand(pos));
						break;
					case 'K':
						newLevel.addKey(new LevelKey(pos));
						break;
					case 'D':
						newLevel.setExitDoor(new ExitDoor(pos));
						break;
				}
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
