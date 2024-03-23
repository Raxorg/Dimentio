package com.epicness.dimentio.game.logic.bricks;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Activator;
import com.epicness.dimentio.game.stuff.bidimensional.Player;

public class ActivatorAnimator extends GameLogicHandler {

    private Activator[] activators;
    private Player player;
    private Vector2 aux1, aux2;
    private boolean proximityFadeEnabled;

    @Override
    protected void init() {
        activators = stuff.getWorld2D().getBricksGame().getActivators();
        player = stuff.getWorld2D().getPlayer();
        aux1 = new Vector2();
        aux2 = new Vector2();
        proximityFadeEnabled = true;
    }

    @Override
    protected void update(float delta) {
        rotate(delta);
        proximityFade();
    }

    private void rotate(float delta) {
        for (int i = 0; i < activators.length; i++) {
            activators[i].getInner().rotate((i + 1) * 15f * delta * activators[i].getSpeedFactor());
            activators[i].getMid().rotate((i + 1) * -25f * delta * activators[i].getSpeedFactor());
            activators[i].getOuter().rotate((i + 1) * 35f * delta * activators[i].getSpeedFactor());
        }
    }

    private void proximityFade() {
        if (!proximityFadeEnabled) return;

        float distance, alpha;
        for (int i = 0; i < activators.length; i++) {
            if (activators[i].isActivated()) continue;

            distance = player.getCenter(aux1).dst(activators[i].getMid().getCenter(aux2));
            alpha = MathUtils.clamp(MathUtils.map(100f, 1000f, 1f, 0f, distance), 0f, 1f);
            activators[i].setAlpha(alpha);
        }
    }

    public void setProximityFadeEnabled(boolean enabled) {
        proximityFadeEnabled = enabled;
    }
}