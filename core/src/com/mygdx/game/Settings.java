package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;

public class Settings implements Screen {
    Rectangle crossBox;
    SpriteBatch batch;
    Texture settings;
    Texture cross;
    Main main;
    Image img;
    Stage stage;
    public Settings(Main main) {
        this.main = main;
        batch = new SpriteBatch();
        settings = new Texture("Settings/settings_1.png");
        cross = new Texture("Settings/cros.png");

        crossBox = new Rectangle();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
//        ScreenUtils.clear(0, 0, 0.2f, 1);
        main.batch.begin();
        main.batch.draw(settings, 2560/4.4f, 200, 600, 600);
        main.batch.draw(cross, );
        main.batch.end();
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
        settings.dispose();
    }
}
