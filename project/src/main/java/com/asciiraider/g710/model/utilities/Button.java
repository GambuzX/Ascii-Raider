package com.asciiraider.g710.model.utilities;

import com.asciiraider.g710.controller.command.ButtonCommand;
import com.asciiraider.g710.model.Model;

public class Button extends Model {
	private String text;
	private Position upperLeft, lowerRight;
	private HexColorString backgroundColor;
	private HexColorString textColor;
	private boolean active;
	private ButtonCommand action;

	public Button(String text, Position upperLeft, Position lowerRight, HexColorString backgroundColor, HexColorString textColor) {
		this.text = text;
		this.upperLeft = upperLeft;
		this.lowerRight = lowerRight;
		this.backgroundColor = backgroundColor;
		this.textColor = textColor;
		this.active = false;
	}

	public String getText() {
		return text;
	}

	public Position getUpperLeft() {
		return upperLeft;
	}

	public Position getLowerRight() {
		return lowerRight;
	}

	public HexColorString getBackgroundColor() {
		return backgroundColor;
	}

	public HexColorString getTextColor() {
		return textColor;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setAction(ButtonCommand action) {
		this.action = action;
	}

	public ButtonCommand getAction() {
		return action;
	}
}
