package com.example.ca2real;


import Model.DrinksList;
import Model.FileHandler;
import Model.IngredientsList;
import Model.RecipesList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileController {
    private static FileHandler fileHandler = new FileHandler();

    public static void saveDrinks(DrinksList head) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save All Added Drinks");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            fileHandler.saveDrinks(head, file);
        }
    }

    public static DrinksList loadDrinks() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load All Available Drinks");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            return fileHandler.loadDrinks(file);
        }
        return null;
    }

    public static void saveIngredients(IngredientsList head) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save All Added Ingredients");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            fileHandler.saveIngredients(head, file);
        }
    }

    public static IngredientsList loadIngredients() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load All Available Ingredients");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            return fileHandler.loadIngredients(file);
        }
        return null;
    }

    public static void saveRecipe(RecipesList head) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save All Added Recipe");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            fileHandler.saveRecipe(head, file);
        }
    }

    public static RecipesList loadRecipe() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load All Available Recipes");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            return fileHandler.loadRecipe(file);
        }
        return null;
    }
}