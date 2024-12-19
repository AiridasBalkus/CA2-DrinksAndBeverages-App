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

    @FXML
    private void handleAddIngredient() {
        String name = nameField.getText();
        String description = descriptionField.getText();
        double abv = Double.parseDouble(abvField.getText());

        Ingredient newIngredient = DrinksBeveragesApp.newIList.addIngredient(name, description, abv);
        populateIngredientsView();

        nameField.clear();
        descriptionField.clear();
        abvField.clear();
    }
    @FXML
    private void handleDeleteIngredient() {
        Ingredient selectedIngredient = ingredientsListView.getSelectionModel().getSelectedItem();
        if (selectedIngredient != null) {
            DrinksBeveragesApp.newIList.deleteIngredient(selectedIngredient);
            DrinksBeveragesApp.newIList.populateListView(ingredientsListView);
        }
    }

    private void populateIngredientsView() {
        DrinksBeveragesApp.newIList.populateListView(ingredientsListView);
    }

    @FXML
    private void updateListView() {
        populateIngredientsView();
    }
}

