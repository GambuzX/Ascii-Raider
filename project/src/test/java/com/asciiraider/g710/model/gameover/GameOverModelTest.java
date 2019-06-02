package com.asciiraider.g710.model.gameover;

import com.asciiraider.g710.model.utilities.Score;
import com.asciiraider.g710.model.utilities.Button;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GameOverModelTest {
	@Test
	public void getFinalScore(){
		GameOverModel gameOverModel = new GameOverModel(123);
		assertTrue(gameOverModel.getFinalScore() != null);
		assertTrue(gameOverModel.getFinalScore() instanceof Score);
	}

	@Test
	public void getRestartButton(){
		GameOverModel gameOverModel = new GameOverModel(123);
		assertTrue(gameOverModel.getRestartButton() != null);
		assertTrue(gameOverModel.getRestartButton() instanceof Button);
	}
}
