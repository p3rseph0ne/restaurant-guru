package backend.businesslogic;

import backend.logging.Logging;
import backend.ressources.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Lunch represents one Lunch-outing and therefor contains all attendees and available restaurants
 * A Lunch Object is used in the REST-API when the User wants to create a new lunch outing/asks for a random restaurant
 * suggestion that caters to the dietary needs of all attendees
 */
public class Lunch {

    private List<Person> checkedPerson;
    private List<String> preferences;
    private List<String> allergies;
    private Weekday day;
    private String time;
    private List<Restaurant> allRestaurants;
    private List<Restaurant> availableRestaurants;

    static Logger logger = Logger.getLogger(Logging.class.getName());

    /**
     * Creates a new Lunch with the given arguments & calls the methods necessary for set-up
     * @param checkedPerson
     * @param day
     * @param time
     */
    public Lunch(List<Person> checkedPerson, Weekday day, String time){
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

    /**
     * Iterates over every person that attends the lunch to determine their allergies and preferences and stores
     * them in a temp-list
     */
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

            logger.log(Level.INFO, "Allergien und Präferenzen der Person wurden angelegt: ", p.toString());
        }

    }

    /**
     * creates a RestaurantReader instance that reads the restaurant data stored in a separate file and
     * stores them in a temp-list
     */
    public void readRestaurants() {
        allRestaurants = new ArrayList<Restaurant>();
        RestaurantReader restaurantReader = new RestaurantReader();
        allRestaurants = restaurantReader.getRestaurants();
        logger.log(Level.INFO, "Es wurde eine Übersicht über alle Restaurants zurückgegeben");
    }

    /**
     * Defines which of the restaurants in allRestaurants are actually available/suitable for the planned lunch
     * outing by iterating over all restaurants, checking if the current restaurant of the iteration is open
     * on the day of the outing and if it has any dishes in the menu that are safe for everyone to eat, depending
     * on the allergies of the attendees. A fitting restaurant will be stored in availableRestaurants.
     */
    public void defineAvailableRestaurants(){
        System.out.println("finding available restaurant");
        availableRestaurants = new ArrayList<Restaurant>();
        for (Restaurant currRest : allRestaurants) {
            //check opening days
            if (currRest.isOpen(String.valueOf(day))) {
                //check allergies
                    for (int j = 0; j < currRest.getMenu().getDishes().size(); j++) {
                        Dish currDish = currRest.getMenu().getDishes().get(j);
                        if (!currDish.getAllergens().containsAll(this.allergies)) {
                            availableRestaurants.add(currRest);
                            System.out.println("found a restaurant"+currRest.getName());
                            logger.log(Level.INFO, "Dieses Restaurant ist verfügbar: "+currRest.getName());
                        }
                    }
            }
        }
    }

    /**
     * Generates a random number between 0 and the number of restaurants that are available for that outing and then
     * returns the restaurant thats in that place of the list of available restaurants
     * If not restaurants are available, a NoAvailableRestaurantException will be thrown and a new Restaurant Object
     * with the information that no restaurant is available will be returned to the frontend for the user to see
     * @return
     */
    public Restaurant randomRestaurant(){
        if(availableRestaurants.isEmpty()){
            System.out.println("is empty, no good");
            logger.log(Level.WARNING, "Es wurde kein verfügbares Restaurant gefunden, die Liste muss erweitert werden");
            try {
                throw new NoAvailableRestaurantException("no restaurant available");
            } catch (NoAvailableRestaurantException e) {
                return new Restaurant("No restaurant available","please try another combination of attendees or day/time");
            }
        }
        Random rndm = new Random();
        try {
            int rndmNumber = rndm.nextInt(availableRestaurants.size());
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
