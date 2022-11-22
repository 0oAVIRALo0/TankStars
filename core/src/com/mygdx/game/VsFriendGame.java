//batch.draw(h1, 2560/4.8f, 870, 260, 65);
//batch.draw(h2, 2560/2.89f, 870, 260, 65);
//batch.draw(menu, 0, 880, 64, 58);
//batch.draw(Vs, 2560/3.2f, 860, 80, 80);

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class VsFriendGame implements Screen {
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
    private Rectangle shapeTank1;
    private Rectangle shapeTank2;
    private int width = 2688;
    private int height = 1242;

    public VsFriendGame(Main main) {
        this.main = main;
        batch=new SpriteBatch();
        clouds = new Texture("Terrain/theme1.png");
        clouds.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        terrain = new Texture("Terrain/terrainFinal.png");

        img1 = new Texture("Tanks/tank1.png");
        img2 = new Texture("Tanks/tank_3.png");

        h1 = new Texture("Health/h1.png");
        h2 = new Texture("Health/h2.png");
        menu = new Texture("Health/menu.png");
        Vs = new Texture("Health/vs.png");

        shapeTank1 = new Rectangle();
        shapeTank1.x = 2560/6.6f;
        shapeTank1.y = 260;
        shapeTank1.width = 160;
        shapeTank1.height = 160;

        shapeTank2 = new Rectangle();
        shapeTank2.x = 2560/1.85f;
        shapeTank2.y = 525;
        shapeTank2.width = 160;
        shapeTank2.height = 160;
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
    public void render (float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        main.getbatch().begin();
        main.getbatch().draw(clouds, -220, -100, 2048, 1100);
        main.getbatch().draw(terrain, 0, -180, 1900, 1000);
        main.getbatch().draw(tank1.getimg(), tank1.getrect().x, tank1.getrect().y, tank1.getrect().width, tank1.getrect().height);
        main.getbatch().draw(tank2.getimg(), tank2.getrect().x, tank2.getrect().y, tank2.getrect().width, tank2.getrect().height);
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
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            tank1.getrect().x+=Gdx.graphics.getDeltaTime()*100;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            tank1.getrect().x-=Gdx.graphics.getDeltaTime()*100;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            tank2.getrect().x-=Gdx.graphics.getDeltaTime()*100;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            tank2.getrect().x+=Gdx.graphics.getDeltaTime()*100;
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
