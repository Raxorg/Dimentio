package com.epicness.dimentio.game.logic.player;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Enemy;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class AttackCollisionHandler extends GameLogicHandler {

    private SnapshotArray<Enemy> enemies, enemyMirrors;
    private Circle playerAttack, playerAttackMirror;

    @Override
    protected void init() {
        enemies = stuff.getWorld2D().getEnemies();
        enemyMirrors = stuff.getWorld2D().getEnemyMirrors();
        playerAttack = stuff.getWorld2D().getPlayerAttack();
        playerAttackMirror = stuff.getWorld2D().getPlayerAttackMirror();
    }

    @Override
    protected void update(float delta) {
        Enemy enemy, mirror;
        enemies.begin();
        for (int i = 0; i < enemies.size; i++) {
            enemy = enemies.get(i);
            mirror = enemyMirrors.get(i);
            if ((enemy.getBounds().overlaps(playerAttack) || enemy.getBounds().overlaps(playerAttackMirror))
                && playerAttack.getBorderColor().a >= 0.4f) {
                enemies.removeValue(enemy, true);
                enemyMirrors.removeValue(mirror, true);
                logic.get(MirrorHandler.class).removeTransformablePair(enemy, mirror);
                assets.getDead().play();
            }
        }
        enemies.end();
    }
}