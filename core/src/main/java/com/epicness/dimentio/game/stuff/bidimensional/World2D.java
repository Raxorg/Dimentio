package com.epicness.dimentio.game.stuff.bidimensional;

import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;
import static com.epicness.fundamentals.constants.SharedConstants.WHITE_CLEAR_50;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Drawable2D;

public class World2D extends Drawable2D {

    private final Sprited background;
    private final Player player, playerMirror;

    public World2D(SharedAssets sharedAssets) {
        background = new Sprited(sharedAssets.getPixel());
        background.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
        background.setColor(WHITE_CLEAR_50);

        player = new Player(sharedAssets.getGlow());
        playerMirror = new Player(sharedAssets.getGlow());
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawerPlus) {
        background.draw(spriteBatch);
        player.draw(spriteBatch, shapeDrawerPlus);
        playerMirror.draw(spriteBatch, shapeDrawerPlus);
    }

    public Player getPlayer() {
        return player;
    }

    public Player getPlayerMirror() {
        return playerMirror;
    }
}