package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class savedGames implements Screen {
    private Main main;
    private Texture background;
    private Texture game1;
    private Texture game2;
    private Texture game3;
    private Texture game4;
    private Texture game5;
    private Texture back;
    private Rectangle backBox;
    private Vector3 touch;

    public savedGames(Main main) {
        this.main = main;

        background = new Texture("SavedGames/background.png");
        game1 = new Texture("SavedGames/savedGame1.png");
        game2 = new Texture("SavedGames/savedGame2.png");
        game3 = new Texture("SavedGames/savedGame3.png");
        game4 = new Texture("SavedGames/savedGame4.png");
        game5 = new Texture("SavedGames/savedGame5.png");
        back = new Texture("SavedGames/back.png");

        backBox = new Rectangle();
        backBox.x = 0;
        backBox.y = 0;
        backBox.width = 64;
        backBox.height = 64;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        main.getbatch().begin();
        main.getbatch().draw(background, -505, -268, 2688, 1480);
        main.getbatch().draw(game1, 2560/4.2f, 710, 440, 112);
        main.getbatch().draw(game2, 2560/4.2f, 560, 440, 112);
        main.getbatch().draw(game3, 2560/4.2f, 415, 440, 112);
        main.getbatch().draw(game4, 2560/4.2f, 265, 440, 112);
        main.getbatch().draw(game5, 2560/4.2f, 115, 440, 112);
        main.getbatch().draw(back, 30, 850, 44, 64);
        main.getbatch().end();

        if (Gdx.input.justTouched()) {
            touch = new Vector3();
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (backBox.contains(touch.x, touch.y)) {
                main.setScreen(new MainMenu(main));
                dispose();
            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        game1.dispose();
        game2.dispose();
        game3.dispose();
        game4.dispose();
        game5.dispose();
        back.dispose();
    }
}
