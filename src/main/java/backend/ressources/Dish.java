package backend.ressources;

import java.util.List;

public class Dish extends Food{
    private String cuisine;

    public Dish(List<String> allergens, String cuisine, boolean isVegan, boolean isVeggy) {
        super(allergens,isVegan,isVeggy);
        this.cuisine = cuisine;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

}
