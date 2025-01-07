package Model;

import javafx.scene.control.ListView;

public class RecipesList {
    public Recipe head; // The head (first node) of the linked list.

    // Constructor to initialize the linked list. The head is set to null by default.
    public RecipesList(Recipe head) {
        this.head = null;
    }

    // Adds a new recipe to the linked list.
    public void addRecipe(String drinkName, String ingredientName, double quantity) {
        Recipe newRecipe = new Recipe(drinkName, ingredientName, quantity); // Create a new Recipe object.
        if (head == null) { // If the list is empty, set the new recipe as the head.
            head = newRecipe;
        } else { // Otherwise, traverse the list to find the last node.
            Recipe current = head;
            while (current.next != null) { // Move to the end of the list.
                current = current.next;
            }
            current.next = newRecipe; // Add the new recipe to the end of the list.
        }
    }

    // Deletes a specific recipe from the linked list.
    public void deleteRecipe(Recipe recipeToDelete) {
        if (head == null) return; // If the list is empty, do nothing.

        if (head == recipeToDelete) { // If the head is the recipe to delete, move the head to the next node.
            head = head.next;
            return;
        }

        // Traverse the list to find the recipe to delete.
        Recipe current = head;
        while (current.next != null && current.next != recipeToDelete) {
            current = current.next; // Move to the next node.
        }

        // If the recipe to delete is found, remove it by updating the references.
        if (current.next == recipeToDelete) {
            current.next = current.next.next;
        }
    }

    // Populates a JavaFX ListView with the recipes in the linked list.
    public void populateListView(ListView<Recipe> listView) {
        listView.getItems().clear(); // Clear any existing items in the ListView.
        Recipe current = head; // Start from the head of the list.
        while (current != null) { // Traverse the list.
            listView.getItems().add(current); // Add each recipe to the ListView.
            current = current.next; // Move to the next recipe.
        }
    }

    public void sortRecipeByName() {
        head = mergeSort(head);
    }


// This method initiates the merge sort process on the linked list.
// It sets the head of the sorted list after sorting.

    private Recipe mergeSort(Recipe head) {
        if (head == null || head.next == null) {
            return head; // Base case: A list with zero or one element is already sorted.
        }

        Recipe middle = getMiddle(head); // Find the middle of the list to split it.
        Recipe nextToMiddle = middle.next;
        middle.next = null; // Split the list into two halves.

        // Recursively sort the two halves of the list.
        Recipe left = mergeSort(head);
        Recipe right = mergeSort(nextToMiddle);

        // Merge the two sorted halves into a single sorted list.
        return merge(left, right);
    }
// This method recursively splits the list into smaller parts until each part contains one node.
// It then merges the sorted parts into a single sorted list.

    private Recipe merge(Recipe left, Recipe right) {
        if (left == null) return right; // If the left list is empty, return the right list.
        if (right == null) return left; // If the right list is empty, return the left list.

        Recipe result;
        if (left.getDrinkName().compareToIgnoreCase(right.getDrinkName()) <= 0) {
            result = left; // Select the left node if its name is lexicographically smaller or equal.
            result.next = merge(left.next, right); // Recursively merge the rest of the list.
        } else {
            result = right; // Select the right node if its name is smaller.
            result.next = merge(left, right.next); // Recursively merge the rest of the list.
        }
        return result;
    }
// This method merges two sorted linked lists into one sorted list.
// It compares the names of the drinks and arranges them in ascending order.

    private Recipe getMiddle(Recipe head) {
        if (head == null) return head; // If the list is empty, return null.

        Recipe slow = head;
        Recipe fast = head;

        // Move the fast pointer two steps for every one step of the slow pointer.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // When the fast pointer reaches the end, the slow pointer is at the middle.
    }
// This method finds the middle node of the linked list using the slow and fast pointer technique.
// It is used to split the list into two halves for merge sort.
}
