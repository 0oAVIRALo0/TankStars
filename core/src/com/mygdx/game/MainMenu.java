package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainMenu implements Screen {
    Texture settingIcon;
    Rectangle vsCompBox;
    Rectangle settingBox;
    Vector3 touch1;
    Vector3 touch2;
    Texture arrowLeft;
    Texture arrowRight;
    Texture tank1;
    Texture tankstarslogo;
    Texture vsComp;
    Texture vsFriend;
    Texture bg;
    Texture bg1;
    SpriteBatch batch;
    Main main;

    public MainMenu(Main main) {
        this.main = main;
        batch = new SpriteBatch();

        tankstarslogo = new Texture("MainMenu/tankstars.png");
        vsComp = new Texture("MainMenu/vsComputer.png");
        vsFriend = new Texture("MainMenu/vsFriend.png");
        bg = new Texture("MainMenu/Homescreen_BG.png");
        bg1 = new Texture("MainMenu/bg.png");
        tank1 = new Texture("Tanks/tank1.png");
        settingIcon = new Texture("MainMenu/settingSmall1.png");
//        arrowLeft = new Texture("MainMenu/arrow_left.png");
//        arrowRight = new Texture("MainMenu/arrow_right.png");

        vsCompBox = new Rectangle();
        vsCompBox.x = 2560/2.398f;
        vsCompBox.y = 320;
        vsCompBox.width = 551;
        vsCompBox.height = 130;

        settingBox = new Rectangle();
        settingBox.x = 0;
        settingBox.y = 0;
        settingBox.width = 128;
        settingBox.height = 128;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
//        ScreenUtils.clear(0, 0, 0.2f, 1);
        main.batch.begin();
        main.batch.draw(bg1, 0,0, 2688, 1242);
        main.batch.draw(bg, 0, -60, 1020, 1180);
        main.batch.draw(settingIcon, 0, 820, 128, 128);
        main.batch.draw(tank1, 250, 75, 580, 580);
//        main.batch.draw(arrowLeft, 180, 750, 40, 40);
//        main.batch.draw(arrowRight, 680, 750, 40, 40);
        main.batch.draw(tankstarslogo, 2560/2.212f, 700, 400, 200);
        main.batch.draw(vsComp, vsCompBox.x, vsCompBox.y, vsCompBox.width, vsCompBox.height);
        main.batch.draw(vsFriend, 2560/2.34f, 450, 500, 120);
        main.batch.end();

        if (Gdx.input.justTouched()) {
            touch1 = new Vector3();
            touch1.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (vsCompBox.contains(touch1.x, touch1.y)) {
                main.setScreen(new Game(main));
                dispose();
            }
        }

        if (Gdx.input.justTouched()) {
            touch2 = new Vector3();
            touch2.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                if (settingBox.contains(touch2.x, touch2.y)) {
                    main.setScreen(new MainMenuSettings(main));
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
        settingIcon.dispose();
        tankstarslogo.dispose();
        bg.dispose();
        bg1.dispose();
        vsComp.dispose();
        vsFriend.dispose();
    }
}
