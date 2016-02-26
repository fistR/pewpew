package objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.pewpewgame.objects.Collision;
import com.mycompany.pewpewgame.objects.Enemy;
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
public class CollisionTest {
    
    Collision collision;
    Enemy enemy;
    
    public CollisionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        enemy = new Enemy(256, 256);
        collision = new Collision(enemy);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void constructorTest() {
        assertEquals(enemy, collision.getCollisionWith());
    }
    
    @Test
    public void setterTest() {
        Enemy enemy2 = new Enemy(255, 255);
        collision.setCollisionWith(enemy2);
        assertEquals(enemy2, collision.getCollisionWith());
    }
}
