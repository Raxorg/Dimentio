package com.epicness.dimentio.game.logic;

import com.epicness.dimentio.game.logic.bricks.ActivationHandler;
import com.epicness.dimentio.game.logic.bricks.ActivatorAnimator;
import com.epicness.dimentio.game.logic.bricks.BallMover;
import com.epicness.dimentio.game.logic.bricks.BoundsHandler;
import com.epicness.dimentio.game.logic.bricks.BrickHandler;
import com.epicness.dimentio.game.logic.bricks.LimitHandler;
import com.epicness.dimentio.game.logic.bricks.PaddleHandler;
import com.epicness.dimentio.game.logic.enemies.EnemyCollisionHandler;
import com.epicness.dimentio.game.logic.enemies.EnemyMover;
import com.epicness.dimentio.game.logic.enemies.EnemySpawner;
import com.epicness.dimentio.game.logic.other.CameraHandler;
import com.epicness.dimentio.game.logic.other.CoverHandler;
import com.epicness.dimentio.game.logic.other.FoliageHandler;
import com.epicness.dimentio.game.logic.other.MusicHandler;
import com.epicness.dimentio.game.logic.player.AttackCollisionHandler;
import com.epicness.dimentio.game.logic.player.AttackCooldownHandler;
import com.epicness.dimentio.game.logic.player.AttackWaveHandler;
import com.epicness.dimentio.game.logic.player.GlowHandler;
import com.epicness.dimentio.game.logic.player.LifeHandler;
import com.epicness.dimentio.game.logic.player.MirrorHandler;
import com.epicness.dimentio.game.logic.player.PlayerMover;
import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    // Bricks
    private final ActivationHandler activationHandler;
    private final ActivatorAnimator activatorAnimator;
    private final BallMover ballMover;
    private final BrickHandler brickHandler;
    private final PaddleHandler paddleHandler;
    // Enemies
    private final EnemyMover enemyMover;
    private final EnemySpawner enemySpawner;
    // Other
    private final CameraHandler cameraHandler;
    private final CoverHandler coverHandler;
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
        // Bricks
        registerHandler(activationHandler = new ActivationHandler());
        registerHandler(activatorAnimator = new ActivatorAnimator());
        registerHandler(ballMover = new BallMover());
        registerHandler(new BoundsHandler());
        registerHandler(brickHandler = new BrickHandler());
        registerHandler(new LimitHandler());
        registerHandler(paddleHandler = new PaddleHandler());
        // Enemies
        registerHandler(new EnemyCollisionHandler());
        registerHandler(enemyMover = new EnemyMover());
        registerHandler(enemySpawner = new EnemySpawner());
        // Other
        registerHandler(cameraHandler = new CameraHandler());
        registerHandler(coverHandler = new CoverHandler());
        registerHandler(foliageHandler = new FoliageHandler());
        registerHandler(musicHandler = new MusicHandler());
        // Player
        registerHandler(attackCollisionHandler = new AttackCollisionHandler());
        registerHandler(attackCooldownHandler = new AttackCooldownHandler());
        registerHandler(attackWaveHandler = new AttackWaveHandler());
        registerHandler(glowHandler = new GlowHandler());
        registerHandler(new LifeHandler());
        registerHandler(mirrorHandler = new MirrorHandler());
        registerHandler(playerMover = new PlayerMover());
    }

    @Override
    public void update() {
        // Bricks
        activationHandler.update();
        activatorAnimator.update();
        paddleHandler.update();
        ballMover.update();
        brickHandler.update();
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
        coverHandler.update();
        foliageHandler.update();
        musicHandler.update();
    }
}