package com.epicness.dimentio.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.WHITE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.dimentio.game.assets.GameAssets;
import com.epicness.dimentio.game.constants.Level;
import com.epicness.fundamentals.stuff.DualSprited;

public class Activator {

    private final DualSprited inner, mid, outer;
    private final Color normalColor, glowColor;
    private boolean activated;
    private float speedFactor;
    public final Level level;

    public Activator(GameAssets assets, Color color, Level level) {
        glowColor = new Color(color);
        normalColor = new Color(color).lerp(WHITE, 0.35f);

        inner = new DualSprited(assets.getActivator1Glow(), assets.getActivator1());
        inner.setOriginCenter();
        inner.setBackgroundColor(glowColor);
        inner.setForegroundColor(normalColor);

        mid = new DualSprited(assets.getActivator2Glow(), assets.getActivator2());
        mid.setOriginCenter();
        mid.setBackgroundColor(glowColor);
        mid.setForegroundColor(normalColor);

        outer = new DualSprited(assets.getActivator3Glow(), assets.getActivator3());
        outer.setOriginCenter();
        outer.setBackgroundColor(glowColor);
        outer.setForegroundColor(normalColor);

        this.level = level;
    }

    public void draw(SpriteBatch spriteBatch) {
        inner.draw(spriteBatch);
        mid.draw(spriteBatch);
        outer.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        inner.setPosition(x, y);
        mid.setPosition(x, y);
        outer.setPosition(x, y);
    }

    public void setAlpha(float alpha) {
        normalColor.a = alpha;
        glowColor.a = alpha;
        inner.setBackgroundColor(glowColor);
        inner.setForegroundColor(normalColor);
        mid.setBackgroundColor(glowColor);
        mid.setForegroundColor(normalColor);
        outer.setBackgroundColor(glowColor);
        outer.setForegroundColor(normalColor);
    }

    public DualSprited getInner() {
        return inner;
    }

    public DualSprited getMid() {
        return mid;
    }

    public DualSprited getOuter() {
        return outer;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public float getSpeedFactor() {
        return speedFactor;
    }

    public void setSpeedFactor(float speedFactor) {
        this.speedFactor = speedFactor;
    }
}