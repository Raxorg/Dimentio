package com.epicness.dimentio.game.logic.player;

import static com.badlogic.gdx.Input.Keys.SPACE;
import static com.badlogic.gdx.graphics.Color.CLEAR;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class AttackHandler extends GameLogicHandler {

    private Player player;
    private Circle playerAttack;
    private boolean attacking;
    private float growthProgress;
    private Color auxColor;
    private Vector2 auxVector;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        playerAttack = stuff.getWorld2D().getPlayerAttack();
        attacking = false;
        growthProgress = 0f;
        auxColor = new Color();
        auxVector = new Vector2();
    }

    @Override
    protected void update(float delta) {
        if (!attacking) return;

        playerAttack.setPosition(player.getCenter(auxVector));
        growAttack(delta);
        checkCollisions();
    }

    private void growAttack(float delta) {
        growthProgress = Math.min(growthProgress + delta, 1f);

        auxColor.set(player.getBaseColor()).lerp(CLEAR, growthProgress);
        playerAttack.setBorderColor(auxColor);
        playerAttack.setRadius(growthProgress * 200f);

        if (growthProgress == 1f) {
            attacking = false;
        }
    }

    private void checkCollisions() {

    }

    @Override
    public void keyDown(int keycode) {
        if (keycode == SPACE) {
            growthProgress = 0f;
            attacking = true;
        }
    }
}