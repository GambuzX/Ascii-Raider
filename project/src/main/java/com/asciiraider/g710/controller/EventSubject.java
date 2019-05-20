package com.asciiraider.g710.controller;

// TODO mudar para extends observer??
public interface EventSubject<M> {
	void addObserver(M observer);
	void removeObserver(M observer);
	void notifyObservers();
}
