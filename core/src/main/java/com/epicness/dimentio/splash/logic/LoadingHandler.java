package com.epicness.dimentio.splash.logic;

import com.epicness.dimentio.DimentioGame;
import com.epicness.dimentio.game.GameInitializer;
import com.epicness.dimentio.game.assets.GameAssets;
import com.epicness.dimentio.splash.SplashRenderer;
import com.epicness.dimentio.splash.SplashStuff;
import com.epicness.dimentio.splash.assets.SplashAssets;
import com.epicness.fundamentals.input.LogicInputHandler;

public class LoadingHandler extends LogicInputHandler<DimentioGame, SplashAssets, SplashLogic, SplashRenderer, SplashStuff> {

    private float time;
    private boolean transitionReady;

    @Override
    protected void init() {
        time = 0f;
        sharedLogic.getTransitionHandler().startTransition(() -> transitionReady = true, new GameInitializer(new GameAssets()));
    }

    @Override
    protected void update(float delta) {
        time += delta;
        if (time >= 3f && transitionReady)
            sharedLogic.getTransitionHandler().allowTransition();
    }
}