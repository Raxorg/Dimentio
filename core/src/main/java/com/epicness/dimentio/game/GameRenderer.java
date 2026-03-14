package com.epicness.dimentio.game;

import static com.badlogic.gdx.graphics.Color.CLEAR;

import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.dimentio.game.stuff.GameStuff;
import com.epicness.fundamentals.renderer.Renderer3D;

public class GameRenderer extends Renderer3D<GameStuff> {

    private boolean renderDebug;

    @Override
    public void render() {
        ScreenUtils.clear(CLEAR, true);

        spriteBatch.begin();
        stuff.getWorld3D().draw2D(spriteBatch, shapeDrawer, screen.getDynamicCamera());
        spriteBatch.end();

        modelBatch.begin(perspectiveCamera);
        if (renderDebug) stuff.getWorld3D().drawDebug3D(modelBatch);
        else stuff.getWorld3D().draw3D(modelBatch);
        modelBatch.end();

        useStaticCamera();
        spriteBatch.begin();
        for (int i = 0; i < stuff.getLives().length; i++) {
            stuff.getLives()[i].draw(spriteBatch);
        }
        spriteBatch.end();
    }

    public void toggleDebug() {
        renderDebug = !renderDebug;
    }
}