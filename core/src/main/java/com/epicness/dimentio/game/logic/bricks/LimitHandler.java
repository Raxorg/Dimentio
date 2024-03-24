package com.epicness.dimentio.game.logic.bricks;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Line;

public class LimitHandler extends GameLogicHandler {

    private Line leftLimit, rightLimit;

    @Override
    protected void init() {
        leftLimit = stuff.getWorld2D().getBricksGame().getLeftLimit();
        leftLimit.setColor(CLEAR);
        rightLimit = stuff.getWorld2D().getBricksGame().getRightLimit();
        rightLimit.setColor(CLEAR);
    }

    public void showLimits(float centerX, Color color) {
        leftLimit.setX(centerX - CAMERA_HALF_WIDTH);
        rightLimit.setX(centerX + CAMERA_HALF_WIDTH);
        leftLimit.setColor(color);
        rightLimit.setColor(color);
    }

    public void hideLimits() {
        leftLimit.setColor(CLEAR);
        rightLimit.setColor(CLEAR);
    }
}