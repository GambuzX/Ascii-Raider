package com.asciiraider.g710.model.infobar;

import com.asciiraider.g710.controller.LevelCompletedObserver;
import com.asciiraider.g710.controller.LevelKeyObserver;
import com.asciiraider.g710.controller.PlayerDeathObserver;
import com.asciiraider.g710.model.Model;

public class InfoBarModel extends Model implements LevelKeyObserver, PlayerDeathObserver, LevelCompletedObserver {
    //TODO level, lives, keys, time, score, R button
    private int currentLevel = 1;
    private int lives = 3;
    private int keys;
    private int maxKeys = 1;
    private int time;
    private int score = 0;

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getKeys() {
        return keys;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setMaxKeys(int maxKeys) {
        this.maxKeys = maxKeys;
    }

    public int getMaxKeys(){
        return this.maxKeys;
    }

    @Override
    public void updateLevelKey() {
        this.keys++;
    }

    @Override
    public void updateDeath() {
        this.lives--;
    }

    @Override
    public void updatePontuation(int pontuation) {
        this.score += pontuation;
    }

    @Override
    public void updateNumKeys(int numKeys) {
        this.keys = 0;
        this.maxKeys = numKeys;
        this.currentLevel++;
    }
}
