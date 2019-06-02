package com.asciiraider.g710.controller.element;

import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.Enemy;
import com.asciiraider.g710.model.utilities.Position;

import java.util.List;

public class EnemyController {
	private Enemy enemy;

	public EnemyController(Enemy enemy){
		this.enemy = enemy;
	}

	public void handle(LevelFacade levelFacade) {
		List<Position> adj = enemy.move(levelFacade.getPlayer().getPosition());
		if(adj == null) return;
		for (Position pos : adj)
			if (levelFacade.insideBounds(pos) && levelFacade.canEnemyMoveTo(pos)) {
				levelFacade.setElementPosition(enemy, pos);
				break;
			}

	}
}
