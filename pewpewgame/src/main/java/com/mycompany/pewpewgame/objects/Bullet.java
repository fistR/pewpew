/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.objects;

import javafx.scene.canvas.GraphicsContext;

/**
 * The Bullet GameObject is the projectile
 * the player fires to damage the enemies.
 * @author max
 */
public class Bullet extends GameObject {
    /**
     * The Bullet inherits its position and 
     * orientation from the player.
     * 4 is the default speed.
     * @param x
     * @param y
     * @param o 
     */
    public Bullet(int x, int y, Orientation o) {
        super(x, y);
        this.orientation = new Orientation(o.current);
        this.speed = 4;
    }
    /**
     * GameObject move overridden to let bullets
     * travel to the edge of the map where they
     * are deleted from the game.
     * @param o 
     */
    @Override
    public void move(Orientation o) {
        if (o.current.equals("LEFT")) {
            this.posX = this.posX - speed;
        }
        if (o.current.equals("RIGHT")) {
            this.posX = this.posX + speed;
        }
        if (o.current.equals("UP")) {
            this.posY = this.posY - speed;
        }
        if (o.current.equals("DOWN")) {
            this.posY = this.posY + speed;
        }
    }
}
