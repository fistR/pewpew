package objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class OrientationTest {
    
    Orientation o;
    
    public OrientationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        o = new Orientation("LEFT");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void constructorCurrentCorrect(){
        assertEquals("LEFT", o.getOrientation());
    }
    
    @Test
    public void degreesCorrectLeft() {
        assertEquals(90, o.getRotationInDegrees());
    }
    
    @Test
    public void degreesCorrectRight() {
        o.setOrientation("RIGHT");
        assertEquals(270, o.getRotationInDegrees());
    }
    @Test
    public void degreesCorrectDown() {
        o.setOrientation("DOWN");
        assertEquals(0, o.getRotationInDegrees());
    }
    @Test
    public void degreesCorrectUp() {
        o.setOrientation("UP");
        assertEquals(180, o.getRotationInDegrees());
    }
    @Test
    public void degreesCorrectFalse() {
        o.setOrientation("LOL");
        assertEquals(0, o.getRotationInDegrees());
    }
}
