package com.example.ca2real;

import Model.Drink;
import Model.DrinksList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class DrinksController {
    // Instance of FileController to manage file operations for drinks
    private FileController fileController = new FileController();

    // UI elements from the FXML file
    @FXML
    private TextField nameField; // Input field for the drink's name
    @FXML
    private TextField originField; // Input field for the drink's origin
    @FXML
    private TextField descriptionField; // Input field for the drink's description
    @FXML
    private TextField imageUrlField; // Input field for the drink's image URL
    @FXML
    private ListView<Drink> drinksListView; // ListView to display the drinks list

    // Handler for adding a new drink
    @FXML
    private void handleAddDrink() {
        // Retrieve input values from the text fields
        String name = nameField.getText();
        String origin = originField.getText();
        String description = descriptionField.getText();
        String imageUrl = imageUrlField.getText();

        // Create and add a new drink to the drinks list
        Drink newDrink = DrinksBeveragesApp.newDList.addDrink(name, origin, description, imageUrl);

        // Refresh the ListView to display the updated drinks list
        populateDrinksView();

        // Clear the input fields after adding the drink
        nameField.clear();
        originField.clear();
        descriptionField.clear();
        imageUrlField.clear();
    }

    // Populates the ListView with drinks data
    private void populateDrinksView() {
        DrinksBeveragesApp.newDList.populateListView(drinksListView);
    }

    // Handler for deleting the selected drink
    @FXML
    private void handleDeleteDrink() {
        // Get the selected drink from the ListView
        Drink selectedDrink = drinksListView.getSelectionModel().getSelectedItem();

        if (selectedDrink != null) { // Ensure a drink is selected
            // Remove the selected drink from the list
            DrinksBeveragesApp.newDList.deleteDrink(selectedDrink);

            // Refresh the ListView after deletion
            DrinksBeveragesApp.newDList.populateListView(drinksListView);
        }
    }

    // Updates the ListView with the latest drinks data
    @FXML
    private void updateListView() {
        populateDrinksView();
    }

    // Saves the drinks list to a file
    @FXML
    public void saveDrinks() {
        FileController.saveDrinks(DrinksBeveragesApp.newDList);
    }

    // Loads the drinks list from a file
    @FXML
    public void loadDrinks() {
        // Load drinks data from a file
        DrinksList loadedData = FileController.loadDrinks();

        if (loadedData != null) { // Check if the loaded data is valid
            DrinksBeveragesApp.newDList = loadedData;

            // Optionally refresh the UI to reflect the loaded data
            populateDrinksView();
        }
    }
}

