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
    
    private EnemyController eC;
    private GameController gc;
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
     * for covering all GameObjects.
     * @param o 
     */
    public void checkForCollisions(GameObject o) {
        checkForBullet(o);
        checkForEnemy(o);
    }
    /**
     * Checks for collisions if 
     * GameObject is of type Enemy
     * and adds findings to colls ArrayList.
     * @param o given GameObject.
     */
    public void checkForEnemy(GameObject o) {
        if (o.getClass() == Enemy.class) {
            if (Math.abs(o.getPosX() - gc.getPlayer().getPosX()) <= 12 && Math.abs(o.getPosY() - gc.getPlayer().getPosY()) <= 12) {
                Collision c = new Collision(o);
                gc.getPlayer().setCollision(c);
                colls.add(gc.getPlayer());
            }
        }
    }
    /**
     * Checks for collisions if
     * GameObject is of type Bullet
     * and adds findings to colls ArrayList.
     * @param o given GameObject.
     */
    public void checkForBullet(GameObject o) {
        if (o.getClass() == Bullet.class) {
            if (o.getPosX() > 511 || o.getPosX() < 1 || o.getPosY() > 511 || o.getPosY() < 1) {
                Collision c = new Collision(null);
                o.setCollision(c);
                colls.add(o);
            }
            for (GameObject e : eC.getEnemies()) {                     
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
    /**
     * Handles the collision if GameObject is
     * of type Bullet.
     * @param o given GameObject.
     */
    private void handleBulletCollisions(GameObject o) {
        if (o.getClass() == Bullet.class) {
            if (o.getCollision().getCollisionWith() == null) {
                gc.getBullets().remove(o);
            } else {
                eC.damageEnemy(o.getCollision().getCollisionWith());
                gc.getBullets().remove(o);
            }
        }
    }
    /**
     * Handles the collision if given GameObject
     * is of type Player.
     * @param o 
     */
    private void handlePlayerCollisions(GameObject o) {
        if (o == gc.getPlayer()) {
            System.out.println("damage");
            gc.damagePlayer();
            eC.getEnemies().remove(gc.getPlayer().getCollision().getCollisionWith());
        }
    }
}
