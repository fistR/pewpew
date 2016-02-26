/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import com.mycompany.pewpewgame.objects.Bullet;
import com.mycompany.pewpewgame.objects.Orientation;
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
public class BulletTest {
    
    Bullet bullet;
    
    public BulletTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bullet = new Bullet(256,256,new Orientation("RIGHT"));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void hello(){}
    
    @Test
    public void constCorrectOrientationSet(){
        assertEquals("RIGHT", bullet.getOrientation().current);
    }
    
        @Test
    public void constCorrectXSet(){
        assertEquals(256, bullet.getPosX());
    }
    
        @Test
    public void constCorrectYSet(){       
        assertEquals(256, bullet.getPosY());
    }
    
        @Test(expected=NullPointerException.class)
    public void constCorrectOrientation2(){
        bullet.setOrientation(null);
        bullet.getOrientation();
    }
    
    @Test
    public void getOrientationTest(){
        Bullet bullet2 = new Bullet(0,256,new Orientation("LEFT"));
        assertEquals("LEFT", bullet2.getOrientation().current);
    }

}
