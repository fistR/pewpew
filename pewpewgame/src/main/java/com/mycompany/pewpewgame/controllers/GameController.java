/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.controllers;

import com.mycompany.pewpewgame.objects.Bullet;
import com.mycompany.pewpewgame.objects.GameObject;
import com.mycompany.pewpewgame.objects.Orientation;
import com.mycompany.pewpewgame.objects.Player;
import java.util.ArrayList;

/**
 *  This is the master controller of the
 *  game logic. This handles updating the gamestate. 
 *  It uses subcontrollers and object methods to complete most of its tasks.
 *  rendering is done using the Renderer class.
 * 
 */
public class GameController {
    
    private EnemyController enemyC;
    private EnemyAI ai;
    private CollisionController cc;
    private TextController textC;
    private Player player;
    private int score;
    private ArrayList<Bullet> bullets = new ArrayList();
    
    /**
     * The constructor needs a player instance
     * and then initializes the controllers of 
     * more specific tasks.
     * @param player 
     */
    public GameController(Player player) {
        this.player = player;
        score = 0;
        this.enemyC = new EnemyController(this);
        this.textC = new TextController(this);
        this.ai = new EnemyAI(this.enemyC, this.player);
        this.cc = new CollisionController(this.enemyC, this);
    }
    
    /**
    * Instantiates a bullet object at
    * the given x,y location and orientation.
    * 
    * @param   x   Players X position
    * @param   y   Players Y position
    * @param   o   Players orientation
    */
    public void spawnBullet(int x, int y, Orientation o) {
        Bullet bul = new Bullet(x, y, o);
        bullets.add(bul);
    }    
    /**
     * Causes damage to the player object
     * by decrementing the hp attribute.
     */
    public void damagePlayer() {
        player.setHp(player.getHp() - 1);
        System.out.println("player damaged");
    }
    /**
     * Resets all game logic and
     * states to
     * default, i.e restarting the game.
     */
    public void reset() {
        player.setHp(10);
        setScore(0);
        enemyC.getEnemies().clear();
        bullets.clear();
        player.setPosX(256);
        player.setPosY(256);
    }
    /**
     * The master logic update function.
     */
    public void updateAll() {
        updateBullets();
        updateEnemies();
        textC.updateTexts();
    }
    /**
     * Moves every existing bullet
     * by its speed and orientation.
     */
    private void updateBullets() {
        for (Bullet b: bullets) {
            b.move(b.getOrientation());
            cc.checkForCollisions(b);
        }
    }
    /**
     * Moves every existing enemy
     * by its speed and orientation.
     */
    private void updateEnemies() {
        for (GameObject e: enemyC.getEnemies()) {
            e.move(e.getOrientation());
            cc.checkForCollisions(e);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(ArrayList<Bullet> bullets) {
        this.bullets = bullets;
    }

    public EnemyController getEnemyC() {
        return enemyC;
    }

    public void setEnemyC(EnemyController enemyC) {
        this.enemyC = enemyC;
    }

    public EnemyAI getAi() {
        return ai;
    }

    public void setAi(EnemyAI ai) {
        this.ai = ai;
    }

    public CollisionController getCc() {
        return cc;
    }

    public void setCc(CollisionController cc) {
        this.cc = cc;
    }

    public TextController getTextController() {
        return textC;
    }

    public void setTextController(TextController textC) {
        this.textC = textC;
    }    
}
