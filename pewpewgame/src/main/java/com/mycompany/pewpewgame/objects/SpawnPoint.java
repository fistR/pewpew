/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.objects;

/**
 * SpawnPoints are empty non interactable
 * GameObjects serving simply for reference 
 * points for the EnemyController to spawn
 * Enemy GameObjects at.
 * @author max
 */
public class SpawnPoint extends GameObject {
    
    public SpawnPoint(int x, int y) {
        super(x, y);
    }
}
