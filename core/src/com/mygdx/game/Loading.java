package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Loading implements Screen {
    Texture tankStarsLogo;
    Sprite sprite;
    Main main;
    Texture loadingScreen;

    public Loading(Main main) {
        this.main = main;

        loadingScreen = new Texture("LoadingScreen/mainLoading.png");
        sprite = new Sprite(loadingScreen);
        sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        loadingScreen.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        tankStarsLogo = new Texture("LoadingScreen/tankstars.png");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        main.batch.begin();
        main.batch.draw(loadingScreen, 0, 0, 1700, 1000);
//        main.batch.draw(loadingPad, 2560/3.88f, 100, 380, 30);
//        main.batch.draw(loadingLine, 2560/3.88f, 110, 280, 10);
        main.batch.draw(tankStarsLogo, 2560/4.1f, 700, 420, 200);

        main.font.draw(main.batch, "", 100, 150);
        main.font.draw(main.batch, "", 100, 100);
        main.batch.end();

        if (Gdx.input.justTouched()) {
            main.setScreen(new MainMenu(main));
            dispose();
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
        loadingScreen.dispose();
    }
}
