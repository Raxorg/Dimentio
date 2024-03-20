package com.epicness.dimentio.game.logic.other;

import static com.badlogic.gdx.Input.Keys.F;
import static com.epicness.dimentio.game.GameConstants.PLAYER_RADIUS;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.dimentio.game.stuff.bidimensional.Player;

public class CameraHandler extends GameLogicHandler {

    private PerspectiveCamera camera;
    private Vector3 cameraDirection;
    private Vector2 pivot;
    private boolean free;
    private Player player;
    private float lastPlayerX, lastPlayerY, deltaX, deltaY, dragDeltaX, dragDeltaY;

    @Override
    protected void init() {
        camera = renderer.getPerspectiveCamera();
        camera.direction.set(0, 0, -1);
        camera.up.set(0, 1, 0);
        camera.position.set(0f, 0f, 15.5f);
        camera.update();
        cameraDirection = new Vector3();

        pivot = new Vector2();
        free = false;
        player = stuff.getWorld2D().getPlayer();
        lastPlayerX = CAMERA_HALF_WIDTH - PLAYER_RADIUS;
        deltaX = deltaY = dragDeltaX = dragDeltaY = 0f;
    }

    @Override
    public void update(float delta) {
        rotateX();
        //rotateY();
        camera.update();

        lastPlayerX = player.getX();
        lastPlayerY = player.getY();
    }

    private void rotateX() {
        deltaX = player.getX() - lastPlayerX;
        deltaX = MathUtils.map(0f, CAMERA_WIDTH, 0f, 45f, deltaX);
        camera.rotateAround(Vector3.Zero, Vector3.Y, deltaX);
    }

    private void rotateY() {
        deltaY = lastPlayerY - player.getY();
        deltaY = MathUtils.map(0f, CAMERA_HEIGHT, 0f, 45f, deltaY);
        System.out.println(deltaY);
        cameraDirection.set(camera.direction);
        camera.rotateAround(Vector3.Zero, cameraDirection.crs(Vector3.Y), deltaY);
    }

    @Override
    public void touchDown(float x, float y, int button) {
        if (!free) return;
        pivot.set(x, y);
    }

    @Override
    public void touchDragged(float x, float y) {
        if (!free) return;

        dragDeltaX = MathUtils.clamp(pivot.x - x, -10f, 10f) / 3f;
        dragDeltaY = MathUtils.clamp(y - pivot.y, -10f, 10f) / 3f;

        camera.rotateAround(Vector3.Zero, Vector3.Y, dragDeltaX);
        cameraDirection.set(camera.direction);
        camera.rotateAround(Vector3.Zero, cameraDirection.crs(Vector3.Y), dragDeltaY);
        if (camera.direction.y < -0.9f || camera.direction.y > 0.9f) {
            camera.rotateAround(Vector3.Zero, Vector3.Y, -dragDeltaX);
            camera.rotateAround(Vector3.Zero, cameraDirection, -dragDeltaY);
        }
        camera.update();
        pivot.set(x, y);
    }

    @Override
    public void keyDown(int keycode) {
        if (keycode == F) {
            free = !free;
        }
    }
}