/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.objects;

import javafx.scene.image.Image;

/**
 *
 * @author max
 */
public class GameObject {
    int posX;
    int posY;
    int hp;
    Orientation orientation;
    Image img;
    Collision collision;
    
    public GameObject(int hp){
        this.posX = 256;
        this.posY = 256;
        this.hp = hp;
        this.orientation = new Orientation("RIGHT");
    }
    public GameObject(int x, int y){
        this.posX = x;
        this.posY = y;
        this.hp = 1;
        this.orientation = new Orientation("RIGHT");
    }
    
    public GameObject(int x, int y, Orientation o, Image img){
        this.posX = x;
        this.posY = y;
        this.hp = 1;
        this.orientation = o;
        this.img = img;
    }

    public Collision getCollision() {
        return collision;
    }

    public void setCollision(Collision collision) {
        this.collision = collision;
    }
    

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    
        
    
    
}
