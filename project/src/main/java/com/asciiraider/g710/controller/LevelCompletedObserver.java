package com.asciiraider.g710.controller;

public interface LevelCompletedObserver {
	void updateScore(int pontuation);
	void updateNumKeys(int numKeys);

}
