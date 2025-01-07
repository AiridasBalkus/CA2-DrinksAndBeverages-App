package com.example.ca2real;


import Model.DrinksList;
import Model.Recipe;
import Model.RecipesList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class RecipeController {
    @FXML
    private TextField drinkNameField;
    @FXML
    private TextField ingredientNameField;
    @FXML
    private TextField quantityField;
    @FXML
    private ListView<Recipe> recipesListView;

    @FXML
    private void handleAddRecipe() {
        String drinkName = drinkNameField.getText();
        String ingredientName = ingredientNameField.getText();
        double quantity = Double.parseDouble(quantityField.getText());

        DrinksBeveragesApp.newRList.addRecipe(drinkName, ingredientName, quantity);
        populateRecipeView();

        drinkNameField.clear();
        ingredientNameField.clear();
        quantityField.clear();
    }

    @FXML
    private void handleDeleteRecipe() {
        Recipe selectedRecipe = recipesListView.getSelectionModel().getSelectedItem();
        if (selectedRecipe != null) {
            DrinksBeveragesApp.newRList.deleteRecipe(selectedRecipe);
            populateRecipeView();
        }
    }

    private void populateRecipeView() {
        DrinksBeveragesApp.newRList.populateListView(recipesListView);
    }

    @FXML
    private void updateListView() {
        populateRecipeView();
    }

    @FXML
    public void saveRecipe() {
        FileController.saveRecipe(DrinksBeveragesApp.newRList);
    }

    @FXML
    public void loadRecipe() {
        RecipesList loadedData = FileController.loadRecipe();
        if (loadedData != null) {
            DrinksBeveragesApp.newRList = loadedData;
            // Optionally refresh the UI
        }
    }
}
