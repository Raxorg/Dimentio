package com.epicness.dimentio.game.logic.player;

import static com.badlogic.gdx.Input.Keys.SPACE;
import static com.badlogic.gdx.graphics.Color.BLACK;

import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.logic.bricks.ActivationHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;

public class AttackCooldownHandler extends GameLogicHandler {

    private Player player, mirror;
    private float cooldown;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        mirror = stuff.getWorld2D().getPlayerMirror();
        cooldown = 0f;
    }

    @Override
    protected void update(float delta) {
        cooldown -= delta;
        player.setCircleColor(cooldown <= 0f ? player.getBaseColor() : BLACK);
        mirror.setCircleColor(cooldown <= 0f ? player.getBaseColor() : BLACK);
    }

    @Override
    public void keyDown(int keycode) {
        if (cooldown > 0f) return;

        if (keycode == SPACE) {
            logic.get(ActivationHandler.class).checkActivation();
            logic.get(AttackWaveHandler.class).beginWave();
            sharedAssets.getShortLaser().play();
            cooldown = 2f;
        }
    }
}