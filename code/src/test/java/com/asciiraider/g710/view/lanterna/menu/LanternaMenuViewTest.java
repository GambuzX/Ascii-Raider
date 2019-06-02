package com.asciiraider.g710.view.lanterna.menu;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.model.utilities.Button;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.view.lanterna.utilities.LanternaButtonView;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LanternaMenuViewTest {
    @Test
    public void testDraw() {
        TextGraphics graphicsMock = mock(TextGraphics.class);

        TerminalScreen screenMock = mock(TerminalScreen.class);
        when(screenMock.newTextGraphics()).thenReturn(graphicsMock);

        LanternaButtonView lanternaButtonViewMock = mock(LanternaButtonView.class);

        LanternaMenuView lanternaMenuView = new LanternaMenuView(screenMock, lanternaButtonViewMock);

        Button buttonMock = mock(Button.class);
        when(buttonMock.getUpperLeft()).thenReturn(new Position(1,1));
        when(buttonMock.getLowerRight()).thenReturn(new Position(5,5));

        List<Button> buttonMocks = new ArrayList<>();
        buttonMocks.add(buttonMock);
        buttonMocks.add(buttonMock);

        MenuModel menuModel = mock(MenuModel.class);
        when(menuModel.getNumberOptions()).thenReturn(2);
        when(menuModel.getOptions()).thenReturn(buttonMocks);

        lanternaMenuView.draw(menuModel);

        verify(lanternaButtonViewMock, times(2)).draw(any(Button.class));

        verify(graphicsMock, times(1)).setForegroundColor(TextColor.Factory.fromString(new HexColorString("CCCCCC").toString()));
        verify(graphicsMock, times(1)).putString((GlobalConfigs.LEVEL_WIDTH - GlobalConfigs.GAME_NAME.length()) / 2, 1, GlobalConfigs.GAME_NAME);

        verify(screenMock, times(1)).clear();
        verify(screenMock, times(1)).newTextGraphics();
        try {
            verify(screenMock, times(1)).refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
