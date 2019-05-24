package com.asciiraider.g710.model.infobar;

import com.asciiraider.g710.controller.LevelCompletedObserver;
import com.asciiraider.g710.controller.LevelKeyObserver;
import com.asciiraider.g710.controller.PlayerDeathObserver;
import com.asciiraider.g710.model.Model;

public class InfoBarModel extends Model implements LevelKeyObserver, PlayerDeathObserver, LevelCompletedObserver {
    private int currentLevel;
    private int lives;
    private int keys;
    private int maxKeys;
    private int time;
    private int score;

    public InfoBarModel(int initialLevel, int maxLives, int maxKeys, int initialScore){
        this.currentLevel = initialLevel;
        this.lives = maxLives;
        this.maxKeys = maxKeys;
        this.score = initialScore;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getLives() {
        return lives;
    }

    public int getKeys() {
        return keys;
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
