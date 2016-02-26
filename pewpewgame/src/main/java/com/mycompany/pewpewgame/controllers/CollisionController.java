/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.controllers;

import com.mycompany.pewpewgame.objects.Bullet;
import com.mycompany.pewpewgame.objects.Collision;
import com.mycompany.pewpewgame.objects.Enemy;
import com.mycompany.pewpewgame.objects.GameObject;
import java.util.ArrayList;

/**
 * This class detects
 * and handles collisions
 * between GameObjecs instances.
 * 
 */
public class CollisionController {
    
    EnemyController eC;
    GameController gc;
    /**
     * All documented collisions.
     */
    ArrayList<GameObject> colls;
    
    /**
     * The constructor requires the EnemyController
     * and the GameController in order to access
     * the values needed.
     * 
     * @param eC
     * @param gc 
     */
    public CollisionController(EnemyController eC, GameController gc) {
        this.eC = eC;
        this.gc = gc;
        this.colls = new ArrayList();
    }
    /**
     * Master collision checker method
     * for covering all GameObjects
     * @param o 
     */
    public void checkForCollisions(GameObject o) {
        checkForBullet(o);
        checkForEnemy(o);
    }
    /**
     * Checks for collisions if 
     * GameObject is of type Enemy
     * and adds findings to colls ArrayList
     * @param o 
     */
    public void checkForEnemy(GameObject o) {
        if (o.getClass() == Enemy.class) {
            if (Math.abs(o.getPosX() - gc.player.getPosX()) <= 12 && Math.abs(o.getPosY() - gc.player.getPosY()) <= 12) {
                Collision c = new Collision(o);
                gc.player.setCollision(c);
                colls.add(gc.player);
            }
        }
    }
    /**
     * Checks for collisions if
     * GameObject is of type Bullet
     * and adds findings to colls ArrayList.
     * @param o 
     */
    public void checkForBullet(GameObject o) {
        if (o.getClass() == Bullet.class) {
            if (o.getPosX() > 511 || o.getPosX() < 1 || o.getPosY() > 511 || o.getPosY() < 1) {
                Collision c = new Collision(null);
                o.setCollision(c);
                colls.add(o);
            }
            for (GameObject e : eC.enemies) {                     
                if (Math.abs(o.getPosX() - e.getPosX()) <= 12 && Math.abs(o.getPosY() - e.getPosY()) <= 12) {
                    Collision c = new Collision(e);
                    o.setCollision(c);
                    colls.add(o);
                }
            }
        }
    }
    /**
     * Iterates through the colls ArrayList
     * and handles each collision according
     * to game rules. If enemies and bullets
     * collide, enemies and bullets die and are
     * removed from the game. If enemies and players
     * collide then enemy is removed and the player
     * takes damage. Skips if player is dead.
     */
    public void handleCollisions() {
        if (gc.getPlayer().getHp() <= 0) {
            return;
        }
        for (GameObject o : colls) {            
            handleBulletCollisions(o); 
            handlePlayerCollisions(o);
        }
        colls.removeAll(colls);
    }
    
    private void handleBulletCollisions(GameObject o) {
        if (o.getClass() == Bullet.class) {
            if (o.getCollision().getCollisionWith() == null) {
                gc.bullets.remove(o);
            } else {
                eC.damageEnemy(o.getCollision().getCollisionWith());
                gc.bullets.remove(o);
            }
        }
    }

    private void handlePlayerCollisions(GameObject o) {
        if (o == gc.player) {
            System.out.println("damage");
            gc.damagePlayer();
            eC.enemies.remove(gc.player.getCollision().getCollisionWith());
        }
    }
}
