package com.epicness.fundamentals.stuff.interfaces;

import com.badlogic.gdx.math.Vector2;

public interface Transformable extends Movable, Scalable, Rotatable {

    default float getEndX() {
        return getX() + getWidth();
    }

    default float getEndY() {
        return getY() + getHeight();
    }

    default Vector2 getCenter(Vector2 result) {
        return result.set(getX() + getWidth() / 2f, getY() + getHeight() / 2f);
    }
}