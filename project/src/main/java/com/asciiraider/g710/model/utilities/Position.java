package com.asciiraider.g710.model.utilities;

// TODO: ver se faz sentido X e Y n poder ser menor que 0
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

	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if (this == o) return true;
		if (getClass() != o.getClass()) return false;
		Position position = (Position) o;
		return getX() == position.getX() &&
				getY() == position.getY();
	}

}
