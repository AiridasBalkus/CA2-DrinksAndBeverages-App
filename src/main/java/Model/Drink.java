package Model;

public class Drink {
    private String name;
    private String origin;
    private String description;
    private String imageUrl;
    public Drink next; // Pointer to the next Drink in the list

    public Drink(String name, String origin, String description, String imageUrl) {
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.imageUrl = imageUrl;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Drink name: " + name + '\'' + ", country of origin: " + origin + '\'' + ", description: " + description + '\'';
    }
}


