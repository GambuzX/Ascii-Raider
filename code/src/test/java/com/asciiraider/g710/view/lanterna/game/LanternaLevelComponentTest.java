package com.asciiraider.g710.view.lanterna.game;

import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LanternaLevelComponentTest {

    @Test
    public void testDraw() {
        TextGraphics graphicsMock = mock(TextGraphics.class);

        TerminalScreen screenMock = mock(TerminalScreen.class);
        when(screenMock.newTextGraphics()).thenReturn(graphicsMock);

        LanternaElementView lanternaElementViewMock = mock(LanternaElementView.class);

        LanternaLevelComponent lanternaLevelComponent = new LanternaLevelComponent(screenMock, lanternaElementViewMock);

        Position positionMock = mock(Position.class);
        when(positionMock.getX()).thenReturn(1);
        when(positionMock.getY()).thenReturn(2);

        Symbol symbolMock = mock(Symbol.class);
        when(symbolMock.getAscii()).thenReturn('X');
        when(symbolMock.getForegroundColorString()).thenReturn("#010101");
        when(symbolMock.getBackgroundColorString()).thenReturn("#101010");

        Boulder boulderMock = mock(Boulder.class);
        when(boulderMock.getPosition()).thenReturn(positionMock);
        when(boulderMock.getSymbol()).thenReturn(symbolMock);

        Wall wallMock = mock(Wall.class);
        when(wallMock.getPosition()).thenReturn(positionMock);
        when(wallMock.getSymbol()).thenReturn(symbolMock);

        Player playerMock = mock(Player.class);
        when(playerMock.getPosition()).thenReturn(positionMock);
        when(playerMock.getSymbol()).thenReturn(symbolMock);

        ExitDoor exitDoorMock = mock(ExitDoor.class);
        when(exitDoorMock.getPosition()).thenReturn(positionMock);
        when(exitDoorMock.getSymbol()).thenReturn(symbolMock);

        TNT tntMock = mock(TNT.class);
        when(tntMock.getPosition()).thenReturn(positionMock);
        when(tntMock.getSymbol()).thenReturn(symbolMock);

        Sand sandMock = mock(Sand.class);
        when(sandMock.getPosition()).thenReturn(positionMock);
        when(sandMock.getSymbol()).thenReturn(symbolMock);

        StoneBlock stoneBlockMock = mock(StoneBlock.class);
        when(sandMock.getPosition()).thenReturn(positionMock);
        when(sandMock.getSymbol()).thenReturn(symbolMock);

        Enemy enemyMock = mock(Enemy.class);
        when(enemyMock.getPosition()).thenReturn(positionMock);
        when(enemyMock.getSymbol()).thenReturn(symbolMock);

        Explosion explosionMock = mock(Explosion.class);
        when(explosionMock.getPosition()).thenReturn(positionMock);
        when(explosionMock.getSymbol()).thenReturn(symbolMock);

        LevelKey levelKeyMock = mock(LevelKey.class);
        when(levelKeyMock.getPosition()).thenReturn(positionMock);
        when(levelKeyMock.getSymbol()).thenReturn(symbolMock);

        DoorKey doorKeyMock = mock(DoorKey.class);
        when(doorKeyMock.getPosition()).thenReturn(positionMock);
        when(doorKeyMock.getSymbol()).thenReturn(symbolMock);

        Door doorMock = mock(Door.class);
        when(doorMock.getPosition()).thenReturn(positionMock);
        when(doorMock.getSymbol()).thenReturn(symbolMock);



        List<Boulder> mocksList1 = new ArrayList<>();
        mocksList1.add(boulderMock);

        List<Wall> mocksList2 = new ArrayList<>();
        mocksList2.add(wallMock);

        List<TNT> mocksList3 = new ArrayList<>();
        mocksList3.add(tntMock);

        List<Sand> mocksList4 = new ArrayList<>();
        mocksList4.add(sandMock);

        List<StoneBlock> mocksList5 = new ArrayList<>();
        mocksList5.add(stoneBlockMock);

        List<Enemy> mocksList6 = new ArrayList<>();
        mocksList6.add(enemyMock);

        List<Explosion> mocksList7 = new ArrayList<>();
        mocksList7.add(explosionMock);

        List<LevelKey> mocksList8 = new ArrayList<>();
        mocksList8.add(levelKeyMock);

        LevelModel levelModelMock = mock(LevelModel.class);
        when(levelModelMock.getBoulders()).thenReturn(mocksList1);
        when(levelModelMock.getWalls()).thenReturn(mocksList2);
        when(levelModelMock.getTNT()).thenReturn(mocksList3);
        when(levelModelMock.getSandBlocks()).thenReturn(mocksList4);
        when(levelModelMock.getStoneBlocks()).thenReturn(mocksList5);
        when(levelModelMock.getEnemies()).thenReturn(mocksList6);
        when(levelModelMock.getLevelKeys()).thenReturn(mocksList8);
        when(levelModelMock.getExplosions()).thenReturn(mocksList7);
        when(levelModelMock.getExitDoor()).thenReturn(exitDoorMock);
        when(levelModelMock.getDoorKey()).thenReturn(doorKeyMock);
        when(levelModelMock.getDoor()).thenReturn(doorMock);
        when(levelModelMock.getPlayer()).thenReturn(playerMock);

        lanternaLevelComponent.draw(levelModelMock);

        verify(lanternaElementViewMock, times(12)).draw(any(Element.class));
    }
}
