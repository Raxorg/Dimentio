package com.epicness.dimentio.game.stuff.bidimensional;

import static com.epicness.dimentio.game.GameConstants.WORLD_WIDTH_2D;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.dimentio.game.assets.GameAssets;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Drawable2D;

public class World2D extends Drawable2D {

    private final Sprited topStripe, bottomStripe;
    private final Player player, playerMirror;

    public World2D(SharedAssets sharedAssets, GameAssets assets) {
        topStripe = new Sprited(sharedAssets.getPixel());
        topStripe.setSize(WORLD_WIDTH_2D, 10f);
        topStripe.setY(CAMERA_HEIGHT - 10f);

        bottomStripe = new Sprited(sharedAssets.getPixel());
        bottomStripe.setSize(WORLD_WIDTH_2D, 10f);

        player = new Player(assets.getFadedCircularGlow());
        playerMirror = new Player(assets.getFadedCircularGlow());
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawerPlus) {
        player.draw(spriteBatch, shapeDrawerPlus);
        playerMirror.draw(spriteBatch, shapeDrawerPlus);
        topStripe.draw(spriteBatch);
        bottomStripe.draw(spriteBatch);
    }

    public Player getPlayer() {
        return player;
    }

    public Player getPlayerMirror() {
        return playerMirror;
    }
}