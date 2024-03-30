package com.epicness.dimentio.game.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import java.util.ArrayList;
import java.util.List;

public class GameAssetPaths {
    static final List<AssetDescriptor<?>> ASSETS;

    public static final AssetDescriptor<TextureAtlas> GAME_ATLAS;

    public static final AssetDescriptor<Music> KOLMOSTASECONDCHANCE_MUSIC;

    public static final AssetDescriptor<Music> KOLMOSTCOUNTINGDOWNTHEHOURS_MUSIC;

    public static final AssetDescriptor<Music> KOLMOSTTITLE_MUSIC;

    public static final AssetDescriptor<Sound> DEAD_SOUND;

    public static final AssetDescriptor<Sound> FUTURISTIC_SOUND;

    public static final AssetDescriptor<Sound> HIT_SOUND;

    public static final AssetDescriptor<Sound> WISP_SOUND;

    static {
        ASSETS = new ArrayList<>();
        ASSETS.add(GAME_ATLAS = new AssetDescriptor<>("dimentio/game/atlases/game.atlas", TextureAtlas.class));
        ASSETS.add(KOLMOSTASECONDCHANCE_MUSIC = new AssetDescriptor<>("dimentio/game/audios/music/KOLMOSTASecondChance.mogg", Music.class));
        ASSETS.add(KOLMOSTCOUNTINGDOWNTHEHOURS_MUSIC = new AssetDescriptor<>("dimentio/game/audios/music/KOLMOSTCountingDownTheHours.mogg", Music.class));
        ASSETS.add(KOLMOSTTITLE_MUSIC = new AssetDescriptor<>("dimentio/game/audios/music/KOLMOSTTitle.mogg", Music.class));
        ASSETS.add(DEAD_SOUND = new AssetDescriptor<>("dimentio/game/audios/sounds/dead.swav", Sound.class));
        ASSETS.add(FUTURISTIC_SOUND = new AssetDescriptor<>("dimentio/game/audios/sounds/futuristic.swav", Sound.class));
        ASSETS.add(HIT_SOUND = new AssetDescriptor<>("dimentio/game/audios/sounds/hit.swav", Sound.class));
        ASSETS.add(WISP_SOUND = new AssetDescriptor<>("dimentio/game/audios/sounds/wisp.swav", Sound.class));
    }
}