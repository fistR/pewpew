/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mycompany.pewpewgame.controllers.GameController;
import com.mycompany.pewpewgame.objects.Orientation;
import com.mycompany.pewpewgame.objects.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
    GameController gameC;
    Player p;
    GraphicsContext gc;
    Canvas canv;
    
    
    public GameControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        canv = new Canvas(512,512);
        gc = canv.getGraphicsContext2D();
        p = new Player(10);
        gameC = new GameController(p, gc);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void constPlayerTest(){
        assertEquals(p, gameC.getPlayer());
    }
    
    @Test
    public void constScoreTest(){
        assertEquals(0, gameC.getScore());
    }
    
    @Test
    public void constGCTest(){
        assertEquals(gc, gameC.getGc());
    }
    @Test
    public void spawnBulletLeftWorksTest(){
        gameC.spawnBullet(256, 256, new Orientation("LEFT"));
        assertEquals(1,gameC.bullets.size());
    }
    @Test
    public void noBulletsCorrectTest(){
        assertEquals(0,gameC.bullets.size());
    }
    @Test 
    public void bulletsUpdateRightCorrect(){
        gameC.spawnBullet(256, 256, new Orientation("RIGHT"));
        gameC.updateBullets();
        assertEquals(259, gameC.bullets.get(0).getPosX());
    }
        @Test 
    public void bulletsUpdateLeftCorrect(){
        gameC.spawnBullet(256, 256, new Orientation("LEFT"));
        gameC.updateBullets();
        assertEquals(253, gameC.bullets.get(0).getPosX());
    }
        @Test 
    public void bulletsUpdateUpCorrect(){
        gameC.spawnBullet(256, 256, new Orientation("UP"));
        gameC.updateBullets();
        assertEquals(253, gameC.bullets.get(0).getPosY());
    }
        @Test 
    public void bulletsUpdateDownCorrect(){
        gameC.spawnBullet(256, 256, new Orientation("DOWN"));
        gameC.updateBullets();
        assertEquals(259, gameC.bullets.get(0).getPosY());
    }
    
    @Test
    public void dumbTest(){
        gameC.bullets = null;
        assertEquals(null,gameC.getBullets());
    }
}
