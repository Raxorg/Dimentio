package com.epicness.dimentio.game.logic;

import com.epicness.dimentio.game.logic.enemies.EnemyMover;
import com.epicness.dimentio.game.logic.enemies.EnemySpawner;
import com.epicness.dimentio.game.logic.other.CameraHandler;
import com.epicness.dimentio.game.logic.other.FoliageHandler;
import com.epicness.dimentio.game.logic.other.MusicHandler;
import com.epicness.dimentio.game.logic.player.AttackCollisionHandler;
import com.epicness.dimentio.game.logic.player.AttackCooldownHandler;
import com.epicness.dimentio.game.logic.player.AttackWaveHandler;
import com.epicness.dimentio.game.logic.player.GlowHandler;
import com.epicness.dimentio.game.logic.player.MirrorHandler;
import com.epicness.dimentio.game.logic.player.PlayerMover;
import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    // Enemies
    private final EnemyMover enemyMover;
    private final EnemySpawner enemySpawner;
    // Other
    private final CameraHandler cameraHandler;
    private final FoliageHandler foliageHandler;
    private final MusicHandler musicHandler;
    // Player
    private final AttackCollisionHandler attackCollisionHandler;
    private final AttackCooldownHandler attackCooldownHandler;
    private final AttackWaveHandler attackWaveHandler;
    private final GlowHandler glowHandler;
    private final MirrorHandler mirrorHandler;
    private final PlayerMover playerMover;

    public GameLogic() {
        // Enemies
        registerHandler(enemyMover = new EnemyMover());
        registerHandler(enemySpawner = new EnemySpawner());
        // Other
        registerHandler(cameraHandler = new CameraHandler());
        registerHandler(foliageHandler = new FoliageHandler());
        registerHandler(musicHandler = new MusicHandler());
        // Player
        registerHandler(attackCollisionHandler = new AttackCollisionHandler());
        registerHandler(attackCooldownHandler = new AttackCooldownHandler());
        registerHandler(attackWaveHandler = new AttackWaveHandler());
        registerHandler(glowHandler = new GlowHandler());
        registerHandler(mirrorHandler = new MirrorHandler());
        registerHandler(playerMover = new PlayerMover());
    }

    @Override
    public void update() {
        // Enemies
        enemyMover.update();
        enemySpawner.update();
        // Player
        attackCollisionHandler.update();
        attackCooldownHandler.update();
        glowHandler.update();
        playerMover.update();
        attackWaveHandler.update();
        mirrorHandler.update();
        // Other
        cameraHandler.update();
        foliageHandler.update();
        //musicHandler.update();
    }
}