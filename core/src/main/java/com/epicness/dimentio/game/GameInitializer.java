package com.epicness.dimentio.game;

import com.epicness.dimentio.game.assets.GameAssets;
import com.epicness.dimentio.game.logic.GameLogic;
import com.epicness.dimentio.game.stuff.GameStuff;
import com.epicness.fundamentals.initializer.Initializer;

public class GameInitializer extends Initializer<GameAssets, GameRenderer, GameStuff> {

    public GameInitializer(GameAssets assets) {
        super(assets, new GameLogic(), new GameRenderer(), new GameStuff());
    }
}