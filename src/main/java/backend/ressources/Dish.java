package backend.ressources;

import java.util.List;

/**
 * Dish extends the Class food as it is a special type of food which can belong to a cuisine
 */
public class Dish extends Food{
    /**
     * what countries cousine a certain dish belongs to, potential use is to compare it with the attendees preferences
     */
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
