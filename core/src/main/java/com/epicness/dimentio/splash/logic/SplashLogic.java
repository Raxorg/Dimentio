package com.epicness.dimentio.splash.logic;

import com.epicness.fundamentals.logic.Logic;

public class SplashLogic extends Logic {

    private final LoadingHandler loadingHandler;

    public SplashLogic() {
        registerHandler(loadingHandler = new LoadingHandler());
    }

    @Override
    public void update() {
        sharedLogic.getTransitionHandler().update();
        loadingHandler.update();
    }
}