package com.epicness.dimentio.splash.assets;

import static com.epicness.dimentio.splash.assets.SplashAssetPaths.*;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class SplashAssets extends Assets {
    private Sprite crazyCatLogo;

    public SplashAssets() {
        super(ASSETS);
    }

    @Override
    public void initializeAssets() {
        crazyCatLogo = get(CRAZYCATLOGO_SPRITE);
    }

    public Sprite getCrazyCatLogo() {
        return crazyCatLogo;
    }
}