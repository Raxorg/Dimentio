package com.epicness.dimentio.splash;

import com.epicness.dimentio.splash.assets.SplashAssets;
import com.epicness.dimentio.splash.logic.SplashLogic;
import com.epicness.fundamentals.initializer.Initializer;

public class SplashInitializer extends Initializer<SplashAssets, SplashRenderer, SplashStuff> {

    public SplashInitializer(SplashAssets assets) {
        super(assets, new SplashLogic(), new SplashRenderer(), new SplashStuff());
    }
}