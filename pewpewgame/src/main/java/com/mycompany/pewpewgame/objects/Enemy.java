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
public class Enemy extends GameObject {    
    
    public Enemy(int x, int y) {
        super(x, y); 
        this.img = new Image("/enemy.jpg");
        this.speed = 1;
    }    
}
