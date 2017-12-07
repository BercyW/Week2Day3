package security.bercy.com.week2day3.Model;

/**
 * Created by Bercy on 12/6/17.
 */

public class Animal {

    String name;
    String type;
    int weight;
    String description;
    String sound;

    public Animal(String name, String type, int weight, String description, String sound) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.description = description;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
