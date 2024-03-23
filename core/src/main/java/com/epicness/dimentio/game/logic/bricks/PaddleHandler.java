package com.epicness.dimentio.game.logic.bricks;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.dimentio.game.GameConstants.PADDLE_SPEED;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class PaddleHandler extends GameLogicHandler {

    private Rectangle paddle;
    private float paddleSpeed;
    private float fadeProgress;
    private Color lerpColor;
    private boolean fading, fadingIn, movementEnabled;

    @Override
    protected void init() {
        paddle = stuff.getWorld2D().getBricksGame().getPaddle();
        paddle.setBorderColor(CLEAR);
        paddleSpeed = 0f;
        fadeProgress = 0f;
        lerpColor = new Color();
        fading = false;
        fadingIn = true;
        movementEnabled = false;
    }

    public void showPaddle(float x) {
        paddle.setX(x);
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
        }
    }

    private void handlePaddleMovement(float delta) {
        if (!movementEnabled) return;

        paddleSpeed = 0f;
        if (Gdx.input.isKeyPressed(A) || Gdx.input.isKeyPressed(LEFT))
            paddleSpeed -= PADDLE_SPEED;
        if (Gdx.input.isKeyPressed(D) || Gdx.input.isKeyPressed(RIGHT))
            paddleSpeed += PADDLE_SPEED;
        paddle.x += paddleSpeed * delta;
    }
}