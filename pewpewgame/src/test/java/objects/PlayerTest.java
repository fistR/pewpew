package objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.pewpewgame.objects.Bullet;
import com.mycompany.pewpewgame.objects.Orientation;
import com.mycompany.pewpewgame.objects.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author max
 */
public class PlayerTest {
    Player p;
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p = new Player(10);
    }
    
    @After
    public void tearDown() {
    }

        @Test
    public void constCorrectOrientationSet(){
        assertEquals("RIGHT", p.getOrientation().current);
    }
    
        @Test
    public void constCorrectXSet(){
        assertEquals(256, p.getPosX());
    }
    
        @Test
    public void constCorrectYSet(){       
        assertEquals(256, p.getPosY());
    }
    
        @Test
    public void constCorrectHPSet(){
        assertEquals(10, p.getHp());
    }
    
}
