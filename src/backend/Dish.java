package backend;

import java.util.List;

public class Dish {
    private List<String> allergens;
    private String cuisine;
    private boolean isVegan;
    private boolean isVeggy;

    public Dish(List<String> allergens, String cuisine, boolean isVegan, boolean isVeggy) {
        this.allergens = allergens;
        this.cuisine = cuisine;
        this.isVegan = isVegan;
        this.isVeggy = isVeggy;
    }

    public List<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<String> allergens) {
        this.allergens = allergens;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean isVeggy() {
        return isVeggy;
    }

    public void setVeggy(boolean veggy) {
        isVeggy = veggy;
    }
}
