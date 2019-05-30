package com.asciiraider.g710.model.utilities;

import com.asciiraider.g710.GlobalConfigs;

import java.util.ArrayList;
import java.util.List;

public class Animation {
	private List<Symbol> symbolSequence;
	private double duration;
	private boolean isLoop;
	private int frameCounter, currentSymbol;


	public Animation(double duration, boolean isLoop) {
		this.duration = duration;
		this.isLoop = isLoop;
		symbolSequence = new ArrayList<>();
		frameCounter = 0;
		currentSymbol = 0;
	}

	public void addSymbol(Symbol symbol){
		symbolSequence.add(symbol);
	}

	public Symbol getNextSymbol(){
		int updateFrequency = getUpdateFrequency(GlobalConfigs.FPS);
		if(frameCounter < updateFrequency){
			frameCounter++;
			return symbolSequence.get(currentSymbol);
		}
		frameCounter = 0;
		if(currentSymbol == symbolSequence.size() - 1 && !isLoop)
			return null;

		currentSymbol = (currentSymbol + 1) % symbolSequence.size();
		return symbolSequence.get(currentSymbol);
	}

	private int getUpdateFrequency(int fps){
		return (int) ((this.duration / symbolSequence.size()) * fps);
	}
}
