package com.epicness.dimentio;

import com.badlogic.gdx.Game;
import com.epicness.dimentio.splash.SplashInitializer;
import com.epicness.dimentio.splash.assets.SplashAssets;
import com.epicness.fundamentals.SharedResources;

public class DimentioGame extends Game {

    @Override
    public void create() {
        SplashAssets assets = new SplashAssets();
        assets.queueAssetLoading();
        assets.finishLoading();
        assets.initializeAssets();
        new SplashInitializer(assets).initialize(new SharedResources());
    }

    // TODO: 3/22/2024 OPEN WORLD GAME (small world, still open xd)
}