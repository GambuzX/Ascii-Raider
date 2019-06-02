package com.asciiraider.g710.view.event;

import com.asciiraider.g710.view.event.Event;
import com.asciiraider.g710.view.event.KeyPressEvent;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KeyPressEventTest {

    private KeyPressEvent keyPressEvent;
    private List<KeyStroke> keyStrokes = new ArrayList<>();
    private List<KeyEvent> keyEvents = new ArrayList<>();

    @Before
    public void setUp() {
        keyPressEvent = new KeyPressEvent();

        KeyStroke keyStrokeMock1 = mock(KeyStroke.class);
        when(keyStrokeMock1.getKeyType()).thenReturn(KeyType.EOF);

        KeyStroke keyStrokeMock2 = mock(KeyStroke.class);
        when(keyStrokeMock2.getKeyType()).thenReturn(KeyType.Character);
        when(keyStrokeMock2.getCharacter()).thenReturn('q');

        KeyStroke keyStrokeMock3 = mock(KeyStroke.class);
        when(keyStrokeMock3.getKeyType()).thenReturn(KeyType.ArrowUp);

        KeyStroke keyStrokeMock4 = mock(KeyStroke.class);
        when(keyStrokeMock4.getKeyType()).thenReturn(KeyType.ArrowRight);

        KeyStroke keyStrokeMock5 = mock(KeyStroke.class);
        when(keyStrokeMock5.getKeyType()).thenReturn(KeyType.ArrowDown);

        KeyStroke keyStrokeMock6 = mock(KeyStroke.class);
        when(keyStrokeMock6.getKeyType()).thenReturn(KeyType.ArrowLeft);

        KeyStroke keyStrokeMock7 = mock(KeyStroke.class);
        when(keyStrokeMock7.getKeyType()).thenReturn(KeyType.Enter);

        KeyStroke keyStrokeMock8 = mock(KeyStroke.class);
        when(keyStrokeMock8.getKeyType()).thenReturn(KeyType.Character);
        when(keyStrokeMock8.getCharacter()).thenReturn('r');

        KeyStroke keyStrokeMock9 = mock(KeyStroke.class);
        when(keyStrokeMock9.getKeyType()).thenReturn(KeyType.Backspace);

        keyStrokes.add(keyStrokeMock1);
        keyStrokes.add(keyStrokeMock2);
        keyStrokes.add(keyStrokeMock3);
        keyStrokes.add(keyStrokeMock4);
        keyStrokes.add(keyStrokeMock5);
        keyStrokes.add(keyStrokeMock6);
        keyStrokes.add(keyStrokeMock7);
        keyStrokes.add(keyStrokeMock8);
        keyStrokes.add(keyStrokeMock9);

        KeyEvent keyEventMock1 = mock(KeyEvent.class);
        when(keyEventMock1.getKeyCode()).thenReturn(KeyEvent.VK_ENTER);

        KeyEvent keyEventMock2 = mock(KeyEvent.class);
        when(keyEventMock2.getKeyCode()).thenReturn(KeyEvent.VK_UP);

        KeyEvent keyEventMock3 = mock(KeyEvent.class);
        when(keyEventMock3.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);

        KeyEvent keyEventMock4 = mock(KeyEvent.class);
        when(keyEventMock4.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);

        KeyEvent keyEventMock5 = mock(KeyEvent.class);
        when(keyEventMock5.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);

        KeyEvent keyEventMock6 = mock(KeyEvent.class);
        when(keyEventMock6.getKeyCode()).thenReturn(KeyEvent.VK_Q);

        KeyEvent keyEventMock7 = mock(KeyEvent.class);
        when(keyEventMock7.getKeyCode()).thenReturn(KeyEvent.VK_R);

        KeyEvent keyEventMock8 = mock(KeyEvent.class);
        when(keyEventMock8.getKeyCode()).thenReturn(KeyEvent.VK_X);

        keyEvents.add(keyEventMock1);
        keyEvents.add(keyEventMock2);
        keyEvents.add(keyEventMock3);
        keyEvents.add(keyEventMock4);
        keyEvents.add(keyEventMock5);
        keyEvents.add(keyEventMock6);
        keyEvents.add(keyEventMock7);
        keyEvents.add(keyEventMock8);

    }

    @Test
    public void testLanterna1() {
        assertEquals(Event.EOF, keyPressEvent.handleLanterna(keyStrokes.get(0)));
    }

    @Test
    public void testLanterna2() {
        assertEquals(Event.Q_KEY, keyPressEvent.handleLanterna(keyStrokes.get(1)));
    }

    @Test
    public void testLanterna3() {
        assertNull(keyPressEvent.handleLanterna(keyStrokes.get(8)));
    }

    @Test
    public void testLanterna4() {
        assertEquals(Event.UP_KEY, keyPressEvent.handleLanterna(keyStrokes.get(2)));
    }

    @Test
    public void testLanterna5() {
        assertEquals(Event.RIGHT_KEY, keyPressEvent.handleLanterna(keyStrokes.get(3)));
    }

    @Test
    public void testLanterna6() {
        assertEquals(Event.DOWN_KEY, keyPressEvent.handleLanterna(keyStrokes.get(4)));
    }

    @Test
    public void testLanterna7() {
        assertEquals(Event.LEFT_KEY, keyPressEvent.handleLanterna(keyStrokes.get(5)));
    }

    @Test
    public void testLanterna8() {
        assertEquals(Event.ENTER_KEY, keyPressEvent.handleLanterna(keyStrokes.get(6)));
    }

    @Test
    public void testLanterna9() {
        assertEquals(Event.R_KEY, keyPressEvent.handleLanterna(keyStrokes.get(7)));
    }

    @Test
    public void testSwing1() {
        assertEquals(Event.ENTER_KEY, keyPressEvent.handleSwing(keyEvents.get(0)));
    }

    @Test
    public void testSwing2() {
        assertNull(keyPressEvent.handleSwing(keyEvents.get(7)));
    }

    @Test
    public void testSwing3() {
        assertEquals(Event.UP_KEY, keyPressEvent.handleSwing(keyEvents.get(1)));
    }

    @Test
    public void testSwing4() {
        assertEquals(Event.RIGHT_KEY, keyPressEvent.handleSwing(keyEvents.get(2)));
    }

    @Test
    public void testSwing5() {
        assertEquals(Event.LEFT_KEY, keyPressEvent.handleSwing(keyEvents.get(3)));
    }

    @Test
    public void testSwing6() {
        assertEquals(Event.DOWN_KEY, keyPressEvent.handleSwing(keyEvents.get(4)));
    }

    @Test
    public void testSwing7() {
        assertEquals(Event.Q_KEY, keyPressEvent.handleSwing(keyEvents.get(5)));
    }

    @Test
    public void testSwing8() {
        assertEquals(Event.R_KEY, keyPressEvent.handleSwing(keyEvents.get(6)));
    }
}
