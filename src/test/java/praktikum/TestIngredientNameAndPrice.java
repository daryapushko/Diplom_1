package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIngredientNameAndPrice {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test
    public void testIngredientGetName() {
        assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void testIngredientGetPrice() {
        assertEquals(100, ingredient.getPrice(), 0);
    }
}
