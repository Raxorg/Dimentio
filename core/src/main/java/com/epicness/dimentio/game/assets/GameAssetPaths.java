package com.epicness.dimentio.game.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Music;
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
        ASSETS.add(FADEDCIRCULARGLOW_SPRITE = new AssetDescriptor<>("dimentio/game/images/fadedCircularGlow.png", Sprite.class));
        ASSETS.add(LEAF1BORDER_SPRITE = new AssetDescriptor<>("dimentio/game/images/leaf1Border.png", Sprite.class));
        ASSETS.add(LEAF1INNER_SPRITE = new AssetDescriptor<>("dimentio/game/images/leaf1Inner.png", Sprite.class));
    }
}