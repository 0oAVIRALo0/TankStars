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
import com.badlogic.gdx.math.Polygon;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.*;

public class Tank {
    private String Name;
    private SpriteBatch batch;
    private Texture Img;
    private Polygon Hitbox;
    private double fuel;
    private double health;
    private ArrayList<Weapons> Weap;
    public Tank(Texture img){
        batch=new SpriteBatch();
        Img=img;
        Hitbox=new Polygon();
        fuel=150D;
        Weap=new ArrayList<Weapons>();
    }
    public Texture getimg(){
        return Img;
    }
    public void upg_fuel(){
        fuel+=300;
    }
    public void upg_health(){
        health+=(health/10);
    }
}
