package com.epicness.dimentio.game.assets;

import static com.epicness.dimentio.game.assets.GameAssetPaths.*;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {
    private Sprite[] enemyAnimFrames;

    private Sprite enemyFrames;

    private Music KOLMOSTASecondChance;

    private Music KOLMOSTCountingDownTheHours;

    private Music KOLMOSTTitle;

    private Sprite fadedCircularGlow;

    private Sprite leaf1Border;

    private Sprite leaf1Inner;

    public GameAssets() {
        super(ASSETS);
    }

    @Override
    public void initializeAssets() {
        enemyAnimFrames = get(ENEMYANIMFRAMES_ANIMATION);
        enemyFrames = get(ENEMYFRAMES_SPRITE);
        KOLMOSTASecondChance = get(KOLMOSTASECONDCHANCE_MUSIC);
        KOLMOSTCountingDownTheHours = get(KOLMOSTCOUNTINGDOWNTHEHOURS_MUSIC);
        KOLMOSTTitle = get(KOLMOSTTITLE_MUSIC);
        fadedCircularGlow = get(FADEDCIRCULARGLOW_SPRITE);
        leaf1Border = get(LEAF1BORDER_SPRITE);
        leaf1Inner = get(LEAF1INNER_SPRITE);
    }

    public Sprite[] getEnemyAnimFrames() {
        return enemyAnimFrames;
    }

    public Sprite getEnemyFrames() {
        return enemyFrames;
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

    public Sprite getLeaf1Border() {
        return leaf1Border;
    }

    public Sprite getLeaf1Inner() {
        return leaf1Inner;
    }
}