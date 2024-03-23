package com.epicness.dimentio.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.dimentio.game.constants.GameConstants.ACTIVATOR_COLORS;
import static com.epicness.dimentio.game.constants.GameConstants.ACTIVATOR_SIZE;
import static com.epicness.dimentio.game.constants.GameConstants.ACTIVATOR_Y;
import static com.epicness.dimentio.game.constants.GameConstants.WORLD_2D_BORDER_HEIGHT;
import static com.epicness.dimentio.game.constants.GameConstants.LEVELS;
import static com.epicness.dimentio.game.constants.GameConstants.PADDLE_HEIGHT;
import static com.epicness.dimentio.game.constants.GameConstants.PADDLE_WIDTH;
import static com.epicness.dimentio.game.constants.GameConstants.PADDLE_Y;
import static com.epicness.dimentio.game.constants.GameConstants.WORLD_2D_WIDTH;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.dimentio.game.assets.GameAssets;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Line;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class BricksGame {

    private final Activator[] activators;
    private final SnapshotArray<Rectangle> bricks;
    private final Rectangle paddle;
    private final Line leftLimit, rightLimit;
    private final Text levelText;

    public BricksGame(BitmapFont font, GameAssets assets) {
        activators = new Activator[4];
        for (int i = 0; i < 4; i++) {
            activators[i] = new Activator(assets, ACTIVATOR_COLORS[i], LEVELS[i]);
            activators[i].setPosition(CAMERA_WIDTH * i * 2f + CAMERA_HALF_WIDTH - ACTIVATOR_SIZE / 2f, ACTIVATOR_Y);
        }
        bricks = new SnapshotArray<>();
        paddle = new Rectangle(0f, PADDLE_Y, PADDLE_WIDTH, PADDLE_HEIGHT, WHITE, CLEAR);
        leftLimit = new Line(WORLD_2D_WIDTH - 2.5f, WORLD_2D_BORDER_HEIGHT, WORLD_2D_WIDTH - 2.5f, CAMERA_HEIGHT - WORLD_2D_BORDER_HEIGHT);
        rightLimit = new Line(CAMERA_WIDTH + 2.5f, WORLD_2D_BORDER_HEIGHT, CAMERA_WIDTH + 2.5f, CAMERA_HEIGHT - WORLD_2D_BORDER_HEIGHT);
        levelText = new Text(font);
    }

    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {
        for (int i = 0; i < activators.length; i++) {
            activators[i].draw(spriteBatch);
        }
        for (int i = 0; i < bricks.size; i++) {
            bricks.get(i).draw(shapeDrawer);
        }
        paddle.drawBorder(shapeDrawer);
        leftLimit.draw(shapeDrawer);
        rightLimit.draw(shapeDrawer);
        levelText.draw(spriteBatch);
    }

    public SnapshotArray<Rectangle> getBricks() {
        return bricks;
    }

    public Rectangle getPaddle() {
        return paddle;
    }

    public Text getLevelText() {
        return levelText;
    }

    public Activator[] getActivators() {
        return activators;
    }
}