package com.epicness.dimentio.game.logic.bricks;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.dimentio.game.constants.GameConstants.PADDLE_SPEED;
import static com.epicness.dimentio.game.constants.GameConstants.PADDLE_TOP;
import static com.epicness.dimentio.game.constants.GameConstants.PADDLE_WIDTH;
import static com.epicness.dimentio.game.constants.GameConstants.PLAYER_INNER_RADIUS;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class PaddleHandler extends GameLogicHandler {

    private Player player;
    private Rectangle paddle;
    private float paddleSpeed, minX, maxX;
    private float fadeProgress;
    private Color lerpColor;
    private boolean fading, fadingIn, movementEnabled;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        paddle = stuff.getWorld2D().getBricksGame().getPaddle();
        paddle.setBorderColor(CLEAR);
        paddleSpeed = 0f;
        fadeProgress = 0f;
        lerpColor = new Color();
        fading = false;
        fadingIn = true;
        movementEnabled = false;
    }

    public void showPaddle(float playerCenterX) {
        minX = playerCenterX - CAMERA_HALF_WIDTH;
        maxX = playerCenterX + CAMERA_HALF_WIDTH;
        paddle.setX(playerCenterX - PADDLE_WIDTH / 2f);
        fadeProgress = 0f;
        fading = true;
        fadingIn = true;
    }

    public void hidePaddle() {
        fadeProgress = 0f;
        fading = true;
        fadingIn = false;
    }

    @Override
    protected void update(float delta) {
        handlePaddleFading(delta);
        handleMovement(delta);

        if (player.getY() - PLAYER_INNER_RADIUS < PADDLE_TOP
            && player.getX() > paddle.x && player.getX() < paddle.x + paddle.width) {
            System.out.println("ASD");
            player.setY(PADDLE_TOP + PLAYER_INNER_RADIUS);
            player.getSpeed().setAngleDeg(180f + (180f - player.getSpeed().angleDeg()));
        }
    }

    private void handlePaddleFading(float delta) {
        if (!fading) return;

        fadeProgress = Math.min(fadeProgress + delta * 0.75f, 1f);
        if (fadingIn) {
            lerpColor.set(CLEAR).lerp(WHITE, fadeProgress);
        } else {
            lerpColor.set(WHITE).lerp(CLEAR, fadeProgress);
        }
        paddle.setBorderColor(lerpColor);
        if (fadeProgress == 1f) {
            fading = false;
            movementEnabled = fadingIn;
            if (fadingIn)
                logic.get(BallMover.class).attachToPaddle();
        }
    }

    private void handleMovement(float delta) {
        if (!movementEnabled) return;

        paddleSpeed = 0f;
        if (Gdx.input.isKeyPressed(A) || Gdx.input.isKeyPressed(LEFT))
            paddleSpeed -= PADDLE_SPEED;
        if (Gdx.input.isKeyPressed(D) || Gdx.input.isKeyPressed(RIGHT))
            paddleSpeed += PADDLE_SPEED;
        paddle.x = MathUtils.clamp(paddle.x + paddleSpeed * delta, minX, maxX - PADDLE_WIDTH);
    }

    public boolean isMovementEnabled() {
        return movementEnabled;
    }
}