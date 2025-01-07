package com.example.ca2real;

import Model.DrinksList;
import Model.Recipe;
import Model.RecipesList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

// Controller class for managing recipes in a JavaFX application
public class RecipeController {

    // FXML-bound fields for user input and displaying recipes
    @FXML
    private TextField drinkNameField; // Field for entering the drink's name
    @FXML
    private TextField ingredientNameField; // Field for entering the ingredient's name
    @FXML
    private TextField quantityField; // Field for entering the quantity of the ingredient
    @FXML
    private ListView<Recipe> recipesListView; // ListView for displaying the list of recipes

    // Handles the action of adding a new recipe
    @FXML
    private void handleAddRecipe() {
        // Retrieve input values from the text fields
        String drinkName = drinkNameField.getText(); // Name of the drink
        String ingredientName = ingredientNameField.getText(); // Name of the ingredient
        double quantity = Double.parseDouble(quantityField.getText()); // Convert quantity to a double

        // Add the new recipe to the recipe list
        DrinksBeveragesApp.newRList.addRecipe(drinkName, ingredientName, quantity);
        populateRecipeView(); // Refresh the recipe view

        // Clear the input fields for further entries
        drinkNameField.clear();
        ingredientNameField.clear();
        quantityField.clear();
    }

    // Handles the action of deleting the selected recipe
    @FXML
    private void handleDeleteRecipe() {
        // Get the selected recipe from the ListView
        Recipe selectedRecipe = recipesListView.getSelectionModel().getSelectedItem();
        if (selectedRecipe != null) { // Ensure a recipe is selected
            // Delete the selected recipe and refresh the ListView
            DrinksBeveragesApp.newRList.deleteRecipe(selectedRecipe);
            populateRecipeView();
        }
    }

    // Populates the ListView with the updated recipes list
    private void populateRecipeView() {
        DrinksBeveragesApp.newRList.populateListView(recipesListView);
    }

    // Updates the ListView, ensuring it reflects the current state of the recipes list
    @FXML
    private void updateListView() {
        populateRecipeView();
    }

    // Saves the current list of recipes to a file
    @FXML
    public void saveRecipe() {
        FileController.saveRecipe(DrinksBeveragesApp.newRList);
    }

    // Loads a list of recipes from a file and updates the application
    @FXML
    public void loadRecipe() {
        RecipesList loadedData = FileController.loadRecipe(); // Load data from file
        if (loadedData != null) { // Check if the data was successfully loaded
            DrinksBeveragesApp.newRList = loadedData; // Replace the current list with the loaded data
            // Optionally, refresh the UI if necessary
        }
    }
}

