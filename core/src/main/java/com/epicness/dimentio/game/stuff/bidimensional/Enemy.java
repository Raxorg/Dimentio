package com.epicness.dimentio.game.stuff.bidimensional;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.SpritedAnimation;
import com.epicness.fundamentals.stuff.interfaces.Transformable;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class Enemy implements Transformable {

    private final SpritedAnimation animation;
    private final Circle bounds;

    public Enemy(Sprite[] frames) {
        animation = new SpritedAnimation(0.2f, frames);
        bounds = new Circle();
    }

    public void draw(SpriteBatch spriteBatch) {
        animation.draw(spriteBatch);
    }

    public void drawDebug(ShapeDrawerPlus shapeDrawer) {
        bounds.drawBorder(shapeDrawer);
    }

    @Override
    public float getX() {
        return animation.getX();
    }

    @Override
    public void translateX(float amount) {
        animation.translateX(amount);
        bounds.translateX(amount);
    }

    @Override
    public float getY() {
        return animation.getY();
    }

    @Override
    public void translateY(float amount) {
        animation.translateY(amount);
        bounds.translateY(amount);
    }

    public SpritedAnimation getAnimation() {
        return animation;
    }

    public Circle getBounds() {
        return bounds;
    }

    @Override
    public float getRotation() {
        return animation.getRotation();
    }

    @Override
    public void rotate(float degrees) {
        animation.rotate(degrees);
    }

    @Override
    public void stretchWidth(float amount) {
        animation.setWidth(animation.getWidth() + amount);
    }

    @Override
    public void stretchHeight(float amount) {
        animation.setHeight(animation.getHeight() + amount);
    }

    @Override
    public float getWidth() {
        return animation.getWidth();
    }

    @Override
    public float getHeight() {
        return animation.getHeight();
    }
}