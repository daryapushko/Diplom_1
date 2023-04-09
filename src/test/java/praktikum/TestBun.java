package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestBun {
    Bun bun = new Bun("black bun", 100);
    @Test
    public void testBunGetName() {
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testBunGetPrice() {
        assertEquals(100, bun.getPrice(), 0);
    }
}
