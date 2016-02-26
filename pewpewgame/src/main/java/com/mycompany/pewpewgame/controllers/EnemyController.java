/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.controllers;

import com.mycompany.pewpewgame.objects.Enemy;
import com.mycompany.pewpewgame.objects.GameObject;
import com.mycompany.pewpewgame.objects.SpawnPoint;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author max
 */
public class EnemyController {
    public ArrayList<GameObject> enemies;
    ArrayList<SpawnPoint> spawns;
    ScheduledExecutorService exec;
    int spawnedcount;
    GameController gameC;
    
    public EnemyController(GameController gc) {
        this.gameC = gc;
        this.exec  = new ScheduledThreadPoolExecutor(1);
        this.enemies = new ArrayList();
        this.spawns = new ArrayList();
        initSpawns();
        this.spawnedcount = 0;
        spawner();
        System.out.println("keke");
        System.out.println("" + enemies.size());
    }
    
    public void spawnEnemy() {
        spawnedcount++;
        enemies.add(new Enemy(spawns.get(spawnedcount % 8).getPosX(), spawns.get(spawnedcount % 8).getPosY()));
        System.out.println("Enemies: " + enemies.size());
        
    }
    
    private void spawner() {
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                spawnEnemy();
                }
        }, 0, 750, TimeUnit.MILLISECONDS);
    }
    
    public void damageEnemy(GameObject e) {
        e.setHp(e.getHp() - 1);
        if (e.getHp() <= 0) {
            enemies.remove(e);
            gameC.setScore(gameC.getScore() + 10);
        }
    }

    public void initSpawns() {
        this.spawns.add(new SpawnPoint(12, 12));
        this.spawns.add(new SpawnPoint(500, 12));
        this.spawns.add(new SpawnPoint(12, 500));
        this.spawns.add(new SpawnPoint(500, 500));
        this.spawns.add(new SpawnPoint(244, 500));
        this.spawns.add(new SpawnPoint(500, 244));
        this.spawns.add(new SpawnPoint(12, 244));
        this.spawns.add(new SpawnPoint(244, 12));
    }
    
    public ArrayList<GameObject> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<GameObject> enemies) {
        this.enemies = enemies;
    }

    public ArrayList<SpawnPoint> getSpawns() {
        return spawns;
    }

    public void setSpawns(ArrayList<SpawnPoint> spawns) {
        this.spawns = spawns;
    }

    public ScheduledExecutorService getExec() {
        return exec;
    }

    public void setExec(ScheduledExecutorService exec) {
        this.exec = exec;
    }

    public int getSpawnedcount() {
        return spawnedcount;
    }

    public void setSpawnedcount(int spawnedcount) {
        this.spawnedcount = spawnedcount;
    }

    
    
}
