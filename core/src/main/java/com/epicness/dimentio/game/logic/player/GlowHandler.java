package com.epicness.dimentio.game.logic.player;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;

public class GlowHandler extends GameLogicHandler {

    private Player player, mirror;
    private float progress;
    private Color color;
    private boolean fadingIn;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        mirror = stuff.getWorld2D().getPlayerMirror();
        player.setColor(WHITE);
        mirror.setColor(WHITE);
        progress = 0f;
        color = new Color();
    }

    @Override
    protected void update(float delta) {
        if (progress == 0f) fadingIn = true;
        if (progress == 1f) fadingIn = false;

        progress = MathUtils.clamp(progress + (fadingIn ? delta / 0.5f : -delta / 0.5f), 0f, 1f);
        color.set(WHITE).lerp(CLEAR, Interpolation.exp10In.apply(progress));
        player.setColor(color);
        mirror.setColor(color);
    }
}