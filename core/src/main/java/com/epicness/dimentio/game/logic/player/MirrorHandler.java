package com.epicness.dimentio.game.logic.player;

import static com.epicness.dimentio.game.GameConstants.WORLD_WIDTH_2D;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.fundamentals.stuff.interfaces.Transformable;

public class MirrorHandler extends GameLogicHandler {

    private Array<Transformable> originals, mirrors;

    @Override
    protected void init() {
        originals = new SnapshotArray<>();
        originals.add(stuff.getWorld2D().getPlayer());
        originals.add(stuff.getWorld2D().getPlayerAttack());

        mirrors = new SnapshotArray<>();
        mirrors.add(stuff.getWorld2D().getPlayerMirror());
        mirrors.add(stuff.getWorld2D().getPlayerAttackMirror());
    }

    @Override
    protected void update(float delta) {
        Transformable original, mirror;
        for (int i = 0; i < originals.size; i++) {
            original = originals.get(i);
            mirror = mirrors.get(i);
            if (original.getEndX() >= WORLD_WIDTH_2D) {
                original.setX(original.getX() - WORLD_WIDTH_2D);
            }
            if (original.getEndX() <= 0f) {
                original.setX(original.getX() + WORLD_WIDTH_2D);
            }
            mirror.setPosition(original.getX() + WORLD_WIDTH_2D, original.getY());
        }
    }

    public void registerTransformablePair(Transformable original, Transformable mirror) {
        originals.add(original);
        mirrors.add(mirror);
        System.out.println(originals.size);
    }

    public void removeTransformablePair(Transformable original, Transformable mirror) {
        originals.removeValue(original, true);
        mirrors.removeValue(mirror, true);
    }
}