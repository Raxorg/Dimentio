package com.epicness.dimentio.splash.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.ArrayList;
import java.util.List;

public class SplashAssetPaths {
    static final List<AssetDescriptor<?>> ASSETS;

    public static final AssetDescriptor<Sprite> CRAZYCATLOGO_SPRITE;

    static {
        ASSETS = new ArrayList<>();
        ASSETS.add(CRAZYCATLOGO_SPRITE = new AssetDescriptor<>("dimentio/splash/images/crazyCatLogo.jpg", Sprite.class));
    }
}