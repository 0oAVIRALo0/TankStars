//batch.draw(h1, 2560/4.8f, 870, 260, 65);
//batch.draw(h2, 2560/2.89f, 870, 260, 65);
//batch.draw(menu, 0, 880, 64, 58);
//batch.draw(Vs, 2560/3.2f, 860, 80, 80);

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game implements Screen {
    private Rectangle settingsBox;
    private Vector3 touch;
    private Main main;
    private Texture h1, h2;
    private Texture Vs;
    private Texture menu;
    private Texture clouds;
    private Tank tank1;
    private Texture img1;
    private Tank tank2;
    private Texture img2;
    private Texture terrain;
    private SpriteBatch batch;
    private Sprite sprite;
    private Rectangle shapeTank1;
    private Rectangle shapeTank2;
    private int width = 2688;
    private int height = 1242;

    public Game(Main main) {
        batch = new SpriteBatch();
        this.main = main;

        clouds = new Texture("Terrain/theme2.png");
        clouds.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        terrain = new Texture("Terrain/terrain1.png");

        img1 = new Texture("Tanks/tank1.png");
        img2 = new Texture("Tanks/tank_3.png");
        tank1=new Tank(img1);
        tank2=new Tank(img2);

        h1 = new Texture("Health/h1.png");
        h2 = new Texture("Health/h2.png");
        menu = new Texture("Health/menu.png");
        Vs = new Texture("Health/vs.png");

        shapeTank1 = new Rectangle();
        shapeTank1.x = 2560/6.6f;
        shapeTank1.y = 338;
        shapeTank1.width = 128;
        shapeTank1.height = 128;

        shapeTank2 = new Rectangle();
        shapeTank2.x = 2560/2.3f;
        shapeTank2.y = 446;
        shapeTank2.width = 128;
        shapeTank2.height = 128;

        settingsBox = new Rectangle();
        settingsBox.x = 0;
        settingsBox.y = 0;
        settingsBox.width = 64;
        settingsBox.height = 58;
    }

    @Override
    public void show() {

    }

    @Override
    public void render (float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        main.getbatch().begin();
        main.getbatch().draw(clouds, 0, 0, width, height);
        main.getbatch().draw(terrain, 0, -290, width, height);
        main.getbatch().draw(tank1.getimg(), shapeTank1.x, shapeTank1.y, shapeTank1.width, shapeTank1.height);
        main.getbatch().draw(tank2.getimg(), shapeTank2.x, shapeTank2.y, shapeTank2.width, shapeTank2.height);
        main.getbatch().draw(h1, 2560/4.85f, 870, 260, 65);
        main.getbatch().draw(h2, 2560/2.89f, 870, 260, 65);
        main.getbatch().draw(menu, settingsBox.x, 880, settingsBox.width, settingsBox.height);
        main.getbatch().draw(Vs, 2560/3.2f, 860, 80, 80);
        main.getbatch().end();

        if (Gdx.input.justTouched()) {
            touch = new Vector3();
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (settingsBox.contains(touch.x, touch.y)) {
                main.setScreen(new GameSettings(main));
                dispose();
            }
        }
    }

    @Override
    public void resize (int width, int height) {
    }

    @Override
    public void pause () {
    }

    @Override
    public void resume () {
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose () {
        tank1.getimg().dispose();
        terrain.dispose();
        clouds.dispose();
        tank2.getimg().dispose();
        h1.dispose();
        h2.dispose();
        menu.dispose();
        Vs.dispose();
    }
}
