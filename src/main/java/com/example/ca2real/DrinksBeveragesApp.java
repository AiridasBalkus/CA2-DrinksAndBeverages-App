package com.example.ca2real;

// Main Application class for the Drinks/Beverages
import Model.DrinksList;
import Model.IngredientsList;
import Model.RecipesList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

public class DrinksBeveragesApp extends Application {
    public static DrinksList newDList = new DrinksList(null);
    public static IngredientsList newIList = new IngredientsList(null);
    public static RecipesList newRList = new RecipesList(null);

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Drinks and Beverages Information System");

        // Load the FXML layout for the main application
        BorderPane mainLayout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainLayout.fxml")));

        // Set up the scene with a predefined size
        Scene scene = new Scene(mainLayout, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
