import game.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testLoseHealth() {
        Player p = new Player(5,0);
        p.loseHealth(1);
        assertEquals(4, p.getHealth());
    }

    @Test
    void testIncreaseSupply() {
        Player p = new Player(5,0);
        p.increaseSupply(3);
        assertEquals(3, p.getSupply());
    }

    @Test
    void testSetPosition() {
        Player p = new Player(5,0);
        p.setPosition(2,3);
        assertEquals(2, p.getX());
        assertEquals(3, p.getY());
    }

    @Test
    void testTreasureFlag() {
        Player p = new Player(5,0);
        assertFalse(p.hasTreasure());
        p.setHasTreasure(true);
        assertTrue(p.hasTreasure());
    }

    @Test
    void testIsAtStart() {
        Player p = new Player(5,0);
        p.setPosition(0,0);
        assertTrue(p.isAtStart());
    }
}
