package com.epicness.dimentio.game.logic.bricks;

import static com.epicness.dimentio.game.constants.GameConstants.BRICK_BALL_SPEED;
import static com.epicness.dimentio.game.constants.GameConstants.PADDLE_TOP;
import static com.epicness.dimentio.game.constants.GameConstants.PLAYER_INNER_RADIUS;
import static com.epicness.dimentio.game.constants.GameConstants.WORLD_2D_BORDER_HEIGHT;
import static com.epicness.dimentio.game.constants.GameConstants.WORLD_2D_TOP;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;

public class BallMover extends GameLogicHandler {

    private Player player;
    private Rectangle paddle;
    private boolean enabled;
    private float angle;
    private float minX, maxX;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        paddle = stuff.getWorld2D().getBricksGame().getPaddle();
        enabled = false;
    }

    public void launchBall(float minX, float maxX) {
        this.minX = minX;
        this.maxX = maxX;
        angle = MathUtils.random(50f, 130f);
        enabled = true;
    }

    @Override
    protected void update(float delta) {
        if (!enabled) return;

        player.translateX(MathUtils.cosDeg(angle) * BRICK_BALL_SPEED * delta);
        player.translateY(MathUtils.sinDeg(angle) * BRICK_BALL_SPEED * delta);
        checkCollisions();
        checkBounds();
    }

    private void checkCollisions() {

    }

    private void checkBounds() {
        if (player.getY() + PLAYER_INNER_RADIUS > WORLD_2D_TOP) {
            player.setY(WORLD_2D_TOP - PLAYER_INNER_RADIUS);
            angle = 180f + (180f - angle);
        }
        if (player.getY() - PLAYER_INNER_RADIUS < PADDLE_TOP
            && player.getX() > paddle.x && player.getX() < paddle.x + paddle.width) {
            player.setY(PADDLE_TOP + PLAYER_INNER_RADIUS);
            angle = 180f + (180f - angle);
        }
        if (player.getY() + PLAYER_INNER_RADIUS < WORLD_2D_BORDER_HEIGHT) {
            loseLife();
        }
        if (player.getX() - PLAYER_INNER_RADIUS < minX) {
            player.setX(minX + PLAYER_INNER_RADIUS);
            angle = 270f + (270f - angle);
        }
        if (player.getX() + PLAYER_INNER_RADIUS > maxX) {
            player.setX(maxX - PLAYER_INNER_RADIUS);
            angle = 270f + (270f - angle);
        }
    }

    private void loseLife() {
        // TODO: 3/23/2024
    }

    public void disable() {
        enabled = false;
    }
}