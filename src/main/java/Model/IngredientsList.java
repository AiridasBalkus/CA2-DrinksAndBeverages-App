package Model;

import javafx.scene.control.ListView;

public class IngredientsList {
    private Ingredient head;

    public void addIngredient(String name, String description, double abv) {
        Ingredient newIngredient = new Ingredient(name, description, abv);
        if (head == null) {
            head = newIngredient;
        } else {
            Ingredient current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newIngredient;
        }
    }

    public void deleteIngredient(Ingredient ingredientToDelete) {
        if (head == null) return;

        if (head == ingredientToDelete) {
            head = head.next;
            return;
        }

        Ingredient current = head;
        while (current.next != null && current.next != ingredientToDelete) {
            current = current.next;
        }

        if (current.next == ingredientToDelete) {
            current.next = current.next.next;
        }
    }
    public void populateListView(ListView<Ingredient> listView) {
        listView.getItems().clear();
        Ingredient current = head;
        while (current != null) {
            listView.getItems().add(current);
            current = current.next;
        }
    }
}

