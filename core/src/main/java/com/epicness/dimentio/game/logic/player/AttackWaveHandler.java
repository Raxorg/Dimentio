package com.epicness.dimentio.game.logic.player;

import static com.badlogic.gdx.graphics.Color.CLEAR;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class AttackWaveHandler extends GameLogicHandler {

    private Player player;
    private Circle playerAttack, playerAttackMirror;
    private boolean attacking;
    private float growthProgress;
    private Color auxColor;
    private Vector2 auxVector;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        playerAttack = stuff.getWorld2D().getPlayerAttack();
        playerAttackMirror = stuff.getWorld2D().getPlayerAttackMirror();
        attacking = false;
        growthProgress = 0f;
        auxColor = new Color();
        auxVector = new Vector2();
    }

    public void beginWave() {
        playerAttack.setPosition(player.getCenter(auxVector));
        playerAttackMirror.setPosition(player.getCenter(auxVector));
        growthProgress = 0f;
        attacking = true;
    }

    @Override
    protected void update(float delta) {
        if (!attacking) return;

        growAttack(delta);
    }

    private void growAttack(float delta) {
        growthProgress = Math.min(growthProgress + delta, 1f);

        auxColor.set(player.getBaseColor()).lerp(CLEAR, growthProgress);
        playerAttack.setBorderColor(auxColor);
        playerAttackMirror.setBorderColor(auxColor);
        playerAttack.setRadius(growthProgress * 250f);
        playerAttackMirror.setRadius(growthProgress * 250f);

        if (growthProgress == 1f) {
            attacking = false;
        }
    }
}