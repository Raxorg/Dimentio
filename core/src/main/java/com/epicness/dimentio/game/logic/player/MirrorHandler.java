package com.epicness.dimentio.game.logic.player;

import static com.epicness.dimentio.game.GameConstants.WORLD_WIDTH_2D;

import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;

public class MirrorHandler extends GameLogicHandler {

    private Player player, playerMirror;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        playerMirror = stuff.getWorld2D().getPlayerMirror();
    }

    @Override
    protected void update(float delta) {
        if (player.getEndX() >= WORLD_WIDTH_2D) {
            player.setX(player.getX() - WORLD_WIDTH_2D);
        }
        if (player.getEndX() <= 0f) {
            player.setX(player.getX() + WORLD_WIDTH_2D);
        }
        playerMirror.setPosition(player.getX() + WORLD_WIDTH_2D, player.getY());
    }
}