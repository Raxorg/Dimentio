package com.epicness.dimentio.game.logic;

import com.epicness.dimentio.game.logic.other.CameraHandler;
import com.epicness.dimentio.game.logic.other.MusicHandler;
import com.epicness.dimentio.game.logic.player.GlowHandler;
import com.epicness.dimentio.game.logic.player.MirrorHandler;
import com.epicness.dimentio.game.logic.player.MovementHandler;
import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    // Other
    private final CameraHandler cameraHandler;
    private final MusicHandler musicHandler;
    // Player
    private final GlowHandler glowHandler;
    private final MirrorHandler mirrorHandler;
    private final MovementHandler movementHandler;

    public GameLogic() {
        // Other
        registerHandler(cameraHandler = new CameraHandler());
        registerHandler(musicHandler = new MusicHandler());
        // Player
        registerHandler(glowHandler = new GlowHandler());
        registerHandler(mirrorHandler = new MirrorHandler());
        registerHandler(movementHandler = new MovementHandler());
    }

    @Override
    public void update() {
        // Player
        glowHandler.update();
        movementHandler.update();
        mirrorHandler.update();
        // Other
        cameraHandler.update();
        //musicHandler.update();
    }
}