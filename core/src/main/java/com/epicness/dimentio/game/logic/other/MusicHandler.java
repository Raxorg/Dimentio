package com.epicness.dimentio.game.logic.other;

import com.epicness.dimentio.game.logic.GameLogicHandler;

public class MusicHandler extends GameLogicHandler {

    private int track;

    @Override
    protected void init() {
        track = 0;
    }

    @Override
    protected void update(float delta) {
        if (!anyMusicPlaying()) {
            switch (track) {
                case 1:
                    assets.getKOLMOSTCountingDownTheHours().play();
                    track++;
                    break;
                case 2:
                    assets.getKOLMOSTASecondChance().play();
                    track++;
                    break;
                case 3:
                    assets.getKOLMOSTTitle().play();
                    track = 1;
                    break;
            }
        }
    }

    @Override
    public void touchDown(float x, float y, int button) {
        if (track != 0) return;

        track = 1;
    }

    @Override
    public void keyDown(int keycode) {
        if (track != 0) return;

        track = 1;
    }

    private boolean anyMusicPlaying() {
        return assets.getKOLMOSTTitle().isPlaying()
            || assets.getKOLMOSTCountingDownTheHours().isPlaying()
            || assets.getKOLMOSTASecondChance().isPlaying();
    }
}