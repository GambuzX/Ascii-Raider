package com.asciiraider.g710;

public final class GlobalConfigs {
    public final static String GAME_NAME = "ASCII Raider";

    public final static int PLAYER_HP = 3;
    public final static int FPS = 20;
    public final static int LEVEL_COUNT = 8;
    public final static int LEVEL_WIDTH = 18;
    public final static int LEVEL_HEIGHT = 12;
    public final static int INFOBAR_HEIGHT = 1;

    public final static String LANTERNA_OPTION = "lanterna";
    public final static String SWING_OPTION = "swing";

    public final static double ANIMATION_DURATION = 0.5;

    public final static int FONT_SIZE = 48;
    public final static String LANTERNA_FONT = "Monospaced";

    public final static int SWING_SIZE_FACTOR = 60;

    private GlobalConfigs(){
        throw new AssertionError();
    }
}
