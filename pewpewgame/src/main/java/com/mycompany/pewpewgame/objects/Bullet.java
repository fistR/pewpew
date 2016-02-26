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
public class Bullet extends GameObject {
   
    public Bullet(int x, int y, Orientation o) {
        super(x, y);
        this.orientation = new Orientation(o.current);
        this.speed = 4;
    }
    
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
