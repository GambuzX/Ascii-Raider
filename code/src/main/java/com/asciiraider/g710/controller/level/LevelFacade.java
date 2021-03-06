package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.controller.element.interaction.DeathInteraction;
import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class LevelFacade {
	private LevelModel levelModel;

	public LevelFacade(LevelModel levelModel) {
		this.levelModel = levelModel;
	}

	public Player getPlayer() {
		return levelModel.getPlayer();
	}

	public ExitDoor getExitDoor() {
		return levelModel.getExitDoor();
	}

	public Door getDoor() {
		return levelModel.getDoor();
	}

	public DoorKey getDoorKey() {
		return levelModel.getDoorKey();
	}

	public List<LevelKey> getLevelKeys() {
		return levelModel.getLevelKeys();
	}

	public List<Enemy> getEnemies() {
		return levelModel.getEnemies();
	}

	public List<AnimatedElement> getAnimatedElements(){
		List<AnimatedElement> animatedElements =  new ArrayList<>();
		animatedElements.addAll(levelModel.getExplosions());
		return animatedElements;
	}

	public List<Element> getElements() {
		List<Element> elements = new ArrayList<>();
		elements.add(levelModel.getPlayer());
		elements.add(levelModel.getExitDoor());
		elements.addAll(levelModel.getWalls());
		elements.addAll(levelModel.getBoulders());
		elements.addAll(levelModel.getStoneBlocks());
		elements.addAll(levelModel.getSandBlocks());
		elements.addAll(levelModel.getLevelKeys());
		elements.addAll(levelModel.getTNT());
		elements.addAll(levelModel.getEnemies());
		elements.addAll(levelModel.getExplosions());
		if(levelModel.getDoor() != null){
			elements.add(levelModel.getDoor());
			elements.add(levelModel.getDoorKey());
		}
		return elements;
	}

	public boolean insideBounds(Position pos) {
		return pos.getX() < GlobalConfigs.LEVEL_WIDTH && pos.getY() < GlobalConfigs.LEVEL_HEIGHT;
	}

	public void removeAnimation(Element animation){
		levelModel.getExplosions().remove(animation);
		clearMatrixPosition(animation.getPosition());
	}

	public Explosion findExplosion(Position pos) {
		Element element = findElement(pos);
		if (element instanceof Explosion)
			return (Explosion) element;
		return null;
	}

	public List<PhysicsElement> getPhysicsElements() {
		List<PhysicsElement> physicsElements = new ArrayList<>();
		physicsElements.addAll(levelModel.getBoulders());
		physicsElements.addAll(levelModel.getLevelKeys());
		physicsElements.addAll(levelModel.getTNT());
		if(levelModel.getDoorKey() != null)
			physicsElements.add(levelModel.getDoorKey());
		return physicsElements;
	}

	public boolean canEnemyMoveTo(Position position) {
		Element ele = findElement(position);
		return (ele == null || ele.equals(getPlayer()));
	}

	public Element findElement(Position pos) {
		return levelModel.getElementsMatrix()[pos.getX()][pos.getY()];
	}

	public PhysicsElement findPhysicsElement(Position pos) {
		Element element = findElement(pos);
		if (element instanceof Boulder || element instanceof TNT || element instanceof LevelKey)
			return (PhysicsElement) element;
		return null;
	}

	public Wall findWall(Position pos) {
		Element element = findElement(pos);
		if(element instanceof Wall)
			return (Wall) element;
		return null;
	}

	public Boulder findBoulder(Position pos) {
		Element element = findElement(pos);
		if(element instanceof Boulder)
			return (Boulder) element;
		return null;
	}

	public LevelKey findLevelKey(Position pos) {
		Element element = findElement(pos);
		if(element instanceof LevelKey)
			return (LevelKey) element;
		return null;
	}

	public Sand findSandBlock(Position pos) {
		Element element = findElement(pos);
		if(element instanceof Sand)
			return (Sand) element;
		return null;
	}

	public StoneBlock findStoneBlock(Position pos) {
		Element element = findElement(pos);
		if(element instanceof StoneBlock)
			return (StoneBlock) element;
		return null;
	}

	public DoorKey findDoorKey(Position pos) {
		Element element = findElement(pos);
		if (element instanceof DoorKey)
			return (DoorKey) element;
		return null;
	}

	public TNT findTNT(Position pos) {
		Element element = findElement(pos);
		if (element instanceof TNT)
			return (TNT) element;
		return null;
	}

	public Enemy findEnemy(Position pos) {
		if(pos == null)
			return null;
		Element element = findElement(pos);
		if (element instanceof Enemy)
			return (Enemy) element;
		return null;
	}

	public boolean removeLevelKey(Position pos) {
		Element element = findElement(pos);
		if(element instanceof LevelKey) {
			clearMatrixPosition(element.getPosition());
			levelModel.getLevelKeys().remove(element);
			return true;
		}
		return false;
	}

	public boolean removeSandBlock(Position pos) {
		Element element = findElement(pos);
		if(element instanceof Sand) {
			clearMatrixPosition(element.getPosition());
			levelModel.getSandBlocks().remove(element);
			return true;
		}
		return false;
	}

	public void removeDoorKey() {
		clearMatrixPosition(levelModel.getDoorKey().getPosition());
		levelModel.setDoorKey(null);
	}

	public void removeDoor() {
		clearMatrixPosition(levelModel.getDoor().getPosition());
		levelModel.setDoor(null);
	}

	public void removeDestructibleElement(Position pos) {
		Element element = findElement(pos);
		if (!(element instanceof DestructibleElement)) return;

		if (element instanceof Player) {
			levelModel.setPlayer(null);
		}
		else if (element instanceof DoorKey) {
			levelModel.setDoorKey(null);
		}
		else if (element instanceof StoneBlock) {
			levelModel.getStoneBlocks().remove(element);
		}
		else if (element instanceof Sand) {
			levelModel.getSandBlocks().remove(element);
		}
		else if (element instanceof Boulder) {
			levelModel.getBoulders().remove(element);
		}
		else if (element instanceof LevelKey) {
			levelModel.getLevelKeys().remove(element);
		}
		else if (element instanceof TNT) {
			levelModel.getTNT().remove(element);
		}
		else if (element instanceof Enemy) {
			levelModel.getEnemies().remove(element);
		}
		clearMatrixPosition(element.getPosition());
	}

	public void clearMatrixPosition(Position position) {
		levelModel.clearMatrixPosition(position);
	}

	public void updateMatrixPosition(Element ele) {
		levelModel.updateMatrixPosition(ele);
	}

	public void addExplosion(Position position) {

		Explosion explosion = new Explosion(position);
		explosion.setPlayerInteraction(new DeathInteraction(explosion));
		levelModel.addExplosion(explosion);
	}

	public void setElementPosition(MovableElement movable, Position newPos) {
		clearMatrixPosition(movable.getPosition());
		movable.setPosition(newPos);
		updateMatrixPosition(movable);
	}
}
