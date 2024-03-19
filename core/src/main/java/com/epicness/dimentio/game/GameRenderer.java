package com.epicness.dimentio.game;

import static com.badlogic.gdx.graphics.Color.CLEAR;

import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.dimentio.game.stuff.GameStuff;
import com.epicness.fundamentals.renderer.Renderer3D;

public class GameRenderer extends Renderer3D<GameStuff> {

    @Override
    public void render() {
        ScreenUtils.clear(CLEAR, true);

        spriteBatch.begin();
        stuff.getWorld3D().draw2D(spriteBatch, shapeDrawer, screen.getDynamicCamera());
        spriteBatch.end();

        modelBatch.begin(perspectiveCamera);
        stuff.getWorld3D().draw3D(modelBatch);
        modelBatch.end();
    }
}