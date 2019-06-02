package com.asciiraider.g710.model.utilities;

import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class TimeAlarmTest {
	private TimeAlarm timeAlarm;

	@Before
	public void setUp(){
		timeAlarm = new TimeAlarm(5);
	}

	@Test(expected = InvalidParameterException.class)
	public void constructor1(){
		TimeAlarm timeAlarm1 = new TimeAlarm(-1);
	}

	@Test
	public void constructor2(){
		TimeAlarm timeAlarm2 = new TimeAlarm(0);
		assertEquals(0, timeAlarm2.getCurrentTime());

	}

	@Test
	public void isRunning(){
		assertFalse(timeAlarm.isRunning());
	}

	@Test
	public void getCurrentTime1(){
		assertEquals(5, timeAlarm.getCurrentTime());
	}

	@Test
	public void start(){
		timeAlarm.start();
		assertTrue(timeAlarm.isRunning());
	}

	@Test
	public void stop(){
		timeAlarm.start();
		timeAlarm.stop();
		assertFalse(timeAlarm.isRunning());
	}

	@Test
	public void decTimer1(){
		timeAlarm.decTimer();
		assertEquals(5, timeAlarm.getCurrentTime());
	}

	@Test
	public void decTimer2(){
		timeAlarm.start();
		timeAlarm.decTimer();
		assertEquals(4, timeAlarm.getCurrentTime());
	}

	@Test(expected = InvalidParameterException.class)
	public void setTimer1(){
		timeAlarm.setTimer(-1);
	}

	@Test
	public void setTimer2(){
		timeAlarm.setTimer(8);
		assertEquals(8, timeAlarm.getCurrentTime());
	}

	@Test
	public void setTimer3(){
		timeAlarm.setTimer(0);
		assertEquals(0, timeAlarm.getCurrentTime());
	}

	@Test
	public void resetTimer(){
		timeAlarm.start();
		timeAlarm.decTimer();
		timeAlarm.decTimer();
		timeAlarm.resetTimer();
		assertEquals(5, timeAlarm.getCurrentTime());
	}
}
