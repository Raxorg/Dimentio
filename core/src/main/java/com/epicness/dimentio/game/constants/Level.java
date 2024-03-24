package com.epicness.dimentio.game.constants;

import com.badlogic.gdx.graphics.Color;

public enum Level {

    RED(Color.RED), GREEN(Color.GREEN), BLUE(Color.BLUE), YELLOW(Color.YELLOW);

    public final Color color;

    Level(Color color) {
        this.color = new Color(color);
    }
}