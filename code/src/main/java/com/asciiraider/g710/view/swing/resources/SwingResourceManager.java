package com.asciiraider.g710.view.swing.resources;

public class SwingResourceManager {

    private SwingLevelResources levelResources;
    private SwingMenuResources menuResources;
    private SwingInfoBarResources infoBarResources;
    private SwingGameOverResources gameOverResources;

    private boolean loadedMenuResources;
    private boolean loadedLevelResources;
    private boolean loadedInfoBarResources;
    private boolean loadedGameOverResources;

    public SwingResourceManager() {
        this.levelResources = new SwingLevelResources();
        this.menuResources = new SwingMenuResources();
        this.infoBarResources = new SwingInfoBarResources();
        this.gameOverResources = new SwingGameOverResources();
    }

    public SwingLevelResources getLevelResources() {
        if (!loadedLevelResources) {
            levelResources.loadResources();
            loadedLevelResources = true;
        }
        return levelResources;
    }

    public SwingMenuResources getMenuResources() {
        if (!loadedMenuResources) {
            menuResources.loadResources();
            loadedMenuResources = true;
        }
        return menuResources;
    }

    public SwingInfoBarResources getInfoBarResources() {
        if (!loadedInfoBarResources) {
            infoBarResources.loadResources();
            loadedInfoBarResources = true;
        }
        return infoBarResources;
    }

    public SwingGameOverResources getGameOverResources() {
        if (!loadedGameOverResources) {
            gameOverResources.loadResources();
            loadedGameOverResources = true;
        }
        return gameOverResources;
    }
}
