package com.mycompany.pewpewgame.controllers;

import com.mycompany.pewpewgame.objects.Enemy;
import com.mycompany.pewpewgame.objects.GameObject;
import com.mycompany.pewpewgame.objects.Player;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author max
 */
public class EnemyAI {
    EnemyController ec;
    Enemy enemy;
    Player player;
    ScheduledExecutorService exec;
    
    public EnemyAI(EnemyController ec, Player player) {
        this.exec  = new ScheduledThreadPoolExecutor(1);
        this.ec = ec;
        this.player = player;
        decisions();
    }
    
    private void decisions() {
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                updateDirections(ec.getEnemies());
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }
    
    public void updateDirections(ArrayList<GameObject> enemies) {
        for(GameObject e: enemies) {
            if(Math.abs(e.getPosX()-player.getPosX()) >= Math.abs(e.getPosY()-player.getPosY())) {
                if(e.getPosX() >= player.getPosX()) {
                    e.getOrientation().current = "LEFT";
                } else {
                    e.getOrientation().current = "RIGHT";
                }
            } else {
                if(e.getPosY() >= player.getPosY()) {
                    e.getOrientation().current = "UP";
                } else {
                    e.getOrientation().current = "DOWN";
                }
            }
        }
    }
}
