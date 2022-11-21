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
    Rectangle settingsBox;
    Vector3 touch;
    Main main;
    Texture h1, h2;
    Texture Vs;
    Texture menu;
    Texture clouds;
    Texture tank1;
    Texture tank2;
    Texture terrain;
    SpriteBatch batch;
    Sprite sprite;
    Rectangle shapeTank1;
    Rectangle shapeTank2;
    int width = 2688;
    int height = 1242;

    public Game(Main main) {
        this.main = main;

        clouds = new Texture("Terrain/theme2.png");
        clouds.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        terrain = new Texture("Terrain/terrain1.png");

        tank1 = new Texture("Tanks/tank1.png");
        tank2 = new Texture("Tanks/tank_3.png");

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
        main.batch.begin();
        main.batch.draw(clouds, 0, 0, width, height);
        main.batch.draw(terrain, 0, -290, width, height);
        main.batch.draw(tank1, shapeTank1.x, shapeTank1.y, shapeTank1.width, shapeTank1.height);
        main.batch.draw(tank2, shapeTank2.x, shapeTank2.y, shapeTank2.width, shapeTank2.height);
        main.batch.draw(h1, 2560/4.85f, 870, 260, 65);
        main.batch.draw(h2, 2560/2.89f, 870, 260, 65);
        main.batch.draw(menu, settingsBox.x, 880, settingsBox.width, settingsBox.height);
        main.batch.draw(Vs, 2560/3.2f, 860, 80, 80);
        main.batch.end();

        if (Gdx.input.justTouched()) {
            touch = new Vector3();
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (settingsBox.contains(touch.x, touch.y)) {
                main.setScreen(new Settings(main));
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
        tank1.dispose();
        terrain.dispose();
        clouds.dispose();
        tank2.dispose();
        h1.dispose();
        h2.dispose();
        menu.dispose();
        Vs.dispose();
    }
}
