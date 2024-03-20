package com.epicness.dimentio.game.logic;

import com.epicness.dimentio.game.logic.enemies.EnemySpawner;
import com.epicness.dimentio.game.logic.other.CameraHandler;
import com.epicness.dimentio.game.logic.other.FoliageHandler;
import com.epicness.dimentio.game.logic.other.MusicHandler;
import com.epicness.dimentio.game.logic.player.AttackHandler;
import com.epicness.dimentio.game.logic.player.GlowHandler;
import com.epicness.dimentio.game.logic.player.MirrorHandler;
import com.epicness.dimentio.game.logic.player.MovementHandler;
import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    // Enemies
    private final EnemySpawner enemySpawner;
    // Other
    private final CameraHandler cameraHandler;
    private final FoliageHandler foliageHandler;
    private final MusicHandler musicHandler;
    // Player
    private final AttackHandler attackHandler;
    private final GlowHandler glowHandler;
    private final MirrorHandler mirrorHandler;
    private final MovementHandler movementHandler;

    public GameLogic() {
        // Enemies
        registerHandler(enemySpawner = new EnemySpawner());
        // Other
        registerHandler(cameraHandler = new CameraHandler());
        registerHandler(foliageHandler = new FoliageHandler());
        registerHandler(musicHandler = new MusicHandler());
        // Player
        registerHandler(attackHandler = new AttackHandler());
        registerHandler(glowHandler = new GlowHandler());
        registerHandler(mirrorHandler = new MirrorHandler());
        registerHandler(movementHandler = new MovementHandler());
    }

    @Override
    public void update() {
        // Enemies
        enemySpawner.update();
        // Player
        glowHandler.update();
        movementHandler.update();
        attackHandler.update();
        mirrorHandler.update();
        // Other
        cameraHandler.update();
        foliageHandler.update();
        //musicHandler.update();
    }
}