package praktikum;

import org.junit.Test;
import org.mockito.Spy;

import static org.junit.Assert.*;

public class TestDatabase {
    Database database = new Database();

    @Test
    public void testAvailableBuns() {
        assertEquals(database.availableBuns().size(), 3);
    }

    @Test
    public void testAvailableIngredients() {
        assertEquals(database.availableIngredients().size(), 6);
    }
}