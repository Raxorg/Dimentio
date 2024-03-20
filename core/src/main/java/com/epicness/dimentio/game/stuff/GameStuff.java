package com.epicness.dimentio.game.stuff;

import com.epicness.dimentio.game.assets.GameAssets;
import com.epicness.dimentio.game.stuff.bidimensional.World2D;
import com.epicness.dimentio.game.stuff.tridimensional.World3D;
import com.epicness.fundamentals.stuff.Stuff;

public class GameStuff extends Stuff<GameAssets> {

    private World2D world2D;
    private World3D world3D;

    @Override
    public void initializeStuff() {
        world2D = new World2D(sharedAssets, assets);
        world3D = new World3D(world2D);
    }

    public World2D getWorld2D() {
        return world2D;
    }

    public World3D getWorld3D() {
        return world3D;
    }
}