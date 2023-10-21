package backend;

import java.util.Date;
import java.util.List;

public class Lunch {

    private List<Employee> emps;
    private List<Customer> customs;
    private List<String> preferences;
    private List<String> allergies;
    private Date today;
    private String weather;
    private List<Restaurant> allRestaurants;
    private List<Restaurant> availableRestaurants;

    public Lunch(List<Employee> emps, List<Customer> customs, Date today, String weather) {
        this.emps = emps;
        this.customs = customs;
        this.today = today;
        this.weather = weather;

        //iterate over customer and employee to initialize allergies and preferences

        readRestaurants();
        readAllergies(emps,customs);
        defineAvailableRestaurants(today);
    }

    public List<Restaurant> getAvailableRestaurants() {
        return availableRestaurants;
    }

    private void readAllergies(List<Employee> emps, List<Customer> customs){
        //iterate over allergies of Persons, checking if allergie is already on list or not

    }

    private void readRestaurants(){
        //call dom implementation that reads a file with restaurant data
    }
    public List<Restaurant> defineAvailableRestaurants(Date today){
        //
        for(int i = 0;i < allRestaurants.size(); i++){
            Restaurant currRest = allRestaurants.get(i);
            //check opening hours
            if(currRest.isOpen(today)){
                //check allergies
                for(int j = 0; j < currRest.getMenu().getDishes().size(); j++){
                    Dish currDish = currRest.getMenu().getDishes().get(j);
                    if(!currDish.getAllergens().containsAll(this.allergies)){
                        availableRestaurants.add(currRest);
                    }
                }

            }
        }
        return availableRestaurants;
    }

    public Restaurant randomRestaurant(){
        int random = 0;
        //implement random number generator with max value == amount of available restaurants
        //that returns a Restaurant from the list availableRestaurants at that point in the list

        return availableRestaurants.get(random);
    }
}
