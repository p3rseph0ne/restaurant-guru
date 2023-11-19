package backend.businesslogic;

import backend.ressources.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lunch {

    private List<Person> checkedPerson;
    private List<String> preferences;
    private List<String> allergies;
    private String day;
    private String time;
    private List<Restaurant> allRestaurants;
    private List<Restaurant> availableRestaurants;

    public Lunch(List<Person> checkedPerson, String day, String time) throws IncorrectFileNameException {
        this.checkedPerson = checkedPerson;
        this.day = day;
        this.time = time;
        System.out.println("lunch created");
        readRestaurants();
        readAllergiesAndPreferences();
        defineAvailableRestaurants();

    }

    public List<Restaurant> getAvailableRestaurants() {
        return availableRestaurants;
    }

    public void readAllergiesAndPreferences(){

        for(Person p : checkedPerson){

            allergies = new ArrayList<String>();
            preferences = new ArrayList<String>();

            for(String s:p.getAllergies()){
                if(!allergies.contains(s)) allergies.add(s);
            }
            for(String s:p.getPreferences()){
                if(!preferences.contains(s)) preferences.add(s);
            }
        }

    }

    public void readRestaurants() throws IncorrectFileNameException {
        allRestaurants = new ArrayList<Restaurant>();

        RestaurantReader restaurantReader = new RestaurantReader();
        //restaurantReader.update();
        allRestaurants = restaurantReader.getRestaurants();

        System.out.println("size of all restaurants: "+allRestaurants.size());
    }
    public void defineAvailableRestaurants(){
        System.out.println("finding available restaurant");
        availableRestaurants = new ArrayList<Restaurant>();
        for (Restaurant currRest : allRestaurants) {
            //check opening days
            if (currRest.isOpen(day)) {
                //check allergies
                    for (int j = 0; j < currRest.getMenu().getDishes().size(); j++) {
                        Dish currDish = currRest.getMenu().getDishes().get(j);
                        if (!currDish.getAllergens().containsAll(this.allergies)) {
                            availableRestaurants.add(currRest);
                            System.out.println("found a restaurant"+currRest.getName());
                        }
                    }
            }
        }
    }

    //no available restaurant exception ?
    public Restaurant randomRestaurant(){
        if(availableRestaurants.isEmpty()){
            System.out.println("is empty, no good");
            try {
                throw new NoAvailableRestaurantException("no restaurant available");
            } catch (NoAvailableRestaurantException e) {
                return new Restaurant("No restaurant available","please try another combination of attendees or day/time");
            }
        }

        System.out.println("Faith loading.. ");
        Random rndm = new Random();
        try {
            int rndmNumber = rndm.nextInt(0, availableRestaurants.size());
            System.out.println("random restaurant: "+availableRestaurants.get(rndmNumber).getName());
            return availableRestaurants.get(rndmNumber);
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return null;
    }

    @Override
    public String toString() {
        return "Lunch{" +
                ", personList=" + checkedPerson +
                ", preferences=" + preferences +
                ", allergies=" + allergies +
                ", today='" + day + '\'' +
                ", time='" + time + '\'' +
                ", allRestaurants=" + allRestaurants +
                ", availableRestaurants=" + availableRestaurants +
                '}';
    }
}
