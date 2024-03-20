package com.epicness.dimentio.game;

import static com.badlogic.gdx.graphics.Color.ORANGE;
import static com.badlogic.gdx.graphics.Color.PURPLE;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;
import static com.epicness.fundamentals.constants.SharedConstants.GRASS;
import static com.epicness.fundamentals.constants.SharedConstants.RATIO;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class GameConstants {

    // 3D World
    public static final float DECAL_SCREEN_HEIGHT = 5f;
    public static final float DECAL_SCREEN_WIDTH = DECAL_SCREEN_HEIGHT * RATIO;
    public static final float DECAL_CUBE_XZ_RADIUS = DECAL_SCREEN_WIDTH / 2f;

    public static final float CYLINDER_RADIUS = (DECAL_SCREEN_WIDTH / (2 * MathUtils.PI)) * 4f;
    public static final float CYLINDER_DIAMETER = CYLINDER_RADIUS * 2f;

    // 2D World
    public static final float WORLD_WIDTH_2D = CAMERA_WIDTH * 8f;
    public static final float BORDER_HEIGHT = 8f;

    // Player
    public static final float PLAYER_RADIUS = 55f;
    public static final float PLAYER_INNER_RADIUS = 10f;
    public static final float PLAYER_DIAMETER = PLAYER_RADIUS * 2f;
    public static final float PLAYER_X_SPEED = 1000f;
    public static final float PLAYER_Y_SPEED = 500f;
    public static final float MIN_PLAYER_Y = BORDER_HEIGHT + PLAYER_INNER_RADIUS;
    public static final float MAX_PLAYER_Y = CAMERA_HEIGHT - BORDER_HEIGHT - PLAYER_INNER_RADIUS;

    // Enemies
    public static final float ENEMY_SIZE = 150f;
    public static final float ENEMY_SPAWN_INTERVAL = 3f;
    public static final float ENEMY_SPAWN_Y = CAMERA_HALF_HEIGHT - ENEMY_SIZE / 2f;

    // Foliage
    public static final Array<Color> FOLIAGE_COLORS = Array.with(ORANGE, PURPLE, GRASS);
}