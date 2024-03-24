package com.epicness.dimentio.game.logic.bricks;

import static com.epicness.dimentio.game.constants.GameConstants.PLAYER_STARTING_PADDLE_Y;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.logic.player.PlayerMover;
import com.epicness.dimentio.game.stuff.bidimensional.Activator;
import com.epicness.dimentio.game.stuff.bidimensional.Player;

public class ActivationHandler extends GameLogicHandler {

    private Activator[] activators;
    private Activator activatedActivator;
    private Player player;
    private Vector2 playerCenter, auxVector, lerpVector;
    private float progress;
    private boolean activating, step1, enabled;

    @Override
    protected void init() {
        activators = stuff.getWorld2D().getBricksGame().getActivators();
        for (int i = 0; i < activators.length; i++) {
            activators[i].setActivated(false);
            activators[i].setSpeedFactor(1f);
        }
        player = stuff.getWorld2D().getPlayer();
        playerCenter = new Vector2();
        auxVector = new Vector2();
        lerpVector = new Vector2();
        progress = 0f;
        activating = false;
        enabled = true;
    }

    public void checkActivation() {
        if (activating || !enabled) return;

        float distance;
        for (int i = 0; i < activators.length; i++) {
            distance = player.getCenter(playerCenter).dst(activators[i].getMid().getCenter(auxVector));
            if (!activators[i].isActivated() && distance < 145f) {
                activatedActivator = activators[i];
                beginActivation();
                enabled = false;
                return;
            }
        }
    }

    private void beginActivation() {
        logic.get(PlayerMover.class).setEnabled(false);
        logic.get(ActivatorAnimator.class).setProximityFadeEnabled(false);
        assets.getWisp().play(1f, 0.5f, 0f);
        step1 = true;
        progress = 0f;
        activating = true;
    }

    @Override
    protected void update(float delta) {
        if (!activating) return;

        progress = Math.min(progress + delta * 0.75f, 1f);
        if (step1) {
            handleStep1();
        } else {
            handleStep2();
        }
    }

    private void handleStep1() {
        lerpVector.set(playerCenter);
        player.setPosition(lerpVector.lerp(auxVector, Interpolation.circleOut.apply(progress)));
        activatedActivator.setSpeedFactor(activatedActivator.getSpeedFactor() + progress * 2f);
        if (progress == 1f) {
            player.getCenter(playerCenter);
            logic.get(PaddleHandler.class).showPaddle(playerCenter.x);
            logic.get(BrickHandler.class).spawnBricks(activatedActivator.level);
            logic.get(LimitHandler.class).showLimits(playerCenter.x, activatedActivator.level.color);
            player.setBaseColor(activatedActivator.level.color);
            auxVector.set(playerCenter.x, PLAYER_STARTING_PADDLE_Y);
            step1 = false;
            progress = 0f;
        }
    }

    private void handleStep2() {
        activatedActivator.setAlpha(1f - progress);
        lerpVector.set(playerCenter);
        player.setPosition(lerpVector.lerp(auxVector, Interpolation.circleOut.apply(progress)));
        if (progress == 1f) {
            activating = false;
        }
    }

    public void completeLastActivator() {
        activatedActivator.setActivated(true);
        activatedActivator.setSpeedFactor(1f);
        activatedActivator.setAlpha(1f);
        enabled = true;
    }
}