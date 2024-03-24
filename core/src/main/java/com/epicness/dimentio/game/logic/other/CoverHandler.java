package com.epicness.dimentio.game.logic.other;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;

import com.badlogic.gdx.graphics.Color;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.fundamentals.stuff.Sprited;

public class CoverHandler extends GameLogicHandler {

    private Sprited cover;
    private Color lerpColor;
    private float progress;

    @Override
    protected void init() {
        cover = stuff.getWorld2D().getCover();
        cover.setColor(CLEAR);
        lerpColor = new Color();
        progress = 1f;
    }

    @Override
    protected void update(float delta) {
        progress = Math.min(progress + delta * 2f, 1f);
        cover.setColor(lerpColor.set(WHITE).lerp(CLEAR, progress));
    }

    public void showCover() {
        progress = 0f;
    }
}