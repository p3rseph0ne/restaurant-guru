package backend.ressources;

import java.util.List;

/**
 * Food is an abstract class and therefor only functions as a "template" for dishes and can not be instanced as itself
 */
public abstract class Food {
    private List<String> allergens;
    private boolean isVegan;
    private boolean isVeggy;

    public Food(List<String> allergens, boolean isVegan, boolean isVeggy){
        this.allergens = allergens;
        this.isVegan = isVegan;
        this.isVeggy = isVeggy;
    }


    public List<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<String> allergens) {
        this.allergens = allergens;
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
