package com.epicness.dimentio.game.logic.enemies;

import com.badlogic.gdx.utils.Array;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Enemy;

public class EnemyMover extends GameLogicHandler {

    private Array<Enemy> enemies;

    @Override
    protected void init() {
        enemies = stuff.getWorld2D().getEnemies();
    }

    @Override
    protected void update(float delta) {
        Enemy enemy;
        for (int i = 0; i < enemies.size; i++) {
            enemy = enemies.get(i);
        }
    }
}