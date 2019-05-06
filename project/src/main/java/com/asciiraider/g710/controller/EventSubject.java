package com.asciiraider.g710.controller;

public interface EventSubject<M> {
	void addObserver(M observer);
	void removeObserver(M observer);
	void notifyObservers();
}
