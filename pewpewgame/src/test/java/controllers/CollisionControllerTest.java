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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
    Orientation o;
    
    
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
    public static void setUpClass() throws InterruptedException {
        Thread t = new Thread("JavaFX Init Thread") {
        @Override
        public void run() {
            Peli.launch(AsNonApp.class, new String[0]);
        }
    };
    t.setDaemon(true);
    t.start();
    Thread.sleep(1500);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        o = new Orientation("LEFT");
        gc = Peli.gameC;
        player = Peli.player;
        bullet = new Bullet(100,100,o);
        gc.getBullets().add(bullet);
        eC = gc.getEnemyC();
        e = new Enemy(100,100);
        e2 = new Enemy(200,200);
        
        eC.getEnemies().add(e);
        eC.getEnemies().add(e2);
        player.setPosX(100);
        player.setPosY(100);
        CC = new CollisionController(eC, gc);
    }
    
    @After
    public void tearDown() {
        o = new Orientation("LEFT");
        gc = Peli.gameC;
        player = Peli.player;
        bullet = new Bullet(100,100,o);
        gc.getBullets().add(bullet);
        eC = gc.getEnemyC();
        e = new Enemy(100,100);
        e2 = new Enemy(200,200);
        
        eC.getEnemies().add(e);
        eC.getEnemies().add(e2);
        player.setPosX(100);
        player.setPosY(100);
        CC = new CollisionController(eC, gc);
    }

    @Test
    public void constructorTest() {
        
        assertEquals(CC.getGc(), gc);
    }
    @Test
    public void constructorTesteC() {
        
        assertEquals(CC.geteC(), eC);
    }
    
    @Test
    public void constructorTestColls() {
        CollisionController c = new CollisionController(eC, gc);
        c.getColls().add(player);
        assertEquals(c.getColls().get(0), player);
    }
    
    @Test
    public void checkForEnemyTest() {
        CC.checkForEnemy(e);
        assertEquals(CC.getColls().get(0), player);
    }
    @Test
    public void checkForEnemyTest2() {
        CC.checkForEnemy(e);
        assertNotEquals(player.getCollision(), null);
    }
//    @Test
//    public void checkForEnemyTestBoundary() {
//        e.setPosX(80);
//        e.setPosY(80);
//        CC.handleCollisions();
//        CC.checkForEnemy(e);
//        assertEquals(player.getCollision().getCollisionWith(), null);
//    }
    @Test
    public void checkForEnemyThroughMain() {
        CC.checkForCollisions(e);
        assertEquals(CC.getColls().get(0).getCollision().getCollisionWith(), e);
    }
    
    @Test
    public void checkForBulletThroughMain() {
        CC.checkForCollisions(bullet);
        assertEquals(CC.getColls().get(0), bullet);
    }
    
    @Test
    public void checkForBulletTest() {
        CC.checkForBullet(bullet);
        assertEquals(CC.getColls().get(0), bullet);
    }
    @Test
    public void checkForBulletTest2() {
        CC.checkForBullet(bullet);
        assertNotEquals(bullet.getCollision(), null);
    }
    @Test
    public void checkForBulletWallTest() {
        bullet2 = new Bullet(513,513, o);
        CC.checkForBullet(bullet2);
        assertEquals(null, bullet2.getCollision().getCollisionWith());
        
    }
    
    @Test
    public void handlePlayerCollisionsTest() {
        player.setPosX(200);
        player.setPosY(200);
        CC.checkForCollisions(e2);
        CC.handleCollisions();
        assertEquals(player.getHp(),9);
    }
    @Test
    public void handleBulletCollisionTest() {
        CC.checkForCollisions(bullet);
        
        CC.handleCollisions();
        assertEquals(-8, e.getHp());
    }
}
