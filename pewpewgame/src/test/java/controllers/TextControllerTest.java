package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.pewpewgame.controllers.GameController;
import com.mycompany.pewpewgame.controllers.Peli;
import com.mycompany.pewpewgame.controllers.TextController;
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
public class TextControllerTest {
    TextController tc;
    GameController gc;
    Player player;
    public TextControllerTest() {
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
    Thread.sleep(800);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        player = Peli.player;
        gc = Peli.gameC;
        tc = gc.getTextController();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void correctHealthText() {
        gc.damagePlayer();
        tc.updateTexts();
        assertEquals(tc.getHealthText(), "HEALTH: " + gc.getPlayer().getHp());
    }
    
    @Test
    public void correctScoreText() {
        gc.setScore(100);
        tc.updateTexts();
        assertEquals(tc.getScoreText(), "SCORE: 100");
    }
    @Test
    public void correctRestartText() {
        assertEquals(tc.getRestartText(), "Press R to reset");
    }
    @Test
    public void correctLoseText() {
        assertEquals(tc.getLoseText(), "YOU ARE DEAD");
    }
    @Test
    public void correctGameController() {
        assertEquals(gc, tc.getGameC());
    }
    @Test
    public void setterLineCoverageDummy() {
        tc.setGameC(gc);
        tc.setHealthText("HEALTH: ");
        tc.setLoseText("YOU ARE DEAD");
        tc.setRestartText("Press R to restart");
        tc.setScoreText("SCORE: ");
        assertEquals(gc, tc.getGameC());
        
    }
}
