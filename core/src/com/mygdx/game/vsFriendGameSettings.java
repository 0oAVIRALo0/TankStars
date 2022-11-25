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

public class vsFriendGameSettings implements Screen {

    private ShapeRenderer shapeRenderer;
    private Vector3 touch1;
    private Vector3 touch2;
    private Rectangle menuBox;
    private Rectangle resumeBox;
    private SpriteBatch batch;
    private Texture settings;
    private Texture cross;
    private Main main;
    private Image img;
    private Stage stage;

    public vsFriendGameSettings(Main main) {
        shapeRenderer = new ShapeRenderer();
        this.main = main;
        batch = new SpriteBatch();
        settings = new Texture("Settings/settingCropped2.png");
        cross = new Texture("Settings/cros.png");

        menuBox = new Rectangle();
        menuBox.x = 2560 / 3.2f;
        menuBox.y = 620;
        menuBox.width = 128;
        menuBox.height = 128;

        resumeBox = new Rectangle();
        resumeBox.x = 2560 / 3.2f;
        resumeBox.y = 180;
        resumeBox.width = 128;
        resumeBox.height = 128;


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        main.getbatch().begin();
        main.getbatch().draw(settings, 2560/4.4f, 200, 600, 600);
        main.getbatch().draw(cross, 2560/2.27f, 745, 24, 24);
        main.getbatch().end();

        if (Gdx.input.justTouched()) {
            touch1 = new Vector3();
            touch1.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (menuBox.contains(touch1.x, touch1.y)) {
                main.setScreen(new MainMenu(main));
                dispose();
            }
        }

        if (Gdx.input.justTouched()) {
            touch2 = new Vector3();
            touch2.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (resumeBox.contains(touch2.x, touch2.y)) {
                main.setScreen(new VsFriendGame(main));
                dispose();
            }
        }

//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//        shapeRenderer.rect(resumeBox.x, resumeBox.y, resumeBox.width, resumeBox.height);
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

    }
}
