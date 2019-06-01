package com.asciiraider.g710.view.lanterna;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.view.Event;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class LanternaStateViewTest {

    private LanternaStateView stateView;
    private final int[] counter = new int[1];

    @Before
    public void setUp() {

        KeyStroke keyStrokeMock = mock(KeyStroke.class);
        when(keyStrokeMock.getKeyType()).thenReturn(KeyType.EOF);

        Answer<Boolean> answer = new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocation) throws Throwable {
                counter[0]++;
                return true;
            }
        };

        TerminalScreen screenMock = mock(TerminalScreen.class);
        try {
            when(screenMock.readInput()).thenReturn(keyStrokeMock);
            doAnswer(answer).when(screenMock).close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stateView = new LanternaStateView(screenMock) {
            @Override
            public void draw(Model model) {
                return;
            }
        };
    }

    @Test
    public void getEventsListTest() {
        List eventsList = stateView.getEventsList();

        assertEquals(1, eventsList.size());
        assertEquals(eventsList.get(0), Event.EOF);
    }

    @Test
    public void exitTest() {

        stateView.exit();
        assertEquals(1, counter[0]);
    }
}
