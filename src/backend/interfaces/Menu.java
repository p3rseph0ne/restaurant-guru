package backend.interfaces;

import java.util.List;

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

    public boolean hasVeganOption(){
        for(int i = 0; i < dishes.size(); i++){
            if(dishes.get(i).isVegan()) return true;
        }
        return false;
    }
    public boolean hasVeggyOption(){
        for(int i = 0; i < dishes.size(); i++){
            if(dishes.get(i).isVeggy()) return true;
        }
        return false;
    }
}
