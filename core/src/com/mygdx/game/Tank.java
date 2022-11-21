package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.*;

public class Tank {
    private String Name;
    private SpriteBatch batch;
    private Texture Img;
    private Rectangle Hitbox;
    private double fuel;
    private double health;
    private ArrayList<Weapons> Weap;
    public Tank(Texture img, Rectangle r){
        batch=new SpriteBatch();
        Img=img;
        Hitbox=new Rectangle(r);
        fuel=150D;
        Weap=new ArrayList<Weapons>();
    }
    public Texture getimg(){
        return Img;
    }
    public Rectangle getrect(){
        return Hitbox;
    }
    public void upg_fuel(){
        fuel+=(fuel/10);
    }
    public void upg_health(){
        health+=(health/10);
    }

}
