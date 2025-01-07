package com.example.ca2real;

import Model.DrinksList;
import Model.Ingredient;
import Model.IngredientsList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

// Controller class for managing ingredients in a JavaFX application
public class IngredientsController {

    // FXML-bound fields for user input and displaying ingredients
    @FXML
    private TextField nameField; // Field for entering the ingredient's name
    @FXML
    private TextField descriptionField; // Field for entering the ingredient's description
    @FXML
    private TextField abvField; // Field for entering the ingredient's ABV (Alcohol by Volume)
    @FXML
    private ListView<Ingredient> ingredientsListView; // ListView for displaying the list of ingredients

    // Handles the action of adding a new ingredient
    @FXML
    private void handleAddIngredient() {
        // Retrieve input values from the text fields
        String name = nameField.getText();
        String description = descriptionField.getText();
        double abv = Double.parseDouble(abvField.getText()); // Convert ABV to a double

        // Create a new ingredient and add it to the list
        Ingredient newIngredient = DrinksBeveragesApp.newIList.addIngredient(name, description, abv);
        populateIngredientsView(); // Refresh the ingredients view

        // Clear the input fields for further entries
        nameField.clear();
        descriptionField.clear();
        abvField.clear();
    }

    // Handles the action of deleting the selected ingredient
    @FXML
    private void handleDeleteIngredient() {
        // Get the selected ingredient from the ListView
        Ingredient selectedIngredient = ingredientsListView.getSelectionModel().getSelectedItem();
        if (selectedIngredient != null) { // Ensure an ingredient is selected
            // Delete the selected ingredient and refresh the ListView
            DrinksBeveragesApp.newIList.deleteIngredient(selectedIngredient);
            DrinksBeveragesApp.newIList.populateListView(ingredientsListView);
        }
    }

    // Populates the ListView with the updated ingredients list
    private void populateIngredientsView() {
        DrinksBeveragesApp.newIList.populateListView(ingredientsListView);
    }

    // Updates the ListView, ensuring it reflects the current state of the ingredients list
    @FXML
    private void updateListView() {
        populateIngredientsView();
    }

    // Saves the current list of ingredients to a file
    @FXML
    public void saveIngredients() {
        FileController.saveIngredients(DrinksBeveragesApp.newIList);
    }

    // Loads a list of ingredients from a file and updates the application
    @FXML
    public void loadIngredients() {
        IngredientsList loadedData = FileController.loadIngredients(); // Load data from file
        if (loadedData != null) { // Check if the data was successfully loaded
            DrinksBeveragesApp.newIList = loadedData; // Replace the current list with the loaded data
            // Optionally, refresh the UI if necessary
        }
    }
}

