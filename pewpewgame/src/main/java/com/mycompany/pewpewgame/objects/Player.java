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
public class Player extends GameObject {
    
    
    public Player(int hp) {
        super(hp);
        this.img = new Image("/player.png");
        this.speed = 2;
    }
    
}
