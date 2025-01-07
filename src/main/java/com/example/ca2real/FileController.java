package com.example.ca2real;

import Model.DrinksList;
import Model.FileHandler;
import Model.IngredientsList;
import Model.RecipesList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileController {

    // FileHandler instance to handle file save/load operations
    private static FileHandler fileHandler = new FileHandler();

    /*
     Saves the list of drinks to a user-specified XML file.
      head the DrinksList object to be saved.
     */
    public static void saveDrinks(DrinksList head) {
        // Configure the file chooser dialog for saving drinks
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save All Added Drinks");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        // Open a save dialog and retrieve the selected file
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            // Save drinks data to the chosen file
            fileHandler.saveDrinks(head, file);
        }
    }

    /*
      Loads the list of drinks from a user-specified XML file.
      a DrinksList object loaded from the file, or null if no file is selected.
     */
    public static DrinksList loadDrinks() {
        // Configure the file chooser dialog for loading drinks
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load All Available Drinks");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        // Open a load dialog and retrieve the selected file
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            // Load drinks data from the chosen file
            return fileHandler.loadDrinks(file);
        }
        return null;
    }

    /*
      Saves the list of ingredients to a user-specified XML file.
      the IngredientsList object to be saved.
     */
    public static void saveIngredients(IngredientsList head) {
        // Configure the file chooser dialog for saving ingredients
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save All Added Ingredients");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        // Open a save dialog and retrieve the selected file
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            // Save ingredients data to the chosen file
            fileHandler.saveIngredients(head, file);
        }
    }


      //Loads the list of ingredients from a user-specified XML file.

    public static IngredientsList loadIngredients() {
        // Configure the file chooser dialog for loading ingredients
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load All Available Ingredients");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        // Open a load dialog and retrieve the selected file
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            // Load ingredients data from the chosen file
            return fileHandler.loadIngredients(file);
        }
        return null;
    }


     //Saves the list of recipes to a user-specified XML file.


    public static void saveRecipe(RecipesList head) {
        // Configure the file chooser dialog for saving recipes
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save All Added Recipe");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        // Open a save dialog and retrieve the selected file
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            // Save recipes data to the chosen file
            fileHandler.saveRecipe(head, file);
        }
    }


     //Loads the list of recipes from a user-specified XML file

    public static RecipesList loadRecipe() {
        // Configure the file chooser dialog for loading recipes
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load All Available Recipes");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        // Open a load dialog and retrieve the selected file
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            // Load recipes data from the chosen file
            return fileHandler.loadRecipe(file);
        }
        return null;
    }
}
