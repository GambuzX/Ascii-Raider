package com.asciiraider.g710.model.gameover;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.model.infobar.Score;
import com.asciiraider.g710.model.utilities.Button;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;

public class GameOverModel extends Model {
	private Score finalScore;
	private Button restartButton;


	public GameOverModel(int finalScore){
		this.finalScore = new Score(finalScore);
		this.restartButton = new Button("RESTART", new Position(5, 7), new Position(13, 10), new HexColorString("b52225"), new HexColorString("0"));
	}

	public Score getFinalScore() {
		return finalScore;
	}

	public Button getRestartButton() {
		return restartButton;
	}
}
