package backend.ressources;

import java.util.List;

/**
 * The menu of a restaurant, every menu holds n dishes that make it up, every dish has its own properties which are descreibed
 * in the class Dish
 */
public class Menu {
    private List<Dish> dishes;

    public Menu(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    /**
     * Determines whether or not any of the dishes are vegan
     * @return true if any of the dishes in the menu are vegan
     */
    public boolean hasVeganOption(){
        for(int i = 0; i < dishes.size(); i++){
            if(dishes.get(i).isVegan()) return true;
        }
        return false;
    }

    /**
     * Determines whether or not any of the dishes are vegetarian
     * @return true if any of the dishes in the menu are vegetarian
     */
    public boolean hasVeggyOption(){
        for(int i = 0; i < dishes.size(); i++){
            if(dishes.get(i).isVeggy()) return true;
        }
        return false;
    }
}
