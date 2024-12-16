package Model;

public class Ingredient {
    private String name;
    private String description;
    private double abv;
    public Ingredient next; // Pointer to the next Ingredient in the list

    public Ingredient(String name, String description, double abv) {
        this.name = name;
        this.description = description;
        this.abv = abv;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }
    @Override
    public String toString() {
        return "Ingredient name " + name + '\'' + ", description='" + description + '\'' + ", abv=" + abv + '}';
    }
}