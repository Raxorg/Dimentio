package com.epicness.dimentio.game.logic.player;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.UP;
import static com.badlogic.gdx.Input.Keys.W;
import static com.epicness.dimentio.game.constants.GameConstants.MAX_PLAYER_Y;
import static com.epicness.dimentio.game.constants.GameConstants.MIN_PLAYER_Y;
import static com.epicness.dimentio.game.constants.GameConstants.PLAYER_RADIUS;
import static com.epicness.dimentio.game.constants.GameConstants.PLAYER_X_SPEED;
import static com.epicness.dimentio.game.constants.GameConstants.PLAYER_Y_SPEED;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_HEIGHT;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;

public class PlayerMover extends GameLogicHandler {

    private Player player;
    private boolean enabled;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        player.setPosition(0f, CAMERA_HALF_HEIGHT - PLAYER_RADIUS);
        enabled = true;
    }

    @Override
    protected void update(float delta) {
        if (!enabled) return;

        handleMovement(delta);
    }

    private void handleMovement(float delta) {
        player.getSpeed().setZero();
        if (Gdx.input.isKeyPressed(W) || Gdx.input.isKeyPressed(UP))
            player.getSpeed().y += PLAYER_Y_SPEED;
        if (Gdx.input.isKeyPressed(A) || Gdx.input.isKeyPressed(LEFT))
            player.getSpeed().x -= PLAYER_X_SPEED;
        if (Gdx.input.isKeyPressed(S) || Gdx.input.isKeyPressed(DOWN))
            player.getSpeed().y -= PLAYER_Y_SPEED;
        if (Gdx.input.isKeyPressed(D) || Gdx.input.isKeyPressed(RIGHT))
            player.getSpeed().x += PLAYER_X_SPEED;

        player.getSpeed().scl(delta);
        player.translate(player.getSpeed());

        player.setY(MathUtils.clamp(player.getY(), MIN_PLAYER_Y, MAX_PLAYER_Y));
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}