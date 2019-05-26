package com.asciiraider.g710.view.lanterna.utilities;

import com.asciiraider.g710.model.utilities.Button;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.view.View;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.awt.*;

public class LanternaButtonView extends View<Button> {
	private TerminalScreen screen;

	public LanternaButtonView(TerminalScreen screen){
		this.screen = screen;
	}

	@Override
	public void draw(Button model) {
		TextGraphics graphics = screen.newTextGraphics();
		if(model.isActive())
			graphics.setBackgroundColor(TextColor.Factory.fromString(model.getBackgroundColor().toString()));
		else{
			Color backDarkerColor = TextColor.Factory.fromString(model.getBackgroundColor().toString()).toColor().darker();

			graphics.setBackgroundColor(new TextColor.RGB(backDarkerColor.getRed(), backDarkerColor.getGreen(), backDarkerColor.getBlue()));

		}
		graphics.setForegroundColor(TextColor.Factory.fromString(model.getTextColor().toString()));

		drawRectangle(graphics, model.getUpperLeft(), model.getLowerRight());

		int x = (model.getUpperLeft().getX() + model.getLowerRight().getX() - model.getText().length()) / 2;
		int y = (model.getUpperLeft().getY() + model.getLowerRight().getY()) / 2;
		graphics.putString(x, y, model.getText());

	}

	//TODO: refactor para button
	public void drawRectangle(TextGraphics graphics, Position upperLeft, Position lowerRight){
		for(int i = upperLeft.getX(); i < lowerRight.getX(); i++ )
			for(int j = upperLeft.getY(); j < lowerRight.getY(); j++)
				graphics.putString(new TerminalPosition(i, j), " ");

	}
}
