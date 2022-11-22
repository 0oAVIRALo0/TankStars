package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainMenu implements Screen {
    private Texture settingIcon;
    private Rectangle vsFriendBox;
    private Rectangle vsCompBox;
    private Rectangle settingBox;
    private Vector3 touch1;
    private Vector3 touch2;
    private Vector3 touch3;
    private Texture arrowLeft;
    private Texture arrowRight;
    private Texture tank1;
    private Texture tankstarslogo;
    private Texture vsComp;
    private Texture prp;
    private Texture vsFriend;
    private Texture bg;
    private Texture bg1;
    private SpriteBatch batch;
    private Main main;

    public MainMenu(Main main) {
        this.main = main;
        batch = new SpriteBatch();

        tankstarslogo = new Texture("MainMenu/tankstars.png");
        vsComp = new Texture("MainMenu/vsComputer1.png");
        vsFriend = new Texture("MainMenu/vsFriend1.png");
        bg = new Texture("MainMenu/Homescreen_BG.png");
        bg1 = new Texture("MainMenu/bg.png");
        tank1 = new Texture("Tanks/tank1.png");
        settingIcon = new Texture("MainMenu/set.png");
        prp = new Texture("MainMenu/lightprp.png");

//        arrowLeft = new Texture("MainMenu/arrow_left.png");
//        arrowRight = new Texture("MainMenu/arrow_right.png");

        vsFriendBox = new Rectangle();
        vsFriendBox.x = 2560/2.32f;
        vsFriendBox.y = 340;
        vsFriendBox.width = 490;
        vsFriendBox.height = 126;

        vsCompBox = new Rectangle();
        vsCompBox.x = 2560/2.32f;
        vsCompBox.y = 490;
        vsCompBox.width = 490;
        vsCompBox.height = 126;

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
        main.getbatch().begin();
        main.getbatch().draw(bg1, 0,0, 2688, 1242);
        main.getbatch().draw(prp, 0, 0, 1030, 1180);
        main.getbatch().draw(bg, 0, -60, 1020, 1180);
        main.getbatch().draw(settingIcon, 0, 538, 750, 680);
        main.getbatch().draw(tank1, 250, 75, 580, 580);
//        main.batch.draw(arrowLeft, 180, 750, 40, 40);
//        main.batch.draw(arrowRight, 680, 750, 40, 40);
        main.getbatch().draw(tankstarslogo, 2560/2.22f, 680, 400, 200);
        main.getbatch().draw(vsComp, 2560/2.31f, 260, 490, 126);
        main.getbatch().draw(vsFriend, 2560/2.32f, 420, 500, 120);
        main.getbatch().end();

        if (Gdx.input.justTouched()) {
            touch1 = new Vector3();
            touch1.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (vsFriendBox.contains(touch1.x, touch1.y)) {
                main.setScreen(new VsFriendGame(main));
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

        if (Gdx.input.justTouched()) {
            touch3 = new Vector3();
            touch3.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (vsCompBox.contains(touch3.x, touch3.y)) {
                main.setScreen(new VsCompGame(main));
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
        prp.dispose();
    }
}
