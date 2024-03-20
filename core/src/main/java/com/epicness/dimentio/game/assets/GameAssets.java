package com.epicness.dimentio.game.assets;

import static com.epicness.dimentio.game.assets.GameAssetPaths.*;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {
    private Music KOLMOSTASecondChance;

    private Music KOLMOSTCountingDownTheHours;

    private Music KOLMOSTTitle;

    private Sprite fadedCircularGlow;

    public GameAssets() {
        super(ASSETS);
    }

    @Override
    public void initializeAssets() {
        KOLMOSTASecondChance = get(KOLMOSTASECONDCHANCE_MUSIC);
        KOLMOSTCountingDownTheHours = get(KOLMOSTCOUNTINGDOWNTHEHOURS_MUSIC);
        KOLMOSTTitle = get(KOLMOSTTITLE_MUSIC);
        fadedCircularGlow = get(FADEDCIRCULARGLOW_SPRITE);
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

    public Sprite getFadedCircularGlow() {
        return fadedCircularGlow;
    }
}