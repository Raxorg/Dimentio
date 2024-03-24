package com.epicness.dimentio.splash;

import com.epicness.fundamentals.renderer.Renderer;

public class SplashRenderer extends Renderer<SplashStuff> {

    @Override
    public void render() {
        spriteBatch.begin();
        stuff.getSplash().draw(spriteBatch);
        spriteBatch.end();
    }
}