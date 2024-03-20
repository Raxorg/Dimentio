package com.epicness.fundamentals.stuff.interfaces;

public interface Transformable extends Movable, Scalable, Rotatable {

    default float getEndX() {
        return getX() + getWidth();
    }

    default float getEndY() {
        return getY() + getHeight();
    }
}