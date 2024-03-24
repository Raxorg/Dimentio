package com.epicness.dimentio.game.logic.other;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;

import com.badlogic.gdx.graphics.Color;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.logic.player.LifeHandler;
import com.epicness.dimentio.game.logic.player.MirrorHandler;
import com.epicness.fundamentals.stuff.Sprited;

public class EndingHandler extends GameLogicHandler {

    private Sprited ending, mirror;
    private float alpha;
    private Color lerpColor;
    private boolean enabled;
    private int completedLevels;

    @Override
    protected void init() {
        ending = stuff.getWorld2D().getEnding();
        ending.setColor(CLEAR);
        mirror = stuff.getWorld2D().getEndingMirror();
        mirror.setColor(CLEAR);
        logic.get(MirrorHandler.class).registerTransformablePair(ending, mirror);

        alpha = 0f;
        lerpColor = new Color();
        enabled = false;
        completedLevels = 0;
    }

    @Override
    protected void update(float delta) {
        if (!enabled) return;

        alpha = Math.min(alpha + delta, 1f);
        lerpColor.set(CLEAR).lerp(WHITE, alpha);
        ending.setColor(lerpColor);
        mirror.setColor(lerpColor);

        ending.translateX(500f * delta);
        mirror.translateX(500f * delta);
    }

    public void completeLevel() {
        completedLevels++;
        if (completedLevels == 4) {
            enabled = true;
            logic.get(LifeHandler.class).disable();
        }
    }
}