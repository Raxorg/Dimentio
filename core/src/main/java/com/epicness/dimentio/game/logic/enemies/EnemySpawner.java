package com.epicness.dimentio.game.logic.enemies;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.dimentio.game.constants.GameConstants.ENEMY_SIZE;
import static com.epicness.dimentio.game.constants.GameConstants.ENEMY_SPAWN_INTERVAL;
import static com.epicness.dimentio.game.constants.GameConstants.ENEMY_SPAWN_Y;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.logic.player.MirrorHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Enemy;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class EnemySpawner extends GameLogicHandler {

    private Array<Enemy> enemies, enemyMirrors;
    private Circle[] enemySpawnCircles;
    private boolean showingEffect;
    private float spawnTime, effectTime;
    private float spawnX;
    private Color auxColor;

    @Override
    protected void init() {
        enemies = stuff.getWorld2D().getEnemies();
        enemyMirrors = stuff.getWorld2D().getEnemyMirrors();
        enemySpawnCircles = stuff.getWorld2D().getEnemySpawnCircles();
        spawnTime = effectTime = 0f;
        auxColor = new Color();
    }

    @Override
    protected void update(float delta) {
        spawnTime += delta;
        if (spawnTime >= ENEMY_SPAWN_INTERVAL) {
            spawnEnemy();
            spawnTime = 0f;
        }

        if (!showingEffect) return;
        handleSpawningEffect(delta);
    }

    private void spawnEnemy() {
        spawnX = MathUtils.random(3) * CAMERA_WIDTH * 2f + CAMERA_WIDTH * 1.5f - ENEMY_SIZE / 2f;

        Enemy enemy = new Enemy(assets.getEnemyAnimFrames());
        Enemy mirror = new Enemy(assets.getEnemyAnimFrames());
        enemy.setPosition(spawnX, ENEMY_SPAWN_Y);
        mirror.setPosition(spawnX, ENEMY_SPAWN_Y);
        enemies.add(enemy);
        enemyMirrors.add(mirror);
        logic.get(MirrorHandler.class).registerTransformablePair(enemy, mirror);

        effectTime = 0f;
        for (int i = 0; i < enemySpawnCircles.length; i++) {
            enemySpawnCircles[i].setBorderColor(CLEAR);
        }
        showingEffect = true;
    }

    private void handleSpawningEffect(float delta) {
        effectTime = Math.min(effectTime + delta, 1f);
        Circle circle;
        auxColor.set(WHITE).lerp(CLEAR, Interpolation.circle.apply(effectTime));
        for (int i = 0; i < enemySpawnCircles.length; i++) {
            circle = enemySpawnCircles[i];
            circle.setPosition(spawnX + ENEMY_SIZE / 2f, ENEMY_SPAWN_Y + ENEMY_SIZE / 2f);
            circle.setRadius(MathUtils.lerp(ENEMY_SIZE / 2f, ENEMY_SIZE * (i + 1), effectTime));
            circle.setBorderColor(auxColor);
        }
    }
}