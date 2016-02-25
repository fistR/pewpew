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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author max
 */
public class GameController {
    EnemyController enemyC;
    EnemyAI ai;
    CollisionController cc;
    TextController text;
    Player player;
    int score;
    GraphicsContext gc;
    public ArrayList<Bullet> bullets = new ArrayList();
    
    public GameController(Player player, GraphicsContext gc){
        this.player = player;
        score = 0;
        this.gc = gc;
        this.enemyC = new EnemyController(this);
        this.text = new TextController();
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
    public void spawnBullet(int x, int y, Orientation o){
        Bullet bul = new Bullet(x, y, o);
        bullets.add(bul);
    }
    
    public void updateBullets(){
        for(Bullet b: bullets){
            switch(b.getOrientation().current){
                case "RIGHT": 
                    b.setPosX(b.getPosX()+3);
                    gc.fillText( ".", b.getPosX(), b.getPosY() );
                    break;
                case "LEFT": 
                    b.setPosX(b.getPosX()-3);
                    gc.fillText( ".", b.getPosX(), b.getPosY() );
                    break;
                case "UP": 
                    b.setPosY(b.getPosY()-3);
                    gc.fillText( ".", b.getPosX(), b.getPosY() );
                    break;
                case "DOWN": 
                    b.setPosY(b.getPosY()+3);
                    gc.fillText( ".", b.getPosX(), b.getPosY() );
                    break;
            }
            cc.checkForCollisions(b);
        }
    }
    
    
    public void damagePlayer(){
        player.setHp(player.getHp() -1);
        System.out.println("player damaged");
    }
    
    public void lose(){
        
    }
    
    public void updatePlayer(ImageView plr){
        if(player.getHp()<=0){
            plr.setImage(null);
        } else {
            plr.setImage(player.getImg());
            plr.setRotate(player.getOrientation().getRotationInDegrees());
            plr.setX(player.getPosX());
            plr.setY(player.getPosY()-16);
        }
    }
    
    public void updateEnemies(){
        for(GameObject e: enemyC.enemies){
            switch(e.getOrientation().current){
                case "RIGHT": 
                    e.setPosX(e.getPosX()+1);
                    gc.fillText( "☹", e.getPosX(), e.getPosY() );
                    break;
                case "LEFT": 
                    e.setPosX(e.getPosX()-1);
                    gc.fillText( "☹", e.getPosX(), e.getPosY() );
                    break;
                case "UP": 
                    e.setPosY(e.getPosY()-1);
                    gc.fillText( "☹", e.getPosX(), e.getPosY() );
                    break;
                case "DOWN": 
                    e.setPosY(e.getPosY()+1);
                    gc.fillText( "☹", e.getPosX(), e.getPosY() );
                    break;
            }
            cc.checkForCollisions(e);
        }
    }
    
    public void reset(){
        player.setHp(10);
        setScore(0);
        enemyC.getEnemies().clear();
        bullets.clear();
        player.setPosX(256);
        player.setPosY(256);
  
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
        return text;
    }

    public void setTextController(TextController text) {
        this.text = text;
    }
    
    
}
