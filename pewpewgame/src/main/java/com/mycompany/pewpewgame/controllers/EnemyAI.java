package com.mycompany.pewpewgame.controllers;

import com.mycompany.pewpewgame.objects.Enemy;
import com.mycompany.pewpewgame.objects.GameObject;
import com.mycompany.pewpewgame.objects.Player;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * The AI class updates the
 * orientation of every
 * enemy to face the player
 * and selects the direction based
 * on the greater X or Y distance.
 * The enemy speed is a constant,
 * and therefore not handled by AI.
 * 
 */
public class EnemyAI {
    private final EnemyController ec;
    private Enemy enemy;
    private final Player player;
    private final ScheduledExecutorService exec;
    /**
     * The constructor also initializes 
     * the ThreadPoolExecutor and starts
     * the AI decision timer.
     * @param ec the EnemyController.
     * @param player the Player.
     */
    public EnemyAI(EnemyController ec, Player player) {
        this.exec  = new ScheduledThreadPoolExecutor(1);
        this.ec = ec;
        this.player = player;
        decisions();
    }
    /**
     * Every 1000 milliseconds the AI
     * updates the directions of the enemies.
     */
    private void decisions() {
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                updateDirections(ec.getEnemies());
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }
    /**
     * Update the direction of every Enemy by calculating
     * and choosing firstly the greater of the X or Y
     * values and then choosing the direction accordingly. 
     * @param enemies all the Enemies active.
     */
    public void updateDirections(ArrayList<GameObject> enemies) {
        for (GameObject e: enemies) {
            if (Math.abs(e.getPosX() - player.getPosX()) >= Math.abs(e.getPosY() - player.getPosY())) {
                if (e.getPosX() >= player.getPosX()) {
                    e.getOrientation().current = "LEFT";
                } else {
                    e.getOrientation().current = "RIGHT";
                }
            } else {
                if (e.getPosY() >= player.getPosY()) {
                    e.getOrientation().current = "UP";
                } else {
                    e.getOrientation().current = "DOWN";
                }
            }
        }
    }
}
