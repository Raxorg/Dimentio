package com.epicness.dimentio.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.epicness.dimentio.game.GameConstants.PLAYER_DIAMETER;
import static com.epicness.dimentio.game.GameConstants.PLAYER_INNER_RADIUS;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.interfaces.Transformable;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Circle;

public class Player implements Transformable {

    private final Circle circle;
    private final Sprited glow;
    private final Vector2 speed;
    private final Color baseColor;

    public Player(Sprite glowSprite) {
        circle = new Circle(PLAYER_INNER_RADIUS, BLACK);

        glow = new Sprited(glowSprite);
        glow.setSize(PLAYER_DIAMETER);
        glow.setOriginCenter();
        glow.setOriginBasedPosition(circle.x, circle.y);

        speed = new Vector2();

        baseColor = new Color();
    }

    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {
        glow.draw(spriteBatch);
        circle.draw(shapeDrawer);
    }

    @Override
    public float getX() {
        return circle.x;
    }

    @Override
    public void translateX(float amount) {
        circle.translateX(amount);
        glow.translateX(amount);
    }

    @Override
    public float getY() {
        return circle.y;
    }

    @Override
    public void translateY(float amount) {
        circle.translateY(amount);
        glow.translateY(amount);
    }

    @Override
    public float getRotation() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void rotate(float degrees) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void stretchWidth(float amount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void stretchHeight(float amount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getWidth() {
        return glow.getWidth();
    }

    @Override
    public float getHeight() {
        return glow.getHeight();
    }

    public Vector2 getCenter(Vector2 aux) {
        return circle.getCenter(aux);
    }

    public Vector2 getSpeed() {
        return speed;
    }

    public Color getGlowColor() {
        return glow.getColor();
    }

    public void setGlowColor(Color color) {
        glow.setColor(color);
    }

    public Color getBaseColor() {
        return baseColor;
    }

    public void setBaseColor(Color color) {
        baseColor.set(color);
    }
}