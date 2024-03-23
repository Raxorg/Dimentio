package com.epicness.dimentio.game.logic.bricks;

import static com.badlogic.gdx.graphics.Color.BLUE;
import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.GREEN;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.badlogic.gdx.graphics.Color.YELLOW;
import static com.epicness.dimentio.game.constants.GameConstants.BLUE_START_X;
import static com.epicness.dimentio.game.constants.GameConstants.BRICKS_TOP_Y;
import static com.epicness.dimentio.game.constants.GameConstants.BRICK_COLUMNS;
import static com.epicness.dimentio.game.constants.GameConstants.BRICK_HEIGHT;
import static com.epicness.dimentio.game.constants.GameConstants.BRICK_ROWS;
import static com.epicness.dimentio.game.constants.GameConstants.BRICK_WIDTH;
import static com.epicness.dimentio.game.constants.GameConstants.BRICK_X_SPACING;
import static com.epicness.dimentio.game.constants.GameConstants.BRICK_Y_SPACING;
import static com.epicness.dimentio.game.constants.GameConstants.GREEN_START_X;
import static com.epicness.dimentio.game.constants.GameConstants.YELLOW_START_X;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.dimentio.game.constants.Level;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class BrickHandler extends GameLogicHandler {

    private SnapshotArray<Rectangle> bricks;
    private Color lerpColor, levelColor;
    private float progress;
    private boolean fadingIn;

    @Override
    protected void init() {
        bricks = stuff.getWorld2D().getBricksGame().getBricks();
        bricks.clear();
        lerpColor = new Color();
        levelColor = new Color();
        fadingIn = false;
    }

    public void spawnBricks(Level level) {
        switch (level) {
            case RED:
                spawnRedLevel();
                break;
            case GREEN:
                spawnGreenLevel();
                break;
            case BLUE:
                spawnBlueLevel();
                break;
            case YELLOW:
                spawnYellowLevel();
                break;
        }
        showBricks();
    }

    private void showBricks() {
        progress = 0f;
        fadingIn = true;
    }

    private void spawnRedLevel() {
        bricks.clear();
        levelColor.set(RED);
        float x, y;
        for (int column = 0; column < BRICK_COLUMNS; column++) {
            if (column % 2 == 0) continue;
            x = BRICK_X_SPACING + column * BRICK_WIDTH + BRICK_X_SPACING * column;
            for (int row = 0; row < BRICK_ROWS; row++) {
                if (row % 2 != 0) continue;
                y = BRICKS_TOP_Y - row * BRICK_HEIGHT - BRICK_Y_SPACING * row;
                Rectangle brick = new Rectangle(x, y, BRICK_WIDTH, BRICK_HEIGHT, levelColor, CLEAR);
                bricks.add(brick);
            }
        }
    }

    private void spawnGreenLevel() {
        bricks.clear();
        levelColor.set(GREEN);
        float x, y;
        for (int column = 0; column < BRICK_COLUMNS; column++) {
            x = GREEN_START_X + BRICK_X_SPACING + column * BRICK_WIDTH + BRICK_X_SPACING * column;
            for (int row = 0; row < BRICK_ROWS; row++) {
                if (column > 0 && column < BRICK_COLUMNS - 1 && row > 0 && row < BRICK_ROWS - 1 || row % 2 != 0) continue;
                y = BRICKS_TOP_Y - row * BRICK_HEIGHT - BRICK_Y_SPACING * row;
                Rectangle brick = new Rectangle(x, y, BRICK_WIDTH, BRICK_HEIGHT, levelColor, CLEAR);
                bricks.add(brick);
            }
        }
    }

    private void spawnBlueLevel() {
        bricks.clear();
        levelColor.set(BLUE);
        float x, y;
        for (int column = 0; column < BRICK_COLUMNS; column++) {
            x = BLUE_START_X + BRICK_X_SPACING + column * BRICK_WIDTH + BRICK_X_SPACING * column;
            for (int row = 0; row < BRICK_ROWS; row++) {
                if (column % 2 != row % 2) continue;
                y = BRICKS_TOP_Y - row * BRICK_HEIGHT - BRICK_Y_SPACING * row;
                Rectangle brick = new Rectangle(x, y, BRICK_WIDTH, BRICK_HEIGHT, levelColor, CLEAR);
                bricks.add(brick);
            }
        }
    }

    private void spawnYellowLevel() {
        bricks.clear();
        levelColor.set(YELLOW);
        float x, y;
        for (int column = 0; column < BRICK_COLUMNS; column++) {
            x = YELLOW_START_X + BRICK_X_SPACING + column * BRICK_WIDTH + BRICK_X_SPACING * column;
            for (int row = 0; row < BRICK_ROWS; row++) {
                y = BRICKS_TOP_Y - row * BRICK_HEIGHT - BRICK_Y_SPACING * row;
                Rectangle brick = new Rectangle(x, y, BRICK_WIDTH, BRICK_HEIGHT, levelColor, CLEAR);
                bricks.add(brick);
            }
        }
    }

    @Override
    protected void update(float delta) {
        if (!fadingIn) return;

        progress = Math.min(progress + delta * 0.75f, 1f);
        for (int i = 0; i < bricks.size; i++) {
            bricks.get(i).setBorderColor(lerpColor.set(CLEAR).lerp(levelColor, progress));
        }
        if (progress == 1f)
            fadingIn = false;
    }
}