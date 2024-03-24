package com.epicness.dimentio.game.logic.enemies;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.logic.player.LifeHandler;
import com.epicness.dimentio.game.logic.player.MirrorHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Enemy;
import com.epicness.dimentio.game.stuff.bidimensional.Player;

public class EnemyCollisionHandler extends GameLogicHandler {

    private SnapshotArray<Enemy> enemies, enemyMirrors;
    private Player player;

    @Override
    protected void init() {
        enemies = stuff.getWorld2D().getEnemies();
        enemyMirrors = stuff.getWorld2D().getEnemyMirrors();
        player = stuff.getWorld2D().getPlayer();
    }

    public void checkCollisions() {
        Enemy enemy, mirror;
        enemies.begin();
        enemyMirrors.begin();
        for (int i = 0; i < enemies.size; i++) {
            enemy = enemies.get(i);
            mirror = enemyMirrors.get(i);
            if (enemy.getBounds().overlaps(player.getCircle())) {
                enemies.removeValue(enemy, true);
                enemyMirrors.removeValue(mirror, true);
                logic.get(MirrorHandler.class).removeTransformablePair(enemy, mirror);
                assets.getDead().play();
                logic.get(LifeHandler.class).loseLife();
            }
        }
        enemies.end();
        enemyMirrors.end();
    }
}