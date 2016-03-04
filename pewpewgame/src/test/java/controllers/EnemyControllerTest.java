/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mycompany.pewpewgame.controllers.EnemyController;
import com.mycompany.pewpewgame.controllers.GameController;
import com.mycompany.pewpewgame.controllers.Peli;
import com.mycompany.pewpewgame.objects.Enemy;
import com.mycompany.pewpewgame.objects.GameObject;
import com.mycompany.pewpewgame.objects.Player;
import com.mycompany.pewpewgame.objects.SpawnPoint;
import java.util.ArrayList;
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
public class EnemyControllerTest {
    EnemyController ec;
    GameController gc;
    Player player;
    Enemy e;
    
    public EnemyControllerTest() {
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
    Thread.sleep(1000);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        player = Peli.player;
        gc = Peli.gameC;
        ec = gc.getEnemyC();
        e = new Enemy(100,100);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void spawnerEnemyTest() throws InterruptedException {
        int x = ec.getEnemies().size();
        Thread.sleep(750);
        assertEquals(x, ec.getEnemies().size() - 1);
    }
    
    @Test
    public void spawnsRight() {
        
        assertEquals(ec.getSpawns().get(0).getPosX(), 12);
    }
    
    @Test
    public void execMutantKiller() {
        assertNotEquals(ec.getExec(), null);
    }
    @Test
    public void setterCoverage() {
        EnemyController ec2 = new EnemyController(gc);
        ec2.setEnemies(new ArrayList<>());
        ec2.setSpawns(new ArrayList<>());
        ec2.setExec(null);
        ec2.setSpawnedcount(0);
        assertEquals(ec2.getSpawnedcount(), 0 );
    }
}
