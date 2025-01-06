package Model;

import javafx.scene.control.ListView;

public class DrinksList {
    public Drink head;

    public DrinksList(Drink head)
    {this.head = null;
    }

    public Drink addDrink(String name, String origin, String description, String imageUrl) {
        Drink newDrink = new Drink(name, origin, description, imageUrl);
        if (head == null) {
            head = newDrink;
        } else {
            Drink current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newDrink;
        }
        return newDrink;
    }

    public void deleteDrink(Drink drinkToDelete) {
        if (head == null) return;

        if (head == drinkToDelete) {
            head = head.next;
            return;
        }

        Drink current = head;
        while (current.next != null && current.next != drinkToDelete) {
            current = current.next;
        }

        if (current.next == drinkToDelete) {
            current.next = current.next.next;
        }
    }

    public void populateListView(ListView<Drink> listView) {
        listView.getItems().clear();
        Drink current = head;
        while (current != null) {
            listView.getItems().add(current);
            current = current.next;
        }
    }
}