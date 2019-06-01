package com.asciiraider.g710.controller.infobar;

import com.asciiraider.g710.controller.element.LevelKeyController;
import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.controller.level.LevelProgressionController;
import com.asciiraider.g710.controller.level.LifeController;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.level.LevelTimeAlarm;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class InfoBarControllerTest {
	private InfoBarController infoBarController;

	@Test
	public void test1(){
		LevelKeyController levelKeyController = mock(LevelKeyController.class);
		LevelProgressionController levelProgressionController = mock(LevelProgressionController.class);
		LifeController lifeController = mock(LifeController.class);

		InfoBarModel infoBarModel = mock(InfoBarModel.class);


		LevelController levelController = mock(LevelController.class);
		when(levelController.getLevelKeyController()).thenReturn(levelKeyController);
		when(levelController.getLevelProgressionController()).thenReturn(levelProgressionController);
		when(levelController.getLifeController()).thenReturn(lifeController);

		infoBarController = new InfoBarController(levelController, infoBarModel);

		LevelTimeAlarm levelTimeAlarmMock = mock(LevelTimeAlarm.class);
		when(levelTimeAlarmMock.getCurrentTime()).thenReturn(5);

		infoBarController.handler(levelTimeAlarmMock);

		ArgumentCaptor<Integer> argument = ArgumentCaptor.forClass(Integer.class);
		verify(infoBarModel, times(1)).setTime(argument.capture());


		assertEquals(5, argument.getValue().intValue());
	}

	@Test
	public void test2(){
		LevelKeyController levelKeyController = mock(LevelKeyController.class);
		LevelProgressionController levelProgressionController = mock(LevelProgressionController.class);
		LifeController lifeController = mock(LifeController.class);

		InfoBarModel infoBarModel = mock(InfoBarModel.class);


		LevelController levelController = mock(LevelController.class);
		when(levelController.getLevelKeyController()).thenReturn(levelKeyController);
		when(levelController.getLevelProgressionController()).thenReturn(levelProgressionController);
		when(levelController.getLifeController()).thenReturn(lifeController);

		infoBarController = new InfoBarController(levelController, infoBarModel);


		verify(levelKeyController, times(1)).addObserver(infoBarModel);
		verify(lifeController, times(1)).addObserver(infoBarModel);
		verify(levelProgressionController, times(1)).addObserver(infoBarModel);


	}
}
