package objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.pewpewgame.objects.Collision;
import com.mycompany.pewpewgame.objects.GameObject;
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
public class GameObjectTest {

    GameObject object;
    GameObject object2;

    public GameObjectTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        object = new GameObject(10);
        object.setSpeed(2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void moveLeftCorrect() {
        int x = object.getPosX();
        object.getOrientation().current = "LEFT";
        object.move(object.getOrientation());
        assertEquals(object.getSpeed(), x - object.getPosX());

    }

    @Test
    public void moveRightCorrect() {
        object.setPosX(499);
        int x = 499;
        object.getOrientation().current = "RIGHT";
        object.move(object.getOrientation());
        assertEquals(1, object.getPosX() - x);

    }
    @Test
    public void moveRightCorrect2() {
        object.setPosX(499);
        int x = 500;
        object.getOrientation().current = "RIGHT";
        object.move(object.getOrientation());
        assertEquals(500, object.getPosX());

    }

    @Test
    public void moveUpCorrect() {
        int y = object.getPosY();
        object.getOrientation().current = "UP";
        object.move(object.getOrientation());
        assertEquals(object.getSpeed(), y - object.getPosY());

    }

    @Test
    public void moveDownCorrect() {
        
        int y = object.getPosY();
        object.getOrientation().current = "DOWN";
        object.move(object.getOrientation());
        assertEquals(object.getSpeed(), object.getPosY() - y);

    }
    
    @Test
    public void collisionRight() {
        Collision c = new Collision(object);
        object.setCollision(c);
        assertEquals(c, object.getCollision());
    }
    
    @Test
    public void setXRight() {
        object.setPosX(30);
        assertEquals(30, object.getPosX());
    }
    
    @Test
    public void setYRight() {
        object.setPosY(90);
        assertEquals(90, object.getPosY());
    } 
    
    @Test
    public void testHP() {
        object.setHp(5);
        assertEquals(5, object.getHp());
    }
    
    @Test
    public void testSetOrientation() {
        object.setOrientation(new Orientation("UP"));
        assertEquals("UP", object.getOrientation().current);
    }
}
