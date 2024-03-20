package com.epicness.dimentio.game;

import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;
import static com.epicness.fundamentals.constants.SharedConstants.RATIO;

import com.badlogic.gdx.math.MathUtils;

public class GameConstants {

    // 3D World
    public static final float DECAL_SCREEN_HEIGHT = 5f;
    public static final float DECAL_SCREEN_WIDTH = DECAL_SCREEN_HEIGHT * RATIO;
    public static final float DECAL_CUBE_XZ_RADIUS = DECAL_SCREEN_WIDTH / 2f;

    public static final float CYLINDER_RADIUS = (DECAL_SCREEN_WIDTH / (2 * MathUtils.PI)) * 4f;
    public static final float CYLINDER_DIAMETER = CYLINDER_RADIUS * 2f;

    // 2D World
    public static final float WORLD_WIDTH_2D = CAMERA_WIDTH * 8f;

    // Player
    public static final float PLAYER_RADIUS = 55f;
    public static final float PLAYER_INNER_RADIUS = 10f;
    public static final float PLAYER_DIAMETER = PLAYER_RADIUS * 2f;
    public static final float PLAYER_X_SPEED = 1000f;
    public static final float PLAYER_Y_SPEED = 500f;
}