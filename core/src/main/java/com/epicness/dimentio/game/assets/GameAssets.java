package com.epicness.dimentio.game.assets;

import static com.epicness.dimentio.game.assets.GameAssetPaths.*;

import com.badlogic.gdx.audio.Music;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {
    private Music KOLMOSTASecondChance;

    private Music KOLMOSTCountingDownTheHours;

    private Music KOLMOSTTitle;

    public GameAssets() {
        super(ASSETS);
    }

    @Override
    public void initializeAssets() {
        KOLMOSTASecondChance = get(KOLMOSTASECONDCHANCE_MUSIC);
        KOLMOSTCountingDownTheHours = get(KOLMOSTCOUNTINGDOWNTHEHOURS_MUSIC);
        KOLMOSTTitle = get(KOLMOSTTITLE_MUSIC);
    }

    public Music getKOLMOSTASecondChance() {
        return KOLMOSTASecondChance;
    }

    public Music getKOLMOSTCountingDownTheHours() {
        return KOLMOSTCountingDownTheHours;
    }

    public Music getKOLMOSTTitle() {
        return KOLMOSTTitle;
    }
}