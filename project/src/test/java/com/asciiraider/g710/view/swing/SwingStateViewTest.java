package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.lanterna.LanternaStateView;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class SwingStateViewTest {

    private SwingStateView stateView;

    private JFrame jFrameMock;

    @Before
    public void setUp() {

        jFrameMock = mock(JFrame.class);

        stateView = new SwingStateView(jFrameMock) {
            @Override
            public void draw(Model model) {
                return;
            }
        };
    }

    @Test
    public void getEventsListTest() {
        List eventsList = stateView.getEventsList();

        assertEquals(0, eventsList.size());
    }

    @Test
    public void exitTest() {

        stateView.exit();

        verify(jFrameMock, times(1)).setVisible(false);
        verify(jFrameMock, times(1)).dispose();
    }
}
