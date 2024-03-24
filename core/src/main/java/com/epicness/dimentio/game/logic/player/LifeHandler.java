package com.epicness.dimentio.game.logic.player;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;

import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.logic.other.CoverHandler;
import com.epicness.fundamentals.stuff.DualSprited;

public class LifeHandler extends GameLogicHandler {

    private DualSprited[] lives;
    private int livesLeft;
    private boolean enabled;

    @Override
    protected void init() {
        lives = stuff.getLives();
        for (int i = 0; i < lives.length; i++) {
            lives[i].setBackgroundColor(WHITE);
            lives[i].setForegroundColor(BLACK);
        }
        livesLeft = 4;
        enabled = true;
    }

    public void loseLife() {
        if (!enabled) return;

        livesLeft--;
        lives[livesLeft].setColor(CLEAR);
        if (livesLeft == 0) {
            logic.initialLogic();
        }
        logic.get(CoverHandler.class).showCover();
    }

    public void gainLives() {
        if (livesLeft == 4) return;

        lives[livesLeft].setBackgroundColor(WHITE);
        lives[livesLeft].setForegroundColor(BLACK);
        livesLeft++;
    }

    public void disable() {
        enabled = false;
    }
}