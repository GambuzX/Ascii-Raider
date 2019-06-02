package com.asciiraider.g710.view.lanterna.gameover;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.view.lanterna.LanternaStateView;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class LanternaGameOverView extends LanternaStateView<GameOverModel> {

	public LanternaGameOverView(TerminalScreen screen){
		super(screen);
	}

	@Override
	public void draw(GameOverModel model) {
		screen.clear();
		TextGraphics graphics = screen.newTextGraphics();
		graphics.setForegroundColor(TextColor.Factory.fromString(new HexColorString("CCCCCC").toString()));

		String gameOver = "GAME OVER";

		int column  = (GlobalConfigs.LEVEL_WIDTH - gameOver.length()) / 2;

		graphics.putString(column, 4, gameOver);

		String score = model.getFinalScore().toString();
		column  = (GlobalConfigs.LEVEL_WIDTH - score.length()) / 2;

		graphics.putString(column, 6, score);


		try {
			screen.refresh();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
