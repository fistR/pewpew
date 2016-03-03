/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mycompany.pewpewgame.controllers.CollisionController;
import com.mycompany.pewpewgame.controllers.EnemyController;
import com.mycompany.pewpewgame.controllers.GameController;
import com.mycompany.pewpewgame.controllers.Peli;
import com.mycompany.pewpewgame.objects.Bullet;
import com.mycompany.pewpewgame.objects.Enemy;
import com.mycompany.pewpewgame.objects.Orientation;
import com.mycompany.pewpewgame.objects.Player;
import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author max
 */
public class CollisionControllerTest {
    EnemyController eC;
    GameController gc;
    CollisionController CC;
    Player player;
    Enemy e, e2;
    Bullet bullet, bullet2;
    static Thread t;
    
    
    public CollisionControllerTest() {
    }
    
    public static class AsNonApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final long timeStart = Peli.initAll(stage);
        Peli.runGameLoop(timeStart);
        stage.show();
    }
}
    
    @BeforeClass
    public static void setUpClass() {
        t = new Thread("JavaFX Init Thread") {
        public void run() {
            Peli.launch(AsNonApp.class, new String[0]);
        }
    };
    t.setDaemon(true);
    t.start();
    
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        gc = Peli.gameC;
        Peli.gameC.spawnBullet(100, 100, new Orientation("RIGHT"));
        gc.spawnBullet(300, 300, new Orientation("LEFT"));
        bullet = gc.getBullets().get(0);
        bullet = gc.getBullets().get(1);
        player = gc.getPlayer();
        
        e = new Enemy(256,256);
        e2 = new Enemy(100, 100);
        eC = gc.getEnemyC();
        eC.enemies.add(e);
        eC.enemies.add(e2);
        CC = gc.getCc();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void bulletCollidesWithBoundaryLeft() {
    }
}
