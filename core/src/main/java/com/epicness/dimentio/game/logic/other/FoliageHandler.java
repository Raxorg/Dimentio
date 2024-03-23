package com.epicness.dimentio.game.logic.other;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.epicness.dimentio.game.constants.GameConstants.WORLD_2D_BORDER_HEIGHT;
import static com.epicness.dimentio.game.constants.GameConstants.FOLIAGE_COLORS;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.dimentio.game.logic.GameLogicHandler;
import com.epicness.fundamentals.stuff.DualSprited;

import java.util.List;

public class FoliageHandler extends GameLogicHandler {

    private List<DualSprited> foliage;
    private float time;
    private DualSprited leaf;

    @Override
    protected void init() {
        foliage = stuff.getWorld2D().getFoliage();
        DualSprited leaf;
        float x = CAMERA_WIDTH;
        Color color = new Color();
        for (int i = 0; i < 4; i++, x += CAMERA_WIDTH * 2f) {
            for (int j = 0; j < 30; j++) {
                leaf = new DualSprited(assets.getLeaf1Inner(), assets.getLeaf1Border());

                leaf.setX(x + MathUtils.random(CAMERA_WIDTH - leaf.getWidth()));
                leaf.setY(WORLD_2D_BORDER_HEIGHT);

                leaf.setOrigin(leaf.getWidth() / 2f, 0f);
                leaf.setScale(MathUtils.random(0.5f, 2f));

                leaf.setFlip(MathUtils.randomBoolean(), MathUtils.randomBoolean());

                color.set(FOLIAGE_COLORS.random());
                leaf.setForegroundColor(color);
                leaf.setBackgroundColor(color.lerp(CLEAR, 0.4f));

                leaf.useBilinearFilter();

                foliage.add(leaf);
            }
        }
    }

    @Override
    protected void update(float delta) {
        time += delta / 5f;
        float offset, a;
        Color color;
        for (int i = 0; i < foliage.size(); i++) {
            leaf = foliage.get(i);
            color = leaf.getForegroundColor();
            offset = MathUtils.map(0, (foliage.size() - 1) / 4f, 0f, 1f, i);
            a = (time + offset) % 1f;
            a = a >= 0.5f ? 1f - a : a;
            a = MathUtils.lerp(0.5f, 2f, a);
            leaf.setForegroundColor(color.r, color.g, color.b, a);
            leaf.setBackgroundColor(color.r, color.g, color.b, MathUtils.clamp(a - 0.4f, 0f, 0.4f));
        }
    }
}