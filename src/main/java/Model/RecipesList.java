package Model;

import javafx.scene.control.ListView;

public class RecipesList {
    private Recipe head;

    public void addRecipe(String drinkName, String ingredientName, double quantity) {
        Recipe newRecipe = new Recipe(drinkName, ingredientName, quantity);
        if (head == null) {
            head = newRecipe;
        } else {
            Recipe current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newRecipe;
        }
    }

    public void deleteRecipe(Recipe recipeToDelete) {
        if (head == null) return;

        if (head == recipeToDelete) {
            head = head.next;
            return;
        }

        Recipe current = head;
        while (current.next != null && current.next != recipeToDelete) {
            current = current.next;
        }

        if (current.next == recipeToDelete) {
            current.next = current.next.next;
        }
    }

    public void populateListView(ListView<Recipe> listView) {
        listView.getItems().clear();
        Recipe current = head;
        while (current != null) {
            listView.getItems().add(current);
            current = current.next;
        }
    }
}
