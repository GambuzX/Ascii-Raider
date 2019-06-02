package com.asciiraider.g710.controller.observer;

public interface LevelCompletedObserver {
	void updateScore(int pontuation);
	void updateNumKeys(int numKeys);

}
