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
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author max
 */
public class GameController {
    
    EnemyController enemyC;
    EnemyAI ai;
    CollisionController cc;
    TextController textC;
    Player player;
    int score;
    GraphicsContext gc;
    public ArrayList<Bullet> bullets = new ArrayList();
    
    public GameController(Player player, GraphicsContext gc) {
        this.player = player;
        score = 0;
        this.gc = gc;
        this.enemyC = new EnemyController(this);
        this.textC = new TextController(this);
        this.ai = new EnemyAI(this.enemyC, this.player);
        this.cc = new CollisionController(this.enemyC, this);
    }
    
    /**
    * Metodi luo uuden Bulletin
    * Playerin kohdalle ja samalla Orientationilla.
    *
    * @param   x   Playerin X positio
    * @param   y   Playerin Y positio
    * @param   o   Playerin orientaatio.
    */
    public void spawnBullet(int x, int y, Orientation o) {
        Bullet bul = new Bullet(x, y, o);
        bullets.add(bul);
    }    

    public void damagePlayer() {
        player.setHp(player.getHp() -1);
        System.out.println("player damaged");
    }
     
    public void reset() {
        player.setHp(10);
        setScore(0);
        enemyC.getEnemies().clear();
        bullets.clear();
        player.setPosX(256);
        player.setPosY(256);
    }
    
    public void updateAll() {
        updateBullets();
        updateEnemies();
        textC.updateTexts();
    }
    
    private void updateBullets() {
        for(Bullet b: bullets){
            b.move(b.getOrientation());
            cc.checkForCollisions(b);
        }
    }
    
    private void updateEnemies() {
        for(GameObject e: enemyC.enemies) {
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

    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
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
