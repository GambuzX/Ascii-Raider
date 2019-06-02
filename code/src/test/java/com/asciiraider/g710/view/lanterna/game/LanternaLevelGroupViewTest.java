package com.asciiraider.g710.view.lanterna.game;

import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LanternaLevelGroupViewTest {

    @Test
    public void drawTest() {
        TextGraphics graphicsMock = mock(TextGraphics.class);

        TerminalScreen screenMock = mock(TerminalScreen.class);
        when(screenMock.newTextGraphics()).thenReturn(graphicsMock);

        LanternaLevelComponent levelComponentMock = mock(LanternaLevelComponent.class);
        LanternaInfoBarComponent infoBarComponentMock = mock(LanternaInfoBarComponent.class);

        LevelModel levelModelMock = mock(LevelModel.class);
        InfoBarModel infoBarModelMock = mock(InfoBarModel.class);

        LevelModelGroup levelModelGroupMock = mock(LevelModelGroup.class);
        when(levelModelGroupMock.getLevelModel()).thenReturn(levelModelMock);
        when(levelModelGroupMock.getInfoBarModel()).thenReturn(infoBarModelMock);

        LanternaLevelGroupView levelGroupView = new LanternaLevelGroupView(screenMock, levelComponentMock, infoBarComponentMock);
        levelGroupView.draw(levelModelGroupMock);

        verify(levelComponentMock, times(1)).draw(any(LevelModel.class));
        verify(infoBarComponentMock, times(1)).draw(any(InfoBarModel.class));

        verify(screenMock, times(1)).clear();
        try {
            verify(screenMock, times(1)).refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
