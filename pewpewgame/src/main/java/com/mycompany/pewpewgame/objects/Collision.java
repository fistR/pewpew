/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.objects;

/**
 * Collision object to document collisions
 * each frame.
 * @author max
 */
public class Collision {
    
    private GameObject collisionWith;
    /**
     * Collisions are given to GameObjects
     * and have their target GameObject
     * saved in the collisionWith to identify
     * both parties involved.
     * @param with 
     */
    public Collision(GameObject with) {
        this.collisionWith = with;
    }

    public GameObject getCollisionWith() {
        return collisionWith;
    }

    public void setCollisionWith(GameObject collisionWith) {
        this.collisionWith = collisionWith;
    }    
}
