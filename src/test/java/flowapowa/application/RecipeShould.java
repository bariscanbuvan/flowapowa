package flowapowa.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeShould {
    @Test
    void addElement() {
        Element expected = new Element("flower", 12);

        Recipe recipe = new Recipe();
        recipe.add("flower", 12);
        for (Element element :
                recipe) {
            assertEquals(expected, element);
        }
    }

    @Test
    void buildFromRawRecipe() {

        Recipe expected = new Recipe();
        expected.add("flower", 5);

        Recipe recipe = new Recipe("flower:5;");
        assertEquals(expected, recipe);
    }
}