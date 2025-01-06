package com.example.ca2real;


import Model.DrinksList;
import Model.FileHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileController {
    private static FileHandler fileHandler = new FileHandler();

    public static void saveAll(DrinksList head) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save All Added Drinks");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            fileHandler.saveDrinks(head, file);
        }
    }

    public static DrinksList loadAll() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load All Available Drinks");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            return fileHandler.loadDrinks(file);
        }
        return null;
    }
}