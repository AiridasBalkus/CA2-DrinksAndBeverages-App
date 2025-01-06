package com.example.ca2real;

import Model.Drink;
import Model.Ingredient;
import Model.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SearchingController {

    @FXML
    private TextField searchField; // Input for search query
    @FXML
    private ComboBox<String> searchTypeCombo; // Dropdown for selecting search type
    @FXML
    private ListView<String> resultListView; // ListView to display results

    @FXML
    private void initialize() {
        // Populate the ComboBox with search options
        searchTypeCombo.getItems().addAll(
                "Drink Name", "Drink Description",
                "Ingredient Name", "Ingredient ABV",
                "Recipe by Drink Name", "Recipe by Ingredient Name"
        );
    }

    @FXML
    private void handleSearch() {
        String query = searchField.getText().toLowerCase().trim();
        String searchType = searchTypeCombo.getValue();

        resultListView.getItems().clear();

        if (searchType == null || query.isEmpty()) {
            resultListView.getItems().add("Please select a search type and enter a query.");
            return;
        }

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
                    double maxABV = Double.parseDouble(query);
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

    private void searchDrinksByName(String name) {
        Drink current = DrinksBeveragesApp.newDList.head;
        while (current != null) {
            if (current.getName().toLowerCase().contains(name)) {
                resultListView.getItems().add(current.toString());
            }
            current = current.next;
        }
        if (resultListView.getItems().isEmpty()) {
            resultListView.getItems().add("No drinks found with the name: " + name);
        }
    }

    private void searchDrinksByDescription(String description) {
        Drink current = DrinksBeveragesApp.newDList.head;
        while (current != null) {
            if (current.getDescription().toLowerCase().contains(description)) {
                resultListView.getItems().add(current.toString());
            }
            current = current.next;
        }
        if (resultListView.getItems().isEmpty()) {
            resultListView.getItems().add("No drinks found with the description: " + description);
        }
    }

    private void searchIngredientsByName(String name) {
        Ingredient current = DrinksBeveragesApp.newIList.head;
        while (current != null) {
            if (current.getName().toLowerCase().contains(name)) {
                resultListView.getItems().add(current.toString());
            }
            current = current.next;
        }
        if (resultListView.getItems().isEmpty()) {
            resultListView.getItems().add("No ingredients found with the name: " + name);
        }
    }

    private void searchIngredientsByABV(double maxABV) {
        Ingredient current = DrinksBeveragesApp.newIList.head;
        while (current != null) {
            if (current.getAbv() <= maxABV) {
                resultListView.getItems().add(current.toString());
            }
            current = current.next;
        }
        if (resultListView.getItems().isEmpty()) {
            resultListView.getItems().add("No ingredients found with ABV <= " + maxABV);
        }
    }

    private void searchRecipesByDrinkName(String drinkName) {
        Recipe current = DrinksBeveragesApp.newRList.head;
        while (current != null) {
            if (current.getDrinkName().toLowerCase().contains(drinkName)) {
                resultListView.getItems().add(current.toString());
            }
            current = current.next;
        }
        if (resultListView.getItems().isEmpty()) {
            resultListView.getItems().add("No recipes found for the drink: " + drinkName);
        }
    }

    private void searchRecipesByIngredientName(String ingredientName) {
        Recipe current = DrinksBeveragesApp.newRList.head;
        while (current != null) {
            if (current.getIngredientName().toLowerCase().contains(ingredientName)) {
                resultListView.getItems().add(current.toString());
            }
            current = current.next;
        }
        if (resultListView.getItems().isEmpty()) {
            resultListView.getItems().add("No recipes found using the ingredient: " + ingredientName);
        }
    }
}


