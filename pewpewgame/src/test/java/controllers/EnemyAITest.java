/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mycompany.pewpewgame.controllers.EnemyAI;
import com.mycompany.pewpewgame.controllers.EnemyController;
import com.mycompany.pewpewgame.controllers.GameController;
import com.mycompany.pewpewgame.controllers.Peli;
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
public class EnemyAITest {
    Player player;
    GameController gc;
    EnemyController ec;
    Enemy e,e2;
    Orientation o;
    EnemyAI ai;
    
    public EnemyAITest() {
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
        ec = gc.getEnemyC();
        e = new Enemy(100,100);
        e2 = new Enemy(200,200);
        
        ec.getEnemies().add(e);
        ec.getEnemies().add(e2);
        player.setPosX(200);
        player.setPosY(100);
        ai = gc.getAi();
    }
    
    @After
    public void tearDown() {
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void directionsUpdateTest() {
        ai.updateDirections(ec.getEnemies());
        assertEquals(e.getOrientation().current, "RIGHT");
    }
    @Test
    public void directionsUpdateTest2() {
        ai.updateDirections(ec.getEnemies());
        assertEquals(e2.getOrientation().current, "UP");
    }
}
