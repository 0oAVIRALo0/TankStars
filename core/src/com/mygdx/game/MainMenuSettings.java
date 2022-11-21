package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MainMenuSettings implements Screen {
    ShapeRenderer shapeRenderer;
    Vector3 touch;
    Rectangle crossBox;
    SpriteBatch batch;
    Texture settings;
    Texture cross;
    Main main;
    Image img;
    Stage stage;
    public MainMenuSettings(Main main) {
        shapeRenderer = new ShapeRenderer();
        this.main = main;
        batch = new SpriteBatch();
        settings = new Texture("Settings/settingCropped2.png");
        cross = new Texture("Settings/cros.png");

        crossBox = new Rectangle();
        crossBox.x = 2560/2.29f;
        crossBox.y = 150;
        crossBox.width = 128;
        crossBox.height = 128;


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
//        ScreenUtils.clear(0, 0, 0.2f, 1);
        main.batch.begin();
        main.batch.draw(settings, 2560/4.4f, 200, 600, 600);
        main.batch.draw(cross, 2560/2.27f, 745, 24, 24);
        main.batch.end();

        if (Gdx.input.justTouched()) {
            touch = new Vector3();
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (crossBox.contains(touch.x, touch.y)) {
                main.setScreen(new MainMenu(main));
                dispose();
            }
        }

//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//        shapeRenderer.rect(crossBox.x, crossBox.y, crossBox.width, crossBox.height);
//        shapeRenderer.end();
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
        cross.dispose();
    }
}
