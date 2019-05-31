package com.asciiraider.g710.model.utilities;

import java.util.Objects;

public class HexColorString {
	private String color;

	public HexColorString() {
		this.color = "0";
	}

	public HexColorString(String color) throws IllegalArgumentException {
		if(!isValidHexColor(color))
			throw new IllegalArgumentException("Color is not a valid hex color");
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) throws IllegalArgumentException {
		if(!isValidHexColor(color))
			throw new IllegalArgumentException("Color is not a valid hex color");
		this.color = color;
	}

	public boolean isValidHexColor(String color){
		return color.matches("^[0-9a-fA-F]{1,6}$");
	}

	@Override
	public String toString() {
		return "#" + color;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		HexColorString that = (HexColorString) o;
		return Objects.equals(getColor(), that.getColor());
	}
}
