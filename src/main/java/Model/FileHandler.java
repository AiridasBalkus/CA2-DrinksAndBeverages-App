package Model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private XStream xstream = new XStream(new DomDriver());

    public void saveDrinks(DrinksList head, File file) {
        xstream.addPermission(AnyTypePermission.ANY);
        try (FileWriter writer = new FileWriter(file)) {
            String xml = xstream.toXML(head);
            writer.write(xml);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DrinksList loadDrinks(File file) {
        xstream.addPermission(AnyTypePermission.ANY);
        try (FileReader reader = new FileReader(file)) {
            return (DrinksList) xstream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}