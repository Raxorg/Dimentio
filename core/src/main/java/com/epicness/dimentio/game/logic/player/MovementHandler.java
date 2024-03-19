package com.epicness.dimentio.game.logic.player;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.W;

import com.badlogic.gdx.math.Vector2;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;

public class MovementHandler extends GameLogicHandler {

    private Player player;
    private Vector2 aux;

    @Override
    protected void init() {
        player = stuff.getWorld2D().getPlayer();
        aux = new Vector2();
    }

    @Override
    protected void update(float delta) {
        aux.set(player.getSpeed()).scl(delta);
        player.translate(aux);
    }

    @Override
    public void keyDown(int keycode) {
        switch (keycode) {
            case W:
                player.getSpeed().y += 100f;
                break;
            case A:
                player.getSpeed().x -= 100f;
                break;
            case S:
                player.getSpeed().y -= 100f;
                break;
            case D:
                player.getSpeed().x += 100f;
                break;
        }
    }

    @Override
    public void keyUp(int keycode) {
        switch (keycode) {
            case W:
                player.getSpeed().y -= 100f;
                break;
            case A:
                player.getSpeed().x += 100f;
                break;
            case S:
                player.getSpeed().y += 100f;
                break;
            case D:
                player.getSpeed().x -= 100f;
                break;
        }
    }
}