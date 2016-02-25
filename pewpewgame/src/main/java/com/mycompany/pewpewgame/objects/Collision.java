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
public class Collision {
    GameObject collisionWith;
    
    public Collision(GameObject with){
        this.collisionWith = with;
    }

    public GameObject getCollisionWith() {
        return collisionWith;
    }

    public void setCollisionWith(GameObject collisionWith) {
        this.collisionWith = collisionWith;
    }
    
    
}
