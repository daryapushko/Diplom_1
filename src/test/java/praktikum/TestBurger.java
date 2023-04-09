package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    @Spy
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);

    @Spy
    private Bun bun = new Bun("white bun", 200);

    @Spy
    private Burger burger = new Burger();

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(burger.ingredients.size(), 1);
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.size(), 0);
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "sausage", 300);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(burger.ingredients.indexOf(ingredient1), burger.ingredients.indexOf(ingredient2));
        assertEquals(1, burger.ingredients.indexOf(ingredient1));
        assertEquals(0, burger.ingredients.indexOf(ingredient2));
    }

    @Test
    public void testBurgerGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(500, burger.getPrice(), 0);
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();
    }

    @Test
    public void testGetReceipt() {
        String expectedReceipt = "(==== white bun ====)\n" +
                "= filling cutlet =\n" +
                "(==== white bun ====)\n" +
                "\n" +
                "Price: 500,000000\n";
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(expectedReceipt, burger.getReceipt());
        Mockito.verify(bun, Mockito.times(2)).getName();
        Mockito.verify(ingredient, Mockito.times(1)).getName();
        Mockito.verify(ingredient, Mockito.times(1)).getType();
        Mockito.verify(burger, Mockito.times(1)).getPrice();
    }
}