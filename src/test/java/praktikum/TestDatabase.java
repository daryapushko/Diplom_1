package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDatabase {
    Database database = new Database();

    @Test
    public void testAvailableBuns() {
        assertEquals(3, database.availableBuns().size());
    }

    @Test
    public void testAvailableIngredients() {
        assertEquals(6, database.availableIngredients().size());
    }
}