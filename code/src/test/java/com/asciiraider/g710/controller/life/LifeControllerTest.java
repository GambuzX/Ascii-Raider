package com.asciiraider.g710.controller.life;

import com.asciiraider.g710.controller.life.LifeController;
import com.asciiraider.g710.controller.observer.PlayerDeathObserver;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LifeControllerTest {
	private LifeController lifeController;
	private PlayerDeathObserver playerDeathObserver;

	@Before
	public void setUp(){
		lifeController = new LifeController();
		playerDeathObserver = mock(PlayerDeathObserver.class);
	}

	@Test
	public void add1(){

		lifeController.addObserver(playerDeathObserver);
		lifeController.notifyObservers();

		verify(playerDeathObserver, times(1)).updateDeath();
	}

	@Test
	public void remove1(){
		lifeController.addObserver(playerDeathObserver);
		lifeController.removeObserver(playerDeathObserver);
		lifeController.notifyObservers();

		verify(playerDeathObserver, never()).updateDeath();
	}


}
