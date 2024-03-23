package com.epicness.dimentio;

import com.badlogic.gdx.Game;
import com.epicness.dimentio.game.GameInitializer;
import com.epicness.dimentio.game.assets.GameAssets;
import com.epicness.fundamentals.SharedResources;

public class DimentioGame extends Game {

    @Override
    public void create() {
        GameAssets assets = new GameAssets();
        assets.queueAssetLoading();
        assets.finishLoading();
        assets.initializeAssets();
        new GameInitializer(assets).initialize(new SharedResources());
    }

    // TODO: 3/22/2024 OPEN WORLD GAME (small world, still open xd)
}