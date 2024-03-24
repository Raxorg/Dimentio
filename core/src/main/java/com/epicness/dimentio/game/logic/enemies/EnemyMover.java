package com.epicness.dimentio.game.logic.enemies;

import static com.epicness.dimentio.game.constants.GameConstants.ENEMY_SPEED;
import static com.epicness.dimentio.game.constants.GameConstants.WORLD_2D_WIDTH;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Enemy;
import com.epicness.dimentio.game.stuff.bidimensional.Player;
import com.epicness.fundamentals.utils.AngleUtils;

public class EnemyMover extends GameLogicHandler {

    private Array<Enemy> enemies, enemyMirrors;
    private Player player, playerMirror;
    private Vector2 enemyCenter, playerCenter, playerMirrorCenter;

    @Override
    protected void init() {
        enemies = stuff.getWorld2D().getEnemies();
        enemyMirrors = stuff.getWorld2D().getEnemyMirrors();
        player = stuff.getWorld2D().getPlayer();
        playerMirror = stuff.getWorld2D().getPlayerMirror();
        enemyCenter = new Vector2();
        playerCenter = new Vector2();
        playerMirrorCenter = new Vector2();
    }

    @Override
    protected void update(float delta) {
        Enemy enemy, mirror;
        float degrees;
        for (int i = 0; i < enemies.size; i++) {
            enemy = enemies.get(i);
            mirror = enemyMirrors.get(i);

            enemy.getAnimation().addTime(delta);
            mirror.getAnimation().addTime(delta);
            enemy.getCenter(enemyCenter);
            player.getCenter(playerCenter);
            playerMirror.getCenter(playerMirrorCenter);

            degrees = AngleUtils.degreesBetweenPoints(playerCenter, enemyCenter);
            if (enemyCenter.dst(playerCenter) > WORLD_2D_WIDTH / 2f) degrees += 180f;
            enemy.setRotation(degrees);
            mirror.setRotation(degrees);
            enemy.setFlipY(Math.abs(degrees) >= 90f);
            mirror.setFlipY(Math.abs(degrees) >= 90f);
            enemy.translate(MathUtils.cosDeg(degrees) * ENEMY_SPEED * delta, MathUtils.sinDeg(degrees) * ENEMY_SPEED * delta);
            mirror.translate(MathUtils.cosDeg(degrees) * ENEMY_SPEED * delta, MathUtils.sinDeg(degrees) * ENEMY_SPEED * delta);
        }
        logic.get(EnemyCollisionHandler.class).checkCollisions();
    }
}