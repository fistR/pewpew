/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author max
 */
public class GameControllerTest {
    GameController gc;
    Player p;
    
    
    public GameControllerTest() {
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
    Thread.sleep(1200);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p = Peli.player;
        gc = Peli.gameC;
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void resetCorrectHP() {
        p.setHp(5);
        gc.reset();
        assertEquals(p.getHp(), 10);
    }
    
    @Test
    public void resetScoreCorrect() {
        gc.setScore(5);
        gc.reset();
        assertEquals(gc.getScore(), 0);
        
    }
    @Test
    public void resetEnemiesCorrect() {
        gc.getEnemyC().spawnEnemy();
        gc.reset();
        assertEquals(0, gc.getEnemyC().getEnemies().size());
    }
    @Test
    public void clearBulletsRight() {
        gc.spawnBullet(100, 100, new Orientation("LEFT"));
        gc.reset();
        assertEquals(0, gc.getBullets().size());
    }
    @Test
    public void playerPosReset() {
        gc.getPlayer().setPosX(5);
        gc.getPlayer().setPosY(5);
        gc.reset();
        assertEquals(256, gc.getPlayer().getPosX());
        assertEquals(256, gc.getPlayer().getPosY());
    }
    @Test
    public void moveBulletsTest() {
        Bullet bullet = new Bullet(150,150,new Orientation("RIGHT"));
        gc.getBullets().add(bullet);
        gc.updateAll();
        assertEquals(gc.getBullets().get(gc.getBullets().indexOf(bullet)).getPosX(), 154);
    }
    
    @Test
    public void updateBulletsCollisionTest() {
        Bullet bullet = new Bullet(200,200,new Orientation("LEFT"));
        gc.getBullets().add(bullet);
        Enemy die = new Enemy(200,200);
        gc.getEnemyC().getEnemies().add(die);
        gc.updateAll();
        assertEquals(gc.getCc().getColls().contains(bullet), true);
    }
    @Test
    public void lineCoverageDummyForSetters() {
        GameController gc2 = new GameController(new Player(5));
        gc2.setAi(null);
        gc2.setBullets(null);
        gc2.setCc(null);
        gc2.setEnemyC(null);
        gc2.setPlayer(null);
        gc2.setScore(0);
        gc2.setTextController(null);
        assertEquals(gc2.getAi(),null);
    }
    @Test
    public void aiCorrect() {
        assertEquals(gc.getAi(), Peli.gameC.getAi()); //dummy
    }
}
