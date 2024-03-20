package com.epicness.dimentio.game.logic.player;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.W;
import static com.epicness.dimentio.game.GameConstants.MAX_PLAYER_Y;
import static com.epicness.dimentio.game.GameConstants.MIN_PLAYER_Y;
import static com.epicness.dimentio.game.GameConstants.PLAYER_RADIUS;
import static com.epicness.dimentio.game.GameConstants.PLAYER_X_SPEED;
import static com.epicness.dimentio.game.GameConstants.PLAYER_Y_SPEED;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_HEIGHT;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;

public class MovementHandler extends GameLogicHandler {

    private Player player;
    private Vector2 aux;
    private boolean enabled;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        player.setY(CAMERA_HALF_HEIGHT - PLAYER_RADIUS);
        aux = new Vector2();
        enabled = true;
    }

    @Override
    protected void update(float delta) {
        if (!enabled) return;

        aux.set(player.getSpeed()).scl(delta);
        player.translate(aux);

        player.setY(MathUtils.clamp(player.getY(), MIN_PLAYER_Y, MAX_PLAYER_Y));
    }

    @Override
    public void keyDown(int keycode) {
        if (!enabled) return;

        switch (keycode) {
            case W:
                player.getSpeed().y += PLAYER_Y_SPEED;
                break;
            case A:
                player.getSpeed().x -= PLAYER_X_SPEED;
                break;
            case S:
                player.getSpeed().y -= PLAYER_Y_SPEED;
                break;
            case D:
                player.getSpeed().x += PLAYER_X_SPEED;
                break;
        }
    }

    @Override
    public void keyUp(int keycode) {
        if (!enabled) return;
        switch (keycode) {
            case W:
                player.getSpeed().y -= PLAYER_Y_SPEED;
                break;
            case A:
                player.getSpeed().x += PLAYER_X_SPEED;
                break;
            case S:
                player.getSpeed().y += PLAYER_Y_SPEED;
                break;
            case D:
                player.getSpeed().x -= PLAYER_X_SPEED;
                break;
        }
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}