package Model;

public class Recipe {
    private String drinkName;
    private String ingredientName;
    private double quantity;
    public Recipe next; // Pointer to the next Recipe in the list

    public Recipe(String drinkName, String ingredientName, double quantity) {
        this.drinkName = drinkName;
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.next = null;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Recipe Name: '" + drinkName + '\'' + ", Ingredient Name: " + ingredientName + '\'' + ", quantity: " + quantity;
    }
}