/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.controllers;

import com.mycompany.pewpewgame.objects.Bullet;
import com.mycompany.pewpewgame.objects.Orientation;
import com.mycompany.pewpewgame.objects.Player;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author max
 */
public class GameController {
    Player player;
    int score;
    GraphicsContext gc;
    public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    
    public GameController(Player player, GraphicsContext gc){
        this.player = player;
        score = 0;
        this.gc = gc;
    }
    
    public void spawnBullet(int x, int y, Orientation o){
        Bullet bul = new Bullet(x, y, o);
        bullets.add(bul);
    }
    
    public void updateBullets(){
        for(Bullet b: bullets){
            switch(b.own.current){
                case "RIGHT": b.setPosX(b.getPosX()+3);
                    gc.fillText( "B", b.getPosX(), b.getPosY() );
                    break;
                case "LEFT": b.setPosX(b.getPosX()-3);
                    gc.fillText( "B", b.getPosX(), b.getPosY() );
                    break;
                case "UP": b.setPosY(b.getPosY()-3);
                    gc.fillText( "B", b.getPosX(), b.getPosY() );
                    break;
                case "DOWN": b.setPosY(b.getPosY()+3);
                    gc.fillText( "B", b.getPosX(), b.getPosY() );
                    break;
            }
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
    
}
