package com.asciiraider.g710.model.utilities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Position {
	private int x, y;

	public Position(int x, int y) throws IllegalArgumentException {
		if(x < 0 || y < 0)
			throw new IllegalArgumentException("Either X or Y are less than 0");

		this.x = x;
		this.y = y;
	}

	public Position(Position position){
		this.x = position.getX();
		this.y = position.getY();
	}


	public int getX() {
		return x;
	}

	public void setX(int x) throws IllegalArgumentException {
		if(x < 0)
			throw new IllegalArgumentException("X can't be less than 0");
		this.x = x;
	}


	public int getY() {
		return y;
	}

	public void setY(int y) throws IllegalArgumentException {
		if(y < 0)
			throw new IllegalArgumentException("Y can't be less than 0");
		this.y = y;
	}

	// TODO: fazer controlo aqui do erro??
	public Position getAbove() throws IllegalArgumentException{
		return new Position(this.x, this.y - 1);
	}

	public Position getBelow(){
		return new Position(this.x, this.y + 1);
	}

	public Position getRightSide() {
		return new Position(this.x + 1, this.y);
	}

	public Position getLeftSide() throws IllegalArgumentException{
		return new Position(this.x - 1, this.y);
	}

	public List<Position> getAdjacent(){
		List<Position> adjacent = new ArrayList<>();

		try {
			adjacent.add(this.getAbove());
		}
		catch (Exception e) {}

		try {
			adjacent.add(this.getLeftSide());
		}
		catch (Exception e){}

		adjacent.add(this.getBelow());

		adjacent.add(this.getRightSide());

		return adjacent;
	}

	public List<Position> getMatrix(){
		List<Position> matrix = getAdjacent();
		try {
			matrix.add(this.getLeftSide().getAbove());
		}
		catch (Exception e) {}

		try{
			matrix.add(this.getLeftSide().getBelow());
		}
		catch (Exception e) {}

		try{
			matrix.add(this.getRightSide().getAbove());
		}
		catch (Exception e) {}

		matrix.add(this.getRightSide().getBelow());

		return matrix;
	}

	public double distance(Position pos2){
		return Math.sqrt(Math.pow(pos2.getX() - this.getX(), 2.0) + Math.pow(pos2.getY()-this.getY(), 2.0));
	}


	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if (this == o) return true;
		if (getClass() != o.getClass()) return false;
		Position position = (Position) o;
		return getX() == position.getX() &&
				getY() == position.getY();
	}

	public static Comparator<Position> createComparator(Position centralPosition)
	{
		final Position centerPosition =  centralPosition;
		return (p1, p2) -> {
			double d1 = (p1.distance(centerPosition));
			double d2 = (p2.distance(centerPosition));
			return Double.compare(d1, d2);
		};
	}
}
