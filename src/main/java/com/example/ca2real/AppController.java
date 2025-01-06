package com.example.ca2real;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppController {
    // Method to open the Add Drink window
    @FXML
    private void openAddDrink() {
        try {
            // Load the AddDrink.fxml layout
            BorderPane addDrinkLayout = FXMLLoader.load(getClass().getResource("AddDrinks.fxml"));
            Stage addDrinkStage = new Stage();
            addDrinkStage.setTitle("Add Drink");
            Scene scene = new Scene(addDrinkLayout);
            addDrinkStage.setScene(scene);
            addDrinkStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to open the Add Ingredient window
    @FXML
    private void openAddIngredient() {
        try {
            // Load the AddIngredient.fxml layout
            BorderPane addIngredientLayout = FXMLLoader.load(getClass().getResource("AddIngredients.fxml"));
            Stage addIngredientStage = new Stage();
            addIngredientStage.setTitle("Add Ingredient");
            Scene scene = new Scene(addIngredientLayout);
            addIngredientStage.setScene(scene);
            addIngredientStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to open the Add Recipe window
    @FXML
    private void openAddRecipe() {
        try {
            // Load the AddRecipe.fxml layout
            BorderPane addRecipeLayout = FXMLLoader.load(getClass().getResource("AddRecipe.fxml"));
            Stage addRecipeStage = new Stage();
            addRecipeStage.setTitle("Add Recipe");
            Scene scene = new Scene(addRecipeLayout);
            addRecipeStage.setScene(scene);
            addRecipeStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to open the Delete Drink window
    @FXML
    private void openDeleteDrink() {
        try {
            // Load the DeleteDrink.fxml layout
            BorderPane deleteDrinkLayout = FXMLLoader.load(getClass().getResource("DeleteDrinks.fxml"));
            Stage deleteDrinkStage = new Stage();
            deleteDrinkStage.setTitle("Delete Drink");
            Scene scene = new Scene(deleteDrinkLayout);
            deleteDrinkStage.setScene(scene);
            deleteDrinkStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to open the Delete Ingredient window
    @FXML
    private void openDeleteIngredient() {
        try {
            // Load the DeleteIngredient.fxml layout
            BorderPane deleteIngredientLayout = FXMLLoader.load(getClass().getResource("DeleteIngredients.fxml"));
            Stage deleteIngredientStage = new Stage();
            deleteIngredientStage.setTitle("Delete Ingredient");
            Scene scene = new Scene(deleteIngredientLayout);
            deleteIngredientStage.setScene(scene);
            deleteIngredientStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to open the Delete Recipe window
    @FXML
    private void openDeleteRecipe() {
        try {
            // Load the DeleteRecipe.fxml layout
            BorderPane deleteRecipeLayout = FXMLLoader.load(getClass().getResource("DeleteRecipe.fxml"));
            Stage deleteRecipeStage = new Stage();
            deleteRecipeStage.setTitle("Delete Recipe");
            Scene scene = new Scene(deleteRecipeLayout);
            deleteRecipeStage.setScene(scene);
            deleteRecipeStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openSearching() {
        try {
            // Load the Searching.fxml layout as an AnchorPane
            AnchorPane search = FXMLLoader.load(getClass().getResource("Searching.fxml"));
            Stage searching = new Stage();
            searching.setTitle("Search");
            Scene scene = new Scene(search);
            searching.setScene(scene);
            searching.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
