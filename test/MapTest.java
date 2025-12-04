import game.Map;
import game.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {

    @Test
    void testMoveInsideBounds() {
        Map map = new Map(3,3);
        Player p = new Player(5,0);
        p.setPosition(1,1);

        boolean moved = map.movePlayer(p, "W");
        assertTrue(moved);
        assertEquals(1, p.getX());
        assertEquals(0, p.getY());
    }

    @Test
    void testMoveOutOfBounds() {
        Map map = new Map(3,3);
        Player p = new Player(5,0);
        p.setPosition(0,0);

        assertFalse(map.movePlayer(p, "W"));
        assertFalse(map.movePlayer(p, "A"));
    }

    @Test
    void testTreasureAlwaysBottomRight() {
        Map map = new Map(3,3);
        assertTrue(map.getSector(2,2).hasTreasure());
    }
}
