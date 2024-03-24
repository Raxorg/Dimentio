package com.epicness.dimentio.splash;

import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;

import com.epicness.dimentio.splash.assets.SplashAssets;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;

public class SplashStuff extends Stuff<SplashAssets> {

    private Sprited splash;

    @Override
    public void initializeStuff() {
        splash = new Sprited(assets.getCrazyCatLogo());
        splash.setSize(CAMERA_HEIGHT);
        splash.setOriginCenter();
        splash.setOriginBasedPosition(CAMERA_HALF_WIDTH, CAMERA_HALF_HEIGHT);
    }

    public Sprited getSplash() {
        return splash;
    }
}