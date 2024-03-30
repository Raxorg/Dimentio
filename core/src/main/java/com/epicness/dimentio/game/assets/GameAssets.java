package com.epicness.dimentio.game.assets;

import static com.epicness.dimentio.game.assets.GameAssetPaths.*;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {
    private Sprite gameAtlas;

    private Sprite activator1;

    private Sprite activator1Glow;

    private Sprite activator2;

    private Sprite activator2Glow;

    private Sprite activator3;

    private Sprite activator3Glow;

    private Sprite ending;

    private Sprite[] enemyFrames;

    private Sprite enemy_1;

    private Sprite enemy_2;

    private Sprite fadedCircularGlow;

    private Sprite leaf1Border;

    private Sprite leaf1Inner;

    private Music KOLMOSTASecondChance;

    private Music KOLMOSTCountingDownTheHours;

    private Music KOLMOSTTitle;

    private Sound dead;

    private Sound futuristic;

    private Sound hit;

    private Sound wisp;

    public GameAssets() {
        super(ASSETS);
    }

    @Override
    public void initializeAssets() {
        gameAtlas = new Sprite(get(GAME_ATLAS).getTextures().first());
        activator1 = get(GAME_ATLAS).createSprite("activator1");
        activator1Glow = get(GAME_ATLAS).createSprite("activator1Glow");
        activator2 = get(GAME_ATLAS).createSprite("activator2");
        activator2Glow = get(GAME_ATLAS).createSprite("activator2Glow");
        activator3 = get(GAME_ATLAS).createSprite("activator3");
        activator3Glow = get(GAME_ATLAS).createSprite("activator3Glow");
        ending = get(GAME_ATLAS).createSprite("ending");
        enemyFrames = get(GAME_ATLAS).createSprites("enemy").toArray();
        enemy_1 = get(GAME_ATLAS).createSprite("enemy", 1);
        enemy_2 = get(GAME_ATLAS).createSprite("enemy", 2);
        fadedCircularGlow = get(GAME_ATLAS).createSprite("fadedCircularGlow");
        leaf1Border = get(GAME_ATLAS).createSprite("leaf1Border");
        leaf1Inner = get(GAME_ATLAS).createSprite("leaf1Inner");
        KOLMOSTASecondChance = get(KOLMOSTASECONDCHANCE_MUSIC);
        KOLMOSTCountingDownTheHours = get(KOLMOSTCOUNTINGDOWNTHEHOURS_MUSIC);
        KOLMOSTTitle = get(KOLMOSTTITLE_MUSIC);
        dead = get(DEAD_SOUND);
        futuristic = get(FUTURISTIC_SOUND);
        hit = get(HIT_SOUND);
        wisp = get(WISP_SOUND);
    }

    public Sprite getGameAtlas() {
        return gameAtlas;
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

    public Sprite[] getEnemyFrames() {
        return enemyFrames;
    }

    public Sprite getEnemy_1() {
        return enemy_1;
    }

    public Sprite getEnemy_2() {
        return enemy_2;
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
}