package com.epicness.dimentio.game.stuff.bidimensional;

import static com.epicness.dimentio.game.GameConstants.ACTIVATOR_COLORS;
import static com.epicness.dimentio.game.GameConstants.ACTIVATOR_SIZE;
import static com.epicness.dimentio.game.GameConstants.ACTIVATOR_Y;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.dimentio.game.assets.GameAssets;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class BricksGame {

    private final Activator[] activators;
    private final SnapshotArray<Rectangle> bricks;
    private final Text levelText;

    public BricksGame(BitmapFont font, GameAssets assets) {
        bricks = new SnapshotArray<>();
        levelText = new Text(font);
        activators = new Activator[4];
        for (int i = 0; i < 4; i++) {
            activators[i] = new Activator(assets, ACTIVATOR_COLORS[i]);
            activators[i].setPosition(CAMERA_WIDTH * i * 2f + CAMERA_HALF_WIDTH - ACTIVATOR_SIZE / 2f, ACTIVATOR_Y);
        }
    }

    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {
        for (int i = 0; i < activators.length; i++) {
            activators[i].draw(spriteBatch);
        }
        for (int i = 0; i < bricks.size; i++) {
            bricks.get(i).draw(shapeDrawer);
        }
        levelText.draw(spriteBatch);
    }

    public SnapshotArray<Rectangle> getBricks() {
        return bricks;
    }

    public Text getLevelText() {
        return levelText;
    }

    public Activator[] getActivators() {
        return activators;
    }
}