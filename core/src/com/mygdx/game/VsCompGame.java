package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class VsCompGame implements Screen {
    Main main;
    private Rectangle settingsBox;
    private Vector3 touch;
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
    private Rectangle shapeTank1;
    private Rectangle shapeTank2;
    private int width = 2688;
    private int height = 1242;

    public VsCompGame(Main main) {
        this.main = main;

        this.main = main;
        batch=new SpriteBatch();
        clouds = new Texture("Terrain/theme3.png");
        clouds.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        terrain = new Texture("Terrain/terrain1.png");

        img1 = new Texture("Tanks/tank1.png");
        img2 = new Texture("Tanks/tank_3.png");

        h1 = new Texture("Health/h1.png");
        h2 = new Texture("Health/h2.png");
        menu = new Texture("Health/menu.png");
        Vs = new Texture("Health/vs.png");

        shapeTank1 = new Rectangle();
        shapeTank1.x = 2560/6.6f;
        shapeTank1.y = 348;
        shapeTank1.width = 128;
        shapeTank1.height = 128;

        shapeTank2 = new Rectangle();
        shapeTank2.x = 2560/2.3f;
        shapeTank2.y = 457;
        shapeTank2.width = 128;
        shapeTank2.height = 128;
        tank1=new Tank(img1,shapeTank1);
        tank2=new Tank(img2,shapeTank2);

        settingsBox = new Rectangle();
        settingsBox.x = 0;
        settingsBox.y = 0;
        settingsBox.width = 66;
        settingsBox.height = 58;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        main.getbatch().begin();
        main.getbatch().draw(clouds, -220, -100, 2048, 1100);
        main.getbatch().draw(terrain, 0, -280, width, height);
        main.getbatch().draw(tank1.getimg(), tank1.getrect().x, tank1.getrect().y, tank1.getrect().width, tank1.getrect().height);
        main.getbatch().draw(tank2.getimg(), tank2.getrect().x, tank2.getrect().y, tank2.getrect().width, tank2.getrect().height);
        main.getbatch().draw(h1, 2560/5.18f, 870, 290, 75);
        main.getbatch().draw(h2, 2560/2.87f, 870, 290, 75);
        main.getbatch().draw(menu, settingsBox.x, 880, settingsBox.width, settingsBox.height);
        main.getbatch().draw(Vs, 2560/3.2f, 860, 80, 80);
        main.getbatch().end();

        if (Gdx.input.justTouched()) {
            touch = new Vector3();
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (settingsBox.contains(touch.x, touch.y)) {
                main.setScreen(new vsCompGameSettings(main));
                dispose();
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            tank1.getrect().x+=Gdx.graphics.getDeltaTime()*100;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            tank1.getrect().x-=Gdx.graphics.getDeltaTime()*100;
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
