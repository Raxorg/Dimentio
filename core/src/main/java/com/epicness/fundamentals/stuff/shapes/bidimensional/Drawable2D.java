package com.epicness.fundamentals.stuff.shapes.bidimensional;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;

public abstract class Drawable2D {

    public abstract void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawerPlus);
}