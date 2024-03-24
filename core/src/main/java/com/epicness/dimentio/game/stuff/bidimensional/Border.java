package com.epicness.dimentio.game.stuff.bidimensional;

import static com.badlogic.gdx.graphics.Color.BLUE;
import static com.badlogic.gdx.graphics.Color.GREEN;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.badlogic.gdx.graphics.Color.YELLOW;
import static com.epicness.dimentio.game.constants.GameConstants.WORLD_2D_BORDER_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.epicness.fundamentals.stuff.shapes.bidimensional.Line;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Border {

    private final Line top1, top2, top3, top4, top5, top6, top7, top8;
    private final Line bottom1, bottom2, bottom3, bottom4, bottom5, bottom6, bottom7, bottom8;

    public Border() {
        top1 = new Line(0f, CAMERA_HEIGHT, CAMERA_WIDTH, CAMERA_HEIGHT, WORLD_2D_BORDER_HEIGHT * 2f, RED, RED);
        top2 = new Line(CAMERA_WIDTH, CAMERA_HEIGHT, CAMERA_WIDTH * 2f, CAMERA_HEIGHT, WORLD_2D_BORDER_HEIGHT * 2f, RED, GREEN);
        top3 = new Line(CAMERA_WIDTH * 2f, CAMERA_HEIGHT, CAMERA_WIDTH * 3f, CAMERA_HEIGHT, WORLD_2D_BORDER_HEIGHT * 2f, GREEN, GREEN);
        top4 = new Line(CAMERA_WIDTH * 3f, CAMERA_HEIGHT, CAMERA_WIDTH * 4f, CAMERA_HEIGHT, WORLD_2D_BORDER_HEIGHT * 2f, GREEN, BLUE);
        top5 = new Line(CAMERA_WIDTH * 4f, CAMERA_HEIGHT, CAMERA_WIDTH * 5f, CAMERA_HEIGHT, WORLD_2D_BORDER_HEIGHT * 2f, BLUE, BLUE);
        top6 = new Line(CAMERA_WIDTH * 5f, CAMERA_HEIGHT, CAMERA_WIDTH * 6f, CAMERA_HEIGHT, WORLD_2D_BORDER_HEIGHT * 2f, BLUE, YELLOW);
        top7 = new Line(CAMERA_WIDTH * 6f, CAMERA_HEIGHT, CAMERA_WIDTH * 7f, CAMERA_HEIGHT, WORLD_2D_BORDER_HEIGHT * 2f, YELLOW, YELLOW);
        top8 = new Line(CAMERA_WIDTH * 7f, CAMERA_HEIGHT, CAMERA_WIDTH * 8f, CAMERA_HEIGHT, WORLD_2D_BORDER_HEIGHT * 2f, YELLOW, RED);

        bottom1 = new Line(0f, 0f, CAMERA_WIDTH, 0f, WORLD_2D_BORDER_HEIGHT * 2f, RED, RED);
        bottom2 = new Line(CAMERA_WIDTH, 0f, CAMERA_WIDTH * 2f, 0f, WORLD_2D_BORDER_HEIGHT * 2f, RED, GREEN);
        bottom3 = new Line(CAMERA_WIDTH * 2f, 0f, CAMERA_WIDTH * 3f, 0f, WORLD_2D_BORDER_HEIGHT * 2f, GREEN, GREEN);
        bottom4 = new Line(CAMERA_WIDTH * 3f, 0f, CAMERA_WIDTH * 4f, 0f, WORLD_2D_BORDER_HEIGHT * 2f, GREEN, BLUE);
        bottom5 = new Line(CAMERA_WIDTH * 4f, 0f, CAMERA_WIDTH * 5f, 0f, WORLD_2D_BORDER_HEIGHT * 2f, BLUE, BLUE);
        bottom6 = new Line(CAMERA_WIDTH * 5f, 0f, CAMERA_WIDTH * 6f, 0f, WORLD_2D_BORDER_HEIGHT * 2f, BLUE, YELLOW);
        bottom7 = new Line(CAMERA_WIDTH * 6f, 0f, CAMERA_WIDTH * 7f, 0f, WORLD_2D_BORDER_HEIGHT * 2f, YELLOW, YELLOW);
        bottom8 = new Line(CAMERA_WIDTH * 7f, 0f, CAMERA_WIDTH * 8f, 0f, WORLD_2D_BORDER_HEIGHT * 2f, YELLOW, RED);
    }

    public void draw(ShapeDrawer shapeDrawer) {
        top1.draw(shapeDrawer);
        top2.draw(shapeDrawer);
        top3.draw(shapeDrawer);
        top4.draw(shapeDrawer);
        top5.draw(shapeDrawer);
        top6.draw(shapeDrawer);
        top7.draw(shapeDrawer);
        top8.draw(shapeDrawer);

        bottom1.draw(shapeDrawer);
        bottom2.draw(shapeDrawer);
        bottom3.draw(shapeDrawer);
        bottom4.draw(shapeDrawer);
        bottom5.draw(shapeDrawer);
        bottom6.draw(shapeDrawer);
        bottom7.draw(shapeDrawer);
        bottom8.draw(shapeDrawer);
    }
}