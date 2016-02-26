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
 *
 * @author max
 */
public class CollisionController {
    
    EnemyController eC;
    GameController gc;
    ArrayList<GameObject> colls;
    
    
    public CollisionController(EnemyController eC, GameController gc) {
        this.eC = eC;
        this.gc = gc;
        this.colls = new ArrayList();
    }
    
    public void checkForCollisions(GameObject o) {
        if(o.getClass() == Bullet.class){
            if(o.getPosX()>511 ||o.getPosX()<1 || o.getPosY()>511 || o.getPosY()<1) {
                Collision c = new Collision(null);
                o.setCollision(c);
                colls.add(o);
            }
            for(GameObject e : eC.enemies) {
                {
                     
                    if (Math.abs(o.getPosX()-e.getPosX()) <= 12 && Math.abs(o.getPosY() - e.getPosY()) <= 12) {
                        Collision c = new Collision(e);
                        o.setCollision(c);
                        colls.add(o);
                    }
                }
            }
        }
        if(o.getClass() == Enemy.class) {
            if(Math.abs(o.getPosX() - gc.player.getPosX()) <= 12 && Math.abs(o.getPosY() - gc.player.getPosY()) <= 12) {
                Collision c = new Collision(o);
                gc.player.setCollision(c);
                colls.add(gc.player);
                }
        }
       

    }
    
    public void handleCollisions() {
        if(gc.getPlayer().getHp() <= 0) {
            return;
        }
        for(GameObject o : colls) {
            
            if(o.getClass() == Bullet.class){
                if(o.getCollision().getCollisionWith() == null) {
                    gc.bullets.remove(o);
                } else {
                    eC.damageEnemy(o.getCollision().getCollisionWith());
                    gc.bullets.remove(o);
                }
            } 
            if(o == gc.player) {
                System.out.println("damage");
                gc.damagePlayer();
                eC.enemies.remove(gc.player.getCollision().getCollisionWith());
            }
        }
        colls.removeAll(colls);
    }
}
