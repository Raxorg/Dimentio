package com.epicness.dimentio.game.logic.bricks;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Activator;
import com.epicness.dimentio.game.stuff.bidimensional.Player;

public class ActivatorHandler extends GameLogicHandler {

    private Activator[] activators;
    private Player player;
    private Vector2 aux1, aux2;

    @Override
    protected void init() {
        activators = stuff.getWorld2D().getBricksGame().getActivators();
        for (int i = 0; i < activators.length; i++) {
            activators[i].setActivated(false);
        }
        player = stuff.getWorld2D().getPlayer();
        aux1 = new Vector2();
        aux2 = new Vector2();
    }

    @Override
    protected void update(float delta) {
        rotate(delta);
        checkProximity();
    }

    private void rotate(float delta) {
        for (int i = 0; i < activators.length; i++) {
            activators[i].getInner().rotate((10f + i * 10f) * delta);
            activators[i].getMid().rotate((-10f - i * 20f) * delta);
            activators[i].getOuter().rotate((10f + i * 30f) * delta);
        }
    }

    private void checkProximity() {
        float distance, alpha;
        for (int i = 0; i < activators.length; i++) {
            if (activators[i].isActivated()) continue;

            distance = player.getCenter(aux1).dst(activators[i].getMid().getCenter(aux2));
            alpha = MathUtils.clamp(MathUtils.map(100f, 1000f, 1f, 0f, distance), 0f, 1f);
            activators[i].setAlpha(alpha);
        }
    }
}