/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.objects;

import javafx.scene.image.Image;

/**
 * The Enemy GameObject are the 
 * objects that will try to kill the player.
 * Spawning enemies is done in the EnemyController.
 * @author max
 */
public class Enemy extends GameObject {    
    
    public Enemy(int x, int y) {
        super(x, y); 
        this.speed = 1;
    }    
}
