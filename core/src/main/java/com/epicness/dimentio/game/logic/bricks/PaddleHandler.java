package com.epicness.dimentio.game.logic.bricks;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.SPACE;
import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.dimentio.game.constants.GameConstants.PADDLE_SPEED;
import static com.epicness.dimentio.game.constants.GameConstants.PADDLE_WIDTH;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.logic.player.AttackCooldownHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class PaddleHandler extends GameLogicHandler {

    private Rectangle paddle;
    private Player player;
    private float paddleSpeed, minX, maxX;
    private float fadeProgress;
    private Color lerpColor;
    private boolean fading, fadingIn, movementEnabled, attached;

    @Override
    protected void init() {
        paddle = stuff.getWorld2D().getBricksGame().getPaddle();
        paddle.setBorderColor(CLEAR);
        player = stuff.getWorld2D().getPlayer();
        paddleSpeed = 0f;
        fadeProgress = 0f;
        lerpColor = new Color();
        fading = false;
        fadingIn = true;
        movementEnabled = false;
        attached = false;
    }

    public void showPaddle(float x) {
        minX = x - CAMERA_HALF_WIDTH;
        maxX = x + CAMERA_HALF_WIDTH;
        paddle.setX(x - PADDLE_WIDTH / 2f);
        fadeProgress = 0f;
        fading = true;
        fadingIn = true;
    }

    public void hidePaddle() {
        fadeProgress = 0f;
        fading = true;
        fadingIn = false;
        attached = false;
    }

    @Override
    protected void update(float delta) {
        handlePaddleFading(delta);
        handlePaddleMovement(delta);
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
            attached = movementEnabled;
        }
    }

    private void handlePaddleMovement(float delta) {
        if (!movementEnabled) return;

        paddleSpeed = 0f;
        if (Gdx.input.isKeyPressed(A) || Gdx.input.isKeyPressed(LEFT))
            paddleSpeed -= PADDLE_SPEED;
        if (Gdx.input.isKeyPressed(D) || Gdx.input.isKeyPressed(RIGHT))
            paddleSpeed += PADDLE_SPEED;
        paddle.x = MathUtils.clamp(paddle.x + paddleSpeed * delta, minX, maxX - PADDLE_WIDTH);
        if (attached) player.setX(paddle.x + paddle.width / 2f);
    }

    @Override
    public void keyDown(int keycode) {
        if (keycode == SPACE && !logic.get(AttackCooldownHandler.class).isOnCooldown() && movementEnabled && attached) {
            attached = false;
            logic.get(BallMover.class).launchBall(minX, maxX);
        }
    }
}