package com.epicness.dimentio.game.logic.bricks;

import static com.epicness.dimentio.game.constants.GameConstants.PADDLE_TOP;
import static com.epicness.dimentio.game.constants.GameConstants.PLAYER_INNER_RADIUS;
import static com.epicness.dimentio.game.constants.GameConstants.WORLD_2D_BORDER_HEIGHT;
import static com.epicness.dimentio.game.constants.GameConstants.WORLD_2D_TOP;

import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Line;

public class BoundsHandler extends GameLogicHandler {

    private Player player;
    private Line leftLimit, rightLimit;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        leftLimit = stuff.getWorld2D().getBricksGame().getLeftLimit();
        rightLimit = stuff.getWorld2D().getBricksGame().getRightLimit();
    }

    public void checkBounds() {
        float angle = player.getSpeed().angleDeg();
        if (player.getY() + PLAYER_INNER_RADIUS > WORLD_2D_TOP) {
            player.setY(WORLD_2D_TOP - PLAYER_INNER_RADIUS);
            angle = 180f + (180f - angle);
        }
        if (player.getY() + PLAYER_INNER_RADIUS < WORLD_2D_BORDER_HEIGHT) {
            player.setY(PADDLE_TOP + PLAYER_INNER_RADIUS);
            logic.get(BrickHandler.class).restartLevel();
            logic.get(BallMover.class).attachToPaddle();
            logic.get(BallMover.class).disableMovement();
            assets.getDead().play();
        }
        if (player.getX() - PLAYER_INNER_RADIUS < leftLimit.getX()) {
            player.setX(leftLimit.getX() + PLAYER_INNER_RADIUS);
            angle = 270f + (270f - angle);
        }
        if (player.getX() + PLAYER_INNER_RADIUS > rightLimit.getX()) {
            player.setX(rightLimit.getX() - PLAYER_INNER_RADIUS);
            angle = 270f + (270f - angle);
        }
        player.getSpeed().setAngleDeg(angle);
    }
}