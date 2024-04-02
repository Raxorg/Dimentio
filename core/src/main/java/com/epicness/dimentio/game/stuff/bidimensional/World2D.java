package com.epicness.dimentio.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.CLEAR;
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

public class World2D implements Drawable2D {

    private final Border border;
    private final BricksGame bricksGame;
    private final Player player, playerMirror;
    private final Circle playerAttack, playerAttackMirror;
    private final SnapshotArray<Enemy> enemies, enemyMirrors;
    private final Circle[] enemySpawnCircles;
    private final List<DualSprited> foliage;
    private final Sprited ending, endingMirror, cover;

    public World2D(SharedAssets sharedAssets, GameAssets assets) {
        border = new Border();
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

        ending = new Sprited(assets.getEnding());
        endingMirror = new Sprited(assets.getEnding());

        cover = new Sprited(sharedAssets.getPixel());
        cover.setSize(WORLD_2D_WIDTH, CAMERA_HEIGHT);
        cover.setColor(CLEAR);
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawerPlus) {
        ending.draw(spriteBatch);
        endingMirror.draw(spriteBatch);
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
        border.draw(shapeDrawerPlus);
        for (int i = 0; i < foliage.size(); i++) {
            foliage.get(i).draw(spriteBatch);
        }
        cover.draw(spriteBatch);
    }

    public Sprited getEnding() {
        return ending;
    }

    public Sprited getEndingMirror() {
        return endingMirror;
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

    public Sprited getCover() {
        return cover;
    }
}