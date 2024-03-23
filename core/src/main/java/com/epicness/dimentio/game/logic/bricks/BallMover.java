package com.epicness.dimentio.game.logic.bricks;

import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;

public class BallMover extends GameLogicHandler {

    private Player player;
    private boolean enabled;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        enabled = false;
    }

    @Override
    protected void update(float delta) {
        if (!enabled) return;


    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}