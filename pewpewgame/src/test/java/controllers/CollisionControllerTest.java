///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controllers;
//
//import com.mycompany.pewpewgame.controllers.CollisionController;
//import com.mycompany.pewpewgame.controllers.EnemyController;
//import com.mycompany.pewpewgame.controllers.GameController;
//import com.mycompany.pewpewgame.controllers.Peli;
//import com.mycompany.pewpewgame.objects.Bullet;
//import com.mycompany.pewpewgame.objects.Enemy;
//import com.mycompany.pewpewgame.objects.Orientation;
//import com.mycompany.pewpewgame.objects.Player;
//import org.junit.After;
//import org.junit.AfterClass;
//import static org.junit.Assert.assertEquals;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// *
// * @author max
// */
//public class CollisionControllerTest {
//    EnemyController eC;
//    GameController gc;
//    CollisionController CC;
//    Player player;
//    Enemy e, e2;
//    Bullet bullet, bullet2;
//    
//    public CollisionControllerTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//        bullet = new Bullet(100, 100, new Orientation("LEFT"));
//        bullet2 = new Bullet(300, 300, new Orientation("LEFT"));
//        player = new Player(10);
//        e = new Enemy(256,256);
//        e2 = new Enemy(100, 100);
//        eC.enemies.add(e);
//        eC.enemies.add(e2);
//        gc = new GameController(player);
//        eC = new EnemyController(gc);
//        CC = new CollisionController(eC, gc);
//        
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void bulletCollidesWithBoundaryLeft() {
//        bullet2.setPosX(600);
//        CC.checkForCollisions(bullet2);
//        assertEquals(bullet2.getCollision(), null);
//    }
//}
