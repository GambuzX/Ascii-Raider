package com.asciiraider.g710.controller.level;

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


	// TODO: deixar o repetido ??

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

	// Acaba aqui //

	public int getHeight() {return levelModel.getBottomRightCorner().getY();}

	public int getWidth() {return levelModel.getBottomRightCorner().getX();}

	public List<AnimatedElement> getAnimatedElements(){
		List<AnimatedElement> animatedElements =  new ArrayList<>();
		animatedElements.addAll(levelModel.getExplosions());
		return animatedElements;
	}

	public void removeAnimation(Position pos){
		Element element = findElement(pos);
		levelModel.getExplosions().remove(element);
		clearMatrixPosition(element.getPosition());
	}

	public Explosion findExplosion(Position pos) {
		Element element = findElement(pos);
		if (element instanceof Explosion)
			return (Explosion) element;
		return null;
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

	public List<PhysicsElement> getPhysicsElements() {
		List<PhysicsElement> physicsElements = new ArrayList<>();
		physicsElements.addAll(levelModel.getBoulders());
		physicsElements.addAll(levelModel.getLevelKeys());
		physicsElements.addAll(levelModel.getTNT());
		if(levelModel.getDoorKey() != null)
			physicsElements.add(levelModel.getDoorKey());
		return physicsElements;
	}

	public List<Position> getAdjacentEmptyPositions(Position pos) {
		List<Position> adj = new ArrayList<>();

		if (isEmptyPosition(pos.getAbove())) adj.add(pos.getAbove());

		if (isEmptyPosition(pos.getBelow())) adj.add(pos.getBelow());

		if (isEmptyPosition(pos.getLeftSide())) adj.add(pos.getLeftSide());

		if (isEmptyPosition(pos.getRightSide())) adj.add(pos.getRightSide());

		return adj;
	}

	// TODO: mudar nome e talvez sitio desta funcao
	public boolean isEmptyPosition(Position position) {
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

	public void addExplosion(Position position, int fps) {
		levelModel.addExplostion(new Explosion(position, fps));
	}

	// TODO Initially instead of Element the first parameter was a Movable, but boulders also need to be moved
	// TODO rethink elements hierarchy
	public void setElementPosition(MovableElement movable, Position newPos) {
		clearMatrixPosition(movable.getPosition());
		movable.setPosition(newPos);
		updateMatrixPosition(movable);
	}
}
