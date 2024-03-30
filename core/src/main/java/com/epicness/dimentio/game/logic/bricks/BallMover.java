package com.epicness.dimentio.game.logic.bricks;

import static com.badlogic.gdx.Input.Keys.SPACE;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.dimentio.game.constants.GameConstants.BRICK_BALL_SPEED;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.logic.other.EndingHandler;
import com.epicness.dimentio.game.logic.player.AttackCooldownHandler;
import com.epicness.dimentio.game.logic.player.LifeHandler;
import com.epicness.dimentio.game.logic.player.PlayerMover;
import com.epicness.dimentio.game.stuff.bidimensional.Player;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Rectangle;

public class BallMover extends GameLogicHandler {

    private Player player;
    private Rectangle paddle;
    private SnapshotArray<Rectangle> bricks;
    private Vector2 auxPlayerSpeed;
    private boolean attached, movementEnabled;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        paddle = stuff.getWorld2D().getBricksGame().getPaddle();
        bricks = stuff.getWorld2D().getBricksGame().getBricks();
        auxPlayerSpeed = new Vector2();
        attached = false;
        movementEnabled = false;
    }

    public void launchBall() {
        float angle = MathUtils.randomBoolean() ? 50f : 130f;
        player.getSpeed().set(MathUtils.cosDeg(angle) * BRICK_BALL_SPEED, MathUtils.sinDeg(angle) * BRICK_BALL_SPEED);
        movementEnabled = true;
    }

    @Override
    protected void update(float delta) {
        if (attached) player.setX(paddle.x + paddle.width / 2f);

        if (!movementEnabled) return;

        auxPlayerSpeed.set(player.getSpeed()).scl(delta);
        player.translate(auxPlayerSpeed);
        checkCollisions();
        logic.get(BoundsHandler.class).checkBounds();
    }

    private void checkCollisions() {
        Rectangle brick;
        bricks.begin();
        for (int i = 0; i < bricks.size; i++) {
            brick = bricks.get(i);
            if (Intersector.overlaps(player.getCircle(), brick)) {
                collide(brick);
                if (bricks.size == 0) {
                    logic.get(LimitHandler.class).hideLimits();
                    logic.get(ActivationHandler.class).completeLastActivator();
                    logic.get(ActivatorAnimator.class).setProximityFadeEnabled(true);
                    logic.get(PlayerMover.class).setEnabled(true);
                    logic.get(PaddleHandler.class).hidePaddle();
                    logic.get(LifeHandler.class).gainLives();
                    logic.get(LifeHandler.class).gainLives();
                    logic.get(EndingHandler.class).completeLevel();
                    player.setBaseColor(WHITE);
                    assets.getFuturistic().play();
                    movementEnabled = false;
                }
                break;
            }
        }
        bricks.end();
    }

    private void collide(Rectangle brick) {
        float xTranslation = auxPlayerSpeed.x;
        float yTranslation = auxPlayerSpeed.y;

        player.translateX(-xTranslation);
        if (!Intersector.overlaps(player.getCircle(), brick)) {
            player.getSpeed().setAngleDeg(270f + (270f - player.getSpeed().angleDeg()));
        }
        player.translateX(xTranslation);

        player.translateY(-yTranslation);
        if (!Intersector.overlaps(player.getCircle(), brick)) {
            player.getSpeed().setAngleDeg(180f + (180f - player.getSpeed().angleDeg()));
        }
        player.translateY(yTranslation);

        assets.getHit().play();
        bricks.removeValue(brick, true);
    }

    @Override
    public void keyDown(int keycode) {
        if (keycode == SPACE && !logic.get(AttackCooldownHandler.class).isOnCooldown()
            && logic.get(PaddleHandler.class).isMovementEnabled() && attached) {
            attached = false;
            launchBall();
        }
    }

    public void attachToPaddle() {
        attached = true;
    }

    public void disableMovement() {
        movementEnabled = false;
    }
}