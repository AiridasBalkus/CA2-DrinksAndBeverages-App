package Model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private XStream xstream = new XStream(new DomDriver()); // XStream instance for XML serialization and deserialization.

    /*
    Saves the drinks list to an XML file.
      head The head of the DrinksList to save.
      file The file where the XML data will be saved.
     */
    public void saveDrinks(DrinksList head, File file) {
        xstream.addPermission(AnyTypePermission.ANY); // Grants permission for all types (required for security).
        try (FileWriter writer = new FileWriter(file)) { // Creates a FileWriter for the specified file.
            String xml = xstream.toXML(head); // Converts the DrinksList object to XML.
            writer.write(xml); // Writes the XML data to the file.
            System.out.println("Data saved successfully."); // Confirmation message on successful save.
        } catch (IOException e) { // Handles any I/O errors.
            e.printStackTrace(); // Prints the stack trace for debugging.
        }
    }

    /*
      Loads a drinks list from an XML file.
      file The file containing the XML data.
     The deserialized DrinksList object.
     */
    public DrinksList loadDrinks(File file) {
        xstream.addPermission(AnyTypePermission.ANY); // Grants permission for all types (required for security).
        try (FileReader reader = new FileReader(file)) { // Creates a FileReader for the specified file.
            return (DrinksList) xstream.fromXML(reader); // Reads and converts the XML back into a DrinksList object.
        } catch (IOException e) { // Handles any I/O errors.
            e.printStackTrace(); // Prints the stack trace for debugging.
            return null; // Returns null if an error occurs.
        }
    }

    /*
      Saves the ingredients list to an XML file.
       head The head of the IngredientsList to save.
       file The file where the XML data will be saved.
     */
    public void saveIngredients(IngredientsList head, File file) {
        xstream.addPermission(AnyTypePermission.ANY); // Grants permission for all types.
        try (FileWriter writer = new FileWriter(file)) {
            String xml = xstream.toXML(head); // Converts the IngredientsList object to XML.
            writer.write(xml);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
      Loads an ingredients list from an XML file.
      file The file containing the XML data.
      The deserialized IngredientsList object.
     */
    public IngredientsList loadIngredients(File file) {
        xstream.addPermission(AnyTypePermission.ANY); // Grants permission for all types.
        try (FileReader reader = new FileReader(file)) {
            return (IngredientsList) xstream.fromXML(reader); // Reads and converts the XML back into an IngredientsList object.
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
      Saves the recipes list to an XML file.
     head The head of the RecipesList to save.
     file The file where the XML data will be saved.
     */
    public void saveRecipe(RecipesList head, File file) {
        xstream.addPermission(AnyTypePermission.ANY); // Grants permission for all types.
        try (FileWriter writer = new FileWriter(file)) {
            String xml = xstream.toXML(head); // Converts the RecipesList object to XML.
            writer.write(xml);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
      Loads a recipes list from an XML file.
      file The file containing the XML data.
      The deserialized RecipesList object.
     */
    public RecipesList loadRecipe(File file) {
        xstream.addPermission(AnyTypePermission.ANY); // Grants permission for all types.
        try (FileReader reader = new FileReader(file)) {
            return (RecipesList) xstream.fromXML(reader); // Reads and converts the XML back into a RecipesList object.
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}