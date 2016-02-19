/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.objects;

/**
 *
 * @author max
 */
public class Player {
    
    int posX;
    int posY;
    int hp;
    public Orientation orientation;
    
    public Player(int hp){
        this.posX = 256;
        this.posY = 256;
        this.hp = hp;
        this.orientation = new Orientation("RIGHT");
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
    
    
}
