package Model;

import javafx.scene.control.ListView;


public class DrinksList {
    public Drink head; // The head (first node) of the linked list.

    // Constructor to initialize the linked list. By default, the head is set to null.
    public DrinksList(Drink head) {
        this.head = null;
    }

    /*
      Adds a new drink to the linked list.
      name The name of the drink.
      origin The origin or source of the drink.
      description A description of the drink.
      imageUrl The URL of an image representing the drink.
      The newly added Drink object.
     */
    public Drink addDrink(String name, String origin, String description, String imageUrl) {
        Drink newDrink = new Drink(name, origin, description, imageUrl); // Create a new Drink object.
        if (head == null) { // If the list is empty, set the new drink as the head.
            head = newDrink;
        } else { // Otherwise, traverse the list to find the last node.
            Drink current = head;
            while (current.next != null) { // Move to the end of the list.
                current = current.next;
            }
            current.next = newDrink; // Add the new drink to the end of the list.
        }
        return newDrink; // Return the newly added drink.
    }


     // Deletes a specified drink from the linked list.

    public void deleteDrink(Drink drinkToDelete) {
        if (head == null) return; // If the list is empty, do nothing.

        if (head == drinkToDelete) { // If the head is the drink to delete, move the head to the next node.
            head = head.next;
            return;
        }

        // Traverse the list to find the drink to delete.
        Drink current = head;
        while (current.next != null && current.next != drinkToDelete) {
            current = current.next; // Move to the next node.
        }

        // If the drink to delete is found, remove it by updating the references.
        if (current.next == drinkToDelete) {
            current.next = current.next.next;
        }
    }

     // Populates a JavaFX ListView with the drinks in the linked list.
    public void populateListView(ListView<Drink> listView) {
        listView.getItems().clear(); // Clear any existing items in the ListView.
        Drink current = head; // Start from the head of the list.
        while (current != null) { // Traverse the list.
            listView.getItems().add(current); // Add each drink to the ListView.
            current = current.next; // Move to the next drink.
        }
    }

    // Sorts the drinks list by name using merge sort
    public void sortDrinksByName() {
        head = mergeSort(head);
    }


// This method initiates the merge sort process on the linked list.
// It sets the head of the sorted list after sorting.

    private Drink mergeSort(Drink head) {
        if (head == null || head.next == null) {
            return head; // Base case: A list with zero or one element is already sorted.
        }

        Drink middle = getMiddle(head); // Find the middle of the list to split it.
        Drink nextToMiddle = middle.next;
        middle.next = null; // Split the list into two halves.

        // Recursively sort the two halves of the list.
        Drink left = mergeSort(head);
        Drink right = mergeSort(nextToMiddle);

        // Merge the two sorted halves into a single sorted list.
        return merge(left, right);
    }
// This method recursively splits the list into smaller parts until each part contains one node.
// It then merges the sorted parts into a single sorted list.

    private Drink merge(Drink left, Drink right) {
        if (left == null) return right; // If the left list is empty, return the right list.
        if (right == null) return left; // If the right list is empty, return the left list.

        Drink result;
        if (left.getName().compareToIgnoreCase(right.getName()) <= 0) {
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

    private Drink getMiddle(Drink head) {
        if (head == null) return head; // If the list is empty, return null.

        Drink slow = head;
        Drink fast = head;

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
