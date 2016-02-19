/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.objects;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author max
 */
public class Bullet {
    int posX;
    int posY;
    Orientation playerorientation;
    public Orientation own;
    GraphicsContext gc;
    
    public Bullet(int x, int y, Orientation o){
        this.posX = x;
        this.posY = y;
        this.playerorientation = o;
        this.gc = gc;
        this.own = new Orientation(playerorientation.current);
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

    public Orientation getOrientation() {
        if(this.own != null){
            return this.own;
        } else throw new NullPointerException();
        
    }

    public void setOrientation(Orientation orientation) {
        this.own = orientation;
    }
    
    
}
