package com.epicness.dimentio.game.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.ArrayList;
import java.util.List;

public class GameAssetPaths {
    static final List<AssetDescriptor<?>> ASSETS;

    public static final AssetDescriptor<Sprite[]> ENEMYANIMFRAMES_ANIMATION;

    public static final AssetDescriptor<Sprite> ENEMYFRAMES_SPRITE;

    public static final AssetDescriptor<Music> KOLMOSTASECONDCHANCE_MUSIC;

    public static final AssetDescriptor<Music> KOLMOSTCOUNTINGDOWNTHEHOURS_MUSIC;

    public static final AssetDescriptor<Music> KOLMOSTTITLE_MUSIC;

    public static final AssetDescriptor<Sound> DEAD_SOUND;

    public static final AssetDescriptor<Sound> FUTURISTIC_SOUND;

    public static final AssetDescriptor<Sound> HIT_SOUND;

    public static final AssetDescriptor<Sound> WISP_SOUND;

    public static final AssetDescriptor<Sprite> ACTIVATOR1_SPRITE;

    public static final AssetDescriptor<Sprite> ACTIVATOR1GLOW_SPRITE;

    public static final AssetDescriptor<Sprite> ACTIVATOR2_SPRITE;

    public static final AssetDescriptor<Sprite> ACTIVATOR2GLOW_SPRITE;

    public static final AssetDescriptor<Sprite> ACTIVATOR3_SPRITE;

    public static final AssetDescriptor<Sprite> ACTIVATOR3GLOW_SPRITE;

    public static final AssetDescriptor<Sprite> FADEDCIRCULARGLOW_SPRITE;

    public static final AssetDescriptor<Sprite> LEAF1BORDER_SPRITE;

    public static final AssetDescriptor<Sprite> LEAF1INNER_SPRITE;

    static {
        ASSETS = new ArrayList<>();
        ASSETS.add(ENEMYANIMFRAMES_ANIMATION = new AssetDescriptor<>("dimentio/game/animations/enemyAnimFrames.anim", Sprite[].class));
        ASSETS.add(ENEMYFRAMES_SPRITE = new AssetDescriptor<>("dimentio/game/animations/enemyFrames.png", Sprite.class));
        ASSETS.add(KOLMOSTASECONDCHANCE_MUSIC = new AssetDescriptor<>("dimentio/game/audios/music/KOLMOSTASecondChance.mogg", Music.class));
        ASSETS.add(KOLMOSTCOUNTINGDOWNTHEHOURS_MUSIC = new AssetDescriptor<>("dimentio/game/audios/music/KOLMOSTCountingDownTheHours.mogg", Music.class));
        ASSETS.add(KOLMOSTTITLE_MUSIC = new AssetDescriptor<>("dimentio/game/audios/music/KOLMOSTTitle.mogg", Music.class));
        ASSETS.add(DEAD_SOUND = new AssetDescriptor<>("dimentio/game/audios/sounds/dead.swav", Sound.class));
        ASSETS.add(FUTURISTIC_SOUND = new AssetDescriptor<>("dimentio/game/audios/sounds/futuristic.swav", Sound.class));
        ASSETS.add(HIT_SOUND = new AssetDescriptor<>("dimentio/game/audios/sounds/hit.swav", Sound.class));
        ASSETS.add(WISP_SOUND = new AssetDescriptor<>("dimentio/game/audios/sounds/wisp.swav", Sound.class));
        ASSETS.add(ACTIVATOR1_SPRITE = new AssetDescriptor<>("dimentio/game/images/activator1.png", Sprite.class));
        ASSETS.add(ACTIVATOR1GLOW_SPRITE = new AssetDescriptor<>("dimentio/game/images/activator1Glow.png", Sprite.class));
        ASSETS.add(ACTIVATOR2_SPRITE = new AssetDescriptor<>("dimentio/game/images/activator2.png", Sprite.class));
        ASSETS.add(ACTIVATOR2GLOW_SPRITE = new AssetDescriptor<>("dimentio/game/images/activator2Glow.png", Sprite.class));
        ASSETS.add(ACTIVATOR3_SPRITE = new AssetDescriptor<>("dimentio/game/images/activator3.png", Sprite.class));
        ASSETS.add(ACTIVATOR3GLOW_SPRITE = new AssetDescriptor<>("dimentio/game/images/activator3Glow.png", Sprite.class));
        ASSETS.add(FADEDCIRCULARGLOW_SPRITE = new AssetDescriptor<>("dimentio/game/images/fadedCircularGlow.png", Sprite.class));
        ASSETS.add(LEAF1BORDER_SPRITE = new AssetDescriptor<>("dimentio/game/images/leaf1Border.png", Sprite.class));
        ASSETS.add(LEAF1INNER_SPRITE = new AssetDescriptor<>("dimentio/game/images/leaf1Inner.png", Sprite.class));
    }
}