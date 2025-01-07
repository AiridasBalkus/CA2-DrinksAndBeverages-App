package com.example.ca2real;

import Model.Drink;
import Model.Ingredient;
import Model.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

// Controller class for managing search functionality in a JavaFX application
public class SearchingController {

    @FXML
    private TextField searchField; // Text input for entering the search query
    @FXML
    private ComboBox<String> searchTypeCombo; // Dropdown for selecting the type of search
    @FXML
    private ListView<String> resultListView; // ListView to display search results

    // Initializes the ComboBox with search type options
    @FXML
    private void initialize() {
        searchTypeCombo.getItems().addAll(
                "Drink Name", "Drink Description",
                "Ingredient Name", "Ingredient ABV",
                "Recipe by Drink Name", "Recipe by Ingredient Name"
        );
    }

    // Handles the search operation based on the selected type and query
    @FXML
    private void handleSearch() {
        String query = searchField.getText().toLowerCase().trim(); // Normalize input
        String searchType = searchTypeCombo.getValue(); // Get selected search type

        // Clear previous results
        resultListView.getItems().clear();

        // Validate input
        if (searchType == null || query.isEmpty()) {
            resultListView.getItems().add("Please select a search type and enter a query.");
            return;
        }

        // Perform the search based on the selected type
        switch (searchType) {
            case "Drink Name":
                searchDrinksByName(query);
                break;
            case "Drink Description":
                searchDrinksByDescription(query);
                break;
            case "Ingredient Name":
                searchIngredientsByName(query);
                break;
            case "Ingredient ABV":
                try {
                    double maxABV = Double.parseDouble(query); // Validate numeric input for ABV
                    searchIngredientsByABV(maxABV);
                } catch (NumberFormatException e) {
                    resultListView.getItems().add("Invalid ABV value. Please enter a number.");
                }
                break;
            case "Recipe by Drink Name":
                searchRecipesByDrinkName(query);
                break;
            case "Recipe by Ingredient Name":
                searchRecipesByIngredientName(query);
                break;
            default:
                resultListView.getItems().add("Invalid search type selected.");
        }
    }

    // Searches for drinks by name
    private void searchDrinksByName(String name) {
        DrinksBeveragesApp.newDList.sortDrinksByName(); // Sort the drinks list before searching.

        Drink current = DrinksBeveragesApp.newDList.head;
        resultListView.getItems().clear(); // Clear any previous search results.
        while (current != null) {
            if (current.getName().toLowerCase().contains(name.toLowerCase())) {
                resultListView.getItems().add(current.toString());
            }
            current = current.next;
        }
        if (resultListView.getItems().isEmpty()) {
            resultListView.getItems().add("No drinks found with the name: " + name);
        }
    }

    // Searches for drinks by description
    private void searchDrinksByDescription(String description) {
        // Start from the head of the drink list
        Drink current = DrinksBeveragesApp.newDList.head;
        while (current != null) {
            // Check if the description of the current drink contains the given string (case-insensitive)
            if (current.getDescription().toLowerCase().contains(description)) {
                // Add the matching drink to the result list view
                resultListView.getItems().add(current.toString());
            }
            current = current.next; // Move to the next drink
        }
        // If no drinks matched, display a message
        if (resultListView.getItems().isEmpty()) {
            resultListView.getItems().add("No drinks found with the description: " + description);
        }
    }

    // Searches for ingredients by name
    private void searchIngredientsByName(String name) {
        // Sort the ingredient list alphabetically by name
        DrinksBeveragesApp.newIList.sortIngredientsByName();

        // Start from the head of the ingredient list
        Ingredient current = DrinksBeveragesApp.newIList.head;
        while (current != null) {
            // Check if the name of the current ingredient contains the given string (case-insensitive)
            if (current.getName().toLowerCase().contains(name)) {
                // Add the matching ingredient to the result list view
                resultListView.getItems().add(current.toString());
            }
            current = current.next; // Move to the next ingredient
        }
        // If no ingredients matched, display a message
        if (resultListView.getItems().isEmpty()) {
            resultListView.getItems().add("No ingredients found with the name: " + name);
        }
    }

    // Searches for ingredients by ABV (Alcohol by Volume)
    private void searchIngredientsByABV(double maxABV) {
        // Start from the head of the ingredient list
        Ingredient current = DrinksBeveragesApp.newIList.head;
        while (current != null) {
            // Check if the ABV of the current ingredient is less than or equal to the given maximum ABV
            if (current.getAbv() <= maxABV) {
                // Add the matching ingredient to the result list view
                resultListView.getItems().add(current.toString());
            }
            current = current.next; // Move to the next ingredient
        }
        // If no ingredients matched, display a message
        if (resultListView.getItems().isEmpty()) {
            resultListView.getItems().add("No ingredients found with ABV <= " + maxABV);
        }
    }

    // Searches for recipes by drink name
    private void searchRecipesByDrinkName(String drinkName) {
        // Sort the recipe list alphabetically by drink name
        DrinksBeveragesApp.newRList.sortRecipeByName();

        // Start from the head of the recipe list
        Recipe current = DrinksBeveragesApp.newRList.head;
        while (current != null) {
            // Check if the drink name of the current recipe contains the given string (case-insensitive)
            if (current.getDrinkName().toLowerCase().contains(drinkName)) {
                // Add the matching recipe to the result list view
                resultListView.getItems().add(current.toString());
            }
            current = current.next; // Move to the next recipe
        }
        // If no recipes matched, display a message
        if (resultListView.getItems().isEmpty()) {
            resultListView.getItems().add("No recipes found for the drink: " + drinkName);
        }
    }

    // Searches for recipes by ingredient name
    private void searchRecipesByIngredientName(String ingredientName) {
        // Start from the head of the recipe list
        Recipe current = DrinksBeveragesApp.newRList.head;
        while (current != null) {
            // Check if the ingredient name of the current recipe contains the given string (case-insensitive)
            if (current.getIngredientName().toLowerCase().contains(ingredientName)) {
                // Add the matching recipe to the result list view
                resultListView.getItems().add(current.toString());
            }
            current = current.next; // Move to the next recipe
        }
        // If no recipes matched, display a message
        if (resultListView.getItems().isEmpty()) {
            resultListView.getItems().add("No recipes found using the ingredient: " + ingredientName);
        }
    }
}


