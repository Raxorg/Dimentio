package com.epicness.dimentio.game.logic.bricks;

import com.epicness.dimentio.game.logic.GameLogicHandler;

public class PaddleHandler extends GameLogicHandler {

    private boolean enabled;

    @Override
    protected void init() {

    }

    @Override
    protected void update(float delta) {
        if (!enabled) return;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}