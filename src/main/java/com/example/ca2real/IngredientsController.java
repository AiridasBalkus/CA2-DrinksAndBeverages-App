package com.example.ca2real;

import Model.Ingredient;
import Model.IngredientsList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class IngredientsController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField abvField;
    @FXML
    private ListView<Ingredient> ingredientsListView;

    private IngredientsList ingredientsList = new IngredientsList();

    @FXML
    private void handleAddIngredient() {
        String name = nameField.getText();
        String description = descriptionField.getText();
        double abv = Double.parseDouble(abvField.getText());

        ingredientsList.addIngredient(name, description, abv);
        ingredientsList.populateListView(ingredientsListView);

        nameField.clear();
        descriptionField.clear();
        abvField.clear();
    }
    @FXML
    private void handleDeleteIngredient() {
        Ingredient selectedIngredient = ingredientsListView.getSelectionModel().getSelectedItem();
        if (selectedIngredient != null) {
            ingredientsList.deleteIngredient(selectedIngredient);
            ingredientsList.populateListView(ingredientsListView);
        }
    }
}

