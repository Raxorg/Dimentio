package com.epicness.dimentio.game.stuff;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.epicness.dimentio.game.assets.GameAssets;
import com.epicness.dimentio.game.stuff.bidimensional.World2D;
import com.epicness.dimentio.game.stuff.tridimensional.World3D;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Stuff;

public class GameStuff extends Stuff<GameAssets> {

    private World2D world2D;
    private World3D world3D;
    private DualSprited[] lives;

    @Override
    public void initializeStuff() {
        world2D = new World2D(sharedAssets, assets);
        world3D = new World3D(world2D);

        lives = new DualSprited[4];
        for (int i = 0; i < lives.length; i++) {
            lives[i] = new DualSprited(assets.getFadedCircularGlow(), sharedAssets.getCircle());
            lives[i].setBackgroundSize(110f);
            lives[i].setForegroundSize(20f);
            lives[i].setForegroundColor(BLACK);
            lives[i].setOriginCenter();
        }
        lives[0].setOriginBasedPosition(55f, 55f);
        lives[1].setOriginBasedPosition(55f, CAMERA_HEIGHT - lives[1].getBackgroundHeight() + 55f);
        lives[2].setOriginBasedPosition(CAMERA_WIDTH - lives[2].getBackgroundWidth() + 55f, 55f);
        lives[3].setOriginBasedPosition(
            CAMERA_WIDTH - lives[2].getBackgroundWidth() + 55f,
            CAMERA_HEIGHT - lives[1].getBackgroundHeight() + 55f
        );
    }

    public World2D getWorld2D() {
        return world2D;
    }

    public World3D getWorld3D() {
        return world3D;
    }

    public DualSprited[] getLives() {
        return lives;
    }
}