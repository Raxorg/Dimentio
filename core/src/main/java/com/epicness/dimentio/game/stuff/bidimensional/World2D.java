package com.epicness.dimentio.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.epicness.dimentio.game.constants.GameConstants.WORLD_2D_BORDER_HEIGHT;
import static com.epicness.dimentio.game.constants.GameConstants.WORLD_2D_WIDTH;
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

    private final Sprited topStripe, bottomStripe;// TODO: Color stripes according to level
    private final BricksGame bricksGame;
    private final Player player, playerMirror;
    private final Circle playerAttack, playerAttackMirror;
    private final SnapshotArray<Enemy> enemies, enemyMirrors;
    private final Circle[] enemySpawnCircles;
    private final List<DualSprited> foliage;

    public World2D(SharedAssets sharedAssets, GameAssets assets) {
        topStripe = new Sprited(sharedAssets.getPixel());
        topStripe.setSize(WORLD_2D_WIDTH, WORLD_2D_BORDER_HEIGHT);
        topStripe.setY(CAMERA_HEIGHT - WORLD_2D_BORDER_HEIGHT);

        bottomStripe = new Sprited(sharedAssets.getPixel());
        bottomStripe.setSize(WORLD_2D_WIDTH, WORLD_2D_BORDER_HEIGHT);

        bricksGame = new BricksGame(sharedAssets.getPixelFont(), assets);

        player = new Player(assets.getFadedCircularGlow());
        playerMirror = new Player(assets.getFadedCircularGlow());

        playerAttack = new Circle(CLEAR);
        playerAttack.setThickness(5f);
        playerAttackMirror = new Circle(CLEAR);
        playerAttackMirror.setThickness(5f);

        enemies = new SnapshotArray<>();
        enemyMirrors = new SnapshotArray<>();
        enemySpawnCircles = new Circle[3];
        for (int i = 0; i < enemySpawnCircles.length; i++) {
            enemySpawnCircles[i] = new Circle(CLEAR);
            enemySpawnCircles[i].setThickness(5f);
        }
        foliage = new ArrayList<>();
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawerPlus) {
        bricksGame.draw(spriteBatch, shapeDrawerPlus);
        player.draw(spriteBatch, shapeDrawerPlus);
        playerMirror.draw(spriteBatch, shapeDrawerPlus);
        playerAttack.draw(shapeDrawerPlus);
        playerAttackMirror.draw(shapeDrawerPlus);
        for (int i = 0; i < enemies.size; i++) {
            enemies.get(i).draw(spriteBatch);
            enemyMirrors.get(i).draw(spriteBatch);
        }
        for (int i = 0; i < enemySpawnCircles.length; i++) {
            enemySpawnCircles[i].draw(shapeDrawerPlus);
        }
        topStripe.draw(spriteBatch);
        bottomStripe.draw(spriteBatch);
        for (int i = 0; i < foliage.size(); i++) {
            foliage.get(i).draw(spriteBatch);
        }
    }

    public BricksGame getBricksGame() {
        return bricksGame;
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

    public Circle getPlayerAttackMirror() {
        return playerAttackMirror;
    }

    public SnapshotArray<Enemy> getEnemies() {
        return enemies;
    }

    public SnapshotArray<Enemy> getEnemyMirrors() {
        return enemyMirrors;
    }

    public Circle[] getEnemySpawnCircles() {
        return enemySpawnCircles;
    }

    public List<DualSprited> getFoliage() {
        return foliage;
    }
}