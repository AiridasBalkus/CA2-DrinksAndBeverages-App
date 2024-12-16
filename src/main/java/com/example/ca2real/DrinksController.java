package com.example.ca2real;

import Model.Drink;
import Model.DrinksList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class DrinksController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField originField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField imageUrlField;
    @FXML
    private ListView<Drink> drinksListView;


    @FXML
    private void handleAddDrink() {
        String name = nameField.getText();
        String origin = originField.getText();
        String description = descriptionField.getText();
        String imageUrl = imageUrlField.getText();

       Drink newDrink = DrinksBeveragesApp.newDList.addDrink(name, origin, description, imageUrl);
        populateDrinksView();

        nameField.clear();
        originField.clear();
        descriptionField.clear();
        imageUrlField.clear();
    }

    private void populateDrinksView() {
        DrinksBeveragesApp.newDList.populateListView(drinksListView);
    }

    @FXML
    private void handleDeleteDrink() {
        Drink selectedDrink = drinksListView.getSelectionModel().getSelectedItem();
        if (selectedDrink != null) {
            DrinksBeveragesApp.newDList.deleteDrink(selectedDrink);
            DrinksBeveragesApp.newDList.populateListView(drinksListView);
        }
    }

    @FXML
    private void updateListView() {
        populateDrinksView();
    }
}
