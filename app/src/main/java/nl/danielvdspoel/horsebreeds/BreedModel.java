package nl.danielvdspoel.horsebreeds;

public class BreedModel {
    String name;
    String color;
    String description;
    int id;

    public BreedModel(int id, String name, String color, String description) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }
}
