package com.epicness.dimentio.game.assets;

import static com.epicness.dimentio.game.assets.GameAssetPaths.*;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {
    private Sprite[] enemyAnimFrames;

    private Sprite enemyFrames;

    private Music KOLMOSTASecondChance;

    private Music KOLMOSTCountingDownTheHours;

    private Music KOLMOSTTitle;

    private Sound dead;

    private Sound futuristic;

    private Sound hit;

    private Sound wisp;

    private Sprite activator1;

    private Sprite activator1Glow;

    private Sprite activator2;

    private Sprite activator2Glow;

    private Sprite activator3;

    private Sprite activator3Glow;

    private Sprite ending;

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
        dead = get(DEAD_SOUND);
        futuristic = get(FUTURISTIC_SOUND);
        hit = get(HIT_SOUND);
        wisp = get(WISP_SOUND);
        activator1 = get(ACTIVATOR1_SPRITE);
        activator1Glow = get(ACTIVATOR1GLOW_SPRITE);
        activator2 = get(ACTIVATOR2_SPRITE);
        activator2Glow = get(ACTIVATOR2GLOW_SPRITE);
        activator3 = get(ACTIVATOR3_SPRITE);
        activator3Glow = get(ACTIVATOR3GLOW_SPRITE);
        ending = get(ENDING_SPRITE);
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

    public Sound getDead() {
        return dead;
    }

    public Sound getFuturistic() {
        return futuristic;
    }

    public Sound getHit() {
        return hit;
    }

    public Sound getWisp() {
        return wisp;
    }

    public Sprite getActivator1() {
        return activator1;
    }

    public Sprite getActivator1Glow() {
        return activator1Glow;
    }

    public Sprite getActivator2() {
        return activator2;
    }

    public Sprite getActivator2Glow() {
        return activator2Glow;
    }

    public Sprite getActivator3() {
        return activator3;
    }

    public Sprite getActivator3Glow() {
        return activator3Glow;
    }

    public Sprite getEnding() {
        return ending;
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