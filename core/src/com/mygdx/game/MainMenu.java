package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainMenu implements Screen {
    private Texture settingIcon;
    private Rectangle vsFriendBox;
    private Rectangle vsCompBox;
    private Rectangle settingBox;
    private Rectangle exitBox;
    private Rectangle savedGamesBox;
    private Vector3 touch1;
    private Vector3 touch2;
    private Vector3 touch3;
    private Vector3 touch4;
    private Vector3 touch5;
    private Texture tank1;
    private Texture tankstarslogo;
    private Texture vsComp;
    private Texture exit;
    private Texture savedGames;
    private Texture prp;
    private Texture vsFriend;
    private Texture bg;
    private Texture bg1;
    private SpriteBatch batch;
    private Main main;
    private Sound s1;

    public MainMenu(Main main) {
        this.main = main;
        batch = new SpriteBatch();
        s1=Gdx.audio.newSound(Gdx.files.internal("main.mp3"));
        tankstarslogo = new Texture("MainMenu/tankstars.png");
        vsComp = new Texture("MainMenu/vsPlayer.png");
        exit = new Texture("MainMenu/exit.png");
        vsFriend = new Texture("MainMenu/vsFriend.png");
        savedGames = new Texture("MainMenu/savedGames.png");
        bg = new Texture("MainMenu/Homescreen_BG.png");
        bg1 = new Texture("MainMenu/bg.png");
        tank1 = new Texture("Tanks/tank1.png");
        settingIcon = new Texture("MainMenu/set.png");
        prp = new Texture("MainMenu/lightprp.png");

        vsFriendBox = new Rectangle();
        vsFriendBox.x = 2560/2.32f;
        vsFriendBox.y = 330;
        vsFriendBox.width = 490;
        vsFriendBox.height = 126;

        vsCompBox = new Rectangle();
        vsCompBox.x = 2560/2.32f;
        vsCompBox.y = 475;
        vsCompBox.width = 490;
        vsCompBox.height = 126;

        settingBox = new Rectangle();
        settingBox.x = 0;
        settingBox.y = 0;
        settingBox.width = 128;
        settingBox.height = 128;

        exitBox = new Rectangle();
        exitBox.x = 2560/2.32f;;
        exitBox.y = 760;
        exitBox.width = 490;
        exitBox.height = 126;

        savedGamesBox = new Rectangle();
        savedGamesBox.x = 2560/2.32f;;
        savedGamesBox.y = 600;
        savedGamesBox.width = 490;
        savedGamesBox.height = 126;
        s1.loop(0.4f);
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
        main.getbatch().draw(tankstarslogo, 2560/2.22f, 680, 400, 200);
        main.getbatch().draw(vsComp, 2560/2.26f, 358, 440, 112);
        main.getbatch().draw(vsFriend, 2560/2.26f, 500, 440, 112);
        main.getbatch().draw(savedGames, 2560/2.265f, 220, 442, 112);
        main.getbatch().draw(exit, 2560/2.26f, 80, 440, 112);
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

        if (Gdx.input.justTouched()) {
            touch5 = new Vector3();
            touch5.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (savedGamesBox.contains(touch5.x, touch5.y)) {
                main.setScreen(new savedGames(main));
                dispose();
            }
        }

        if (Gdx.input.justTouched()) {
            touch4 = new Vector3();
            touch4.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (exitBox.contains(touch4.x, touch4.y)) {
                Gdx.app.exit();
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
        exit.dispose();
        savedGames.dispose();
        s1.dispose();
    }
}
