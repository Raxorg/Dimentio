package com.epicness.dimentio.game.logic.other;

import static com.badlogic.gdx.Input.Keys.F3;

import com.epicness.dimentio.game.logic.GameLogicHandler;

public class DebugToggler extends GameLogicHandler {

    @Override
    protected void init() {
    }

    @Override
    public void keyDown(int keycode) {
        if (keycode == F3) {
            renderer.toggleDebug();
        }
    }
}