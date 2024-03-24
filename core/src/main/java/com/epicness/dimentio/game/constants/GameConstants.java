package com.epicness.dimentio.game.constants;

import static com.badlogic.gdx.graphics.Color.BLUE;
import static com.badlogic.gdx.graphics.Color.GREEN;
import static com.badlogic.gdx.graphics.Color.ORANGE;
import static com.badlogic.gdx.graphics.Color.PURPLE;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.badlogic.gdx.graphics.Color.YELLOW;
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
    public static final float WORLD_2D_WIDTH = CAMERA_WIDTH * 8f;
    public static final float WORLD_2D_BORDER_HEIGHT = 8f;
    public static final float WORLD_2D_TOP = CAMERA_HEIGHT - WORLD_2D_BORDER_HEIGHT;

    // Activators
    public static final float ACTIVATOR_SIZE = 500f;
    public static final float ACTIVATOR_Y = CAMERA_HALF_HEIGHT - ACTIVATOR_SIZE / 2f;
    public static final Color[] ACTIVATOR_COLORS = new Color[]{RED, GREEN, BLUE, YELLOW};
    public static final Level[] LEVELS = new Level[]{Level.RED, Level.GREEN, Level.BLUE, Level.YELLOW};

    // Paddle
    public static final float PADDLE_WIDTH = 200f;
    public static final float PADDLE_HEIGHT = 40f;
    public static final float PADDLE_SPEED = 1200f;
    public static final float PADDLE_Y = WORLD_2D_BORDER_HEIGHT;
    public static final float PADDLE_TOP = PADDLE_Y + PADDLE_HEIGHT;

    // Player
    public static final float PLAYER_RADIUS = 55f;
    public static final float PLAYER_INNER_RADIUS = 10f;
    public static final float PLAYER_DIAMETER = PLAYER_RADIUS * 2f;
    public static final float PLAYER_INNER_DIAMETER = PLAYER_INNER_RADIUS * 2f;
    public static final float PLAYER_X_SPEED = 1000f;
    public static final float PLAYER_Y_SPEED = 500f;
    public static final float MIN_PLAYER_Y = WORLD_2D_BORDER_HEIGHT + PLAYER_INNER_RADIUS;
    public static final float MAX_PLAYER_Y = CAMERA_HEIGHT - WORLD_2D_BORDER_HEIGHT - PLAYER_INNER_RADIUS;
    public static final float PLAYER_STARTING_PADDLE_Y = WORLD_2D_BORDER_HEIGHT + PADDLE_HEIGHT + PLAYER_INNER_RADIUS;
    public static final float ATTACK_COOLDOWN = 1.45f;

    // Bricks
    public static final float BRICK_WIDTH = 160f;
    public static final float BRICK_HEIGHT = 40f;
    public static final int BRICK_COLUMNS = 7;
    public static final int BRICK_ROWS = 5;
    public static final float BRICK_X_SPACING = (CAMERA_WIDTH - BRICK_WIDTH * BRICK_COLUMNS) / (BRICK_COLUMNS + 1);
    public static final float BRICK_Y_SPACING = 20f;
    public static final float BRICKS_TOP_Y = CAMERA_HEIGHT - WORLD_2D_BORDER_HEIGHT - BRICK_HEIGHT * 2f;
    public static final float GREEN_START_X = CAMERA_WIDTH * 2f;
    public static final float BLUE_START_X = CAMERA_WIDTH * 4f;
    public static final float YELLOW_START_X = CAMERA_WIDTH * 6f;
    public static final float BRICK_BALL_SPEED = 900f;

    // Enemies
    public static final float ENEMY_SIZE = 150f;
    public static final float ENEMY_SPAWN_INTERVAL = 3.2f;
    public static final float ENEMY_SPAWN_Y = CAMERA_HALF_HEIGHT - ENEMY_SIZE / 2f;
    public static final float ENEMY_SPEED = 150f;

    // Foliage
    public static final Array<Color> FOLIAGE_COLORS = Array.with(ORANGE, PURPLE, GRASS);
}