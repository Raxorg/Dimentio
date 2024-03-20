package com.epicness.dimentio.game.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.ArrayList;
import java.util.List;

public class GameAssetPaths {
    static final List<AssetDescriptor<?>> ASSETS;

    public static final AssetDescriptor<Music> KOLMOSTASECONDCHANCE_MUSIC;

    public static final AssetDescriptor<Music> KOLMOSTCOUNTINGDOWNTHEHOURS_MUSIC;

    public static final AssetDescriptor<Music> KOLMOSTTITLE_MUSIC;

    public static final AssetDescriptor<Sprite> FADEDCIRCULARGLOW_SPRITE;

    static {
        ASSETS = new ArrayList<>();
        ASSETS.add(KOLMOSTASECONDCHANCE_MUSIC = new AssetDescriptor<>("dimentio/game/audios/music/KOLMOSTASecondChance.mogg", Music.class));
        ASSETS.add(KOLMOSTCOUNTINGDOWNTHEHOURS_MUSIC = new AssetDescriptor<>("dimentio/game/audios/music/KOLMOSTCountingDownTheHours.mogg", Music.class));
        ASSETS.add(KOLMOSTTITLE_MUSIC = new AssetDescriptor<>("dimentio/game/audios/music/KOLMOSTTitle.mogg", Music.class));
        ASSETS.add(FADEDCIRCULARGLOW_SPRITE = new AssetDescriptor<>("dimentio/game/images/fadedCircularGlow.png", Sprite.class));
    }
}