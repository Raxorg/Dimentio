package com.epicness.dimentio.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.epicness.dimentio.game.GameConstants.BORDER_HEIGHT;
import static com.epicness.dimentio.game.GameConstants.WORLD_WIDTH_2D;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.dimentio.game.assets.GameAssets;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Drawable2D;

import java.util.ArrayList;
import java.util.List;

public class World2D extends Drawable2D {

    private final Sprited topStripe, bottomStripe;
    private final SnapshotArray<Sprited> bricks;
    private final Player player, playerMirror;
    private final Circle playerAttack, playerAttackMirror;
    private final List<DualSprited> foliage;

    public World2D(SharedAssets sharedAssets, GameAssets assets) {
        topStripe = new Sprited(sharedAssets.getPixel());
        topStripe.setSize(WORLD_WIDTH_2D, BORDER_HEIGHT);
        topStripe.setY(CAMERA_HEIGHT - BORDER_HEIGHT);

        bottomStripe = new Sprited(sharedAssets.getPixel());
        bottomStripe.setSize(WORLD_WIDTH_2D, BORDER_HEIGHT);

        bricks = new SnapshotArray<>();

        player = new Player(assets.getFadedCircularGlow());
        playerMirror = new Player(assets.getFadedCircularGlow());

        playerAttack = new Circle(CLEAR);
        playerAttack.setThickness(5f);
        playerAttackMirror = new Circle(CLEAR);
        playerAttackMirror.setThickness(5f);

        foliage = new ArrayList<>();
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawerPlus) {
        player.draw(spriteBatch, shapeDrawerPlus);
        playerMirror.draw(spriteBatch, shapeDrawerPlus);
        for (int i = 0; i < bricks.size; i++) {
            bricks.get(i).draw(spriteBatch);
        }
        getPlayerAttack().draw(shapeDrawerPlus);
        topStripe.draw(spriteBatch);
        bottomStripe.draw(spriteBatch);
        for (int i = 0; i < foliage.size(); i++) {
            foliage.get(i).draw(spriteBatch);
        }
    }

    public SnapshotArray<Sprited> getBricks() {
        return bricks;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getPlayerMirror() {
        return playerMirror;
    }

    public Circle getPlayerAttack() {
        return playerAttack;
    }

    public List<DualSprited> getFoliage() {
        return foliage;
    }
}