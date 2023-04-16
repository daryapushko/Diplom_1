package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class TestIngredientType {
    private final IngredientType ingredientType;

    public TestIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Параметры для бургера. Типы ингредиентов: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE},
                {FILLING},
        };
    }

    @Test
    public void testIngredientGetType() {
        Ingredient ingredient = new Ingredient(ingredientType, "hot sauce", 100);
        assertEquals(ingredientType, ingredient.getType());
    }
}
