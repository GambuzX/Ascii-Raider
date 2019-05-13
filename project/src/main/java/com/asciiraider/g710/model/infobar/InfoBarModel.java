package com.asciiraider.g710.model.infobar;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.model.utilities.HexColorString;

public class InfoBarModel extends Model {
    //TODO level, lives, keys, time, score, R button
    private int currentLevel;
    private int lives;
    private int maxLives;
    private int keys;
    private int time;
    private int score;
    private static final String rButton = "R";
    private static final HexColorString backgroundColor = new HexColorString("E0A21D");
    private static final HexColorString textColor = new HexColorString("000000");

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

    public String getrButton() {
        return rButton;
    }

    public HexColorString getBackgroundColor() {
        return backgroundColor;
    }

    public HexColorString getTextColor() {
        return textColor;
    }

    public int getMaxLives() {
        return maxLives;
    }

    public void setMaxLives(int maxLives) {
        this.maxLives = maxLives;
    }
}
