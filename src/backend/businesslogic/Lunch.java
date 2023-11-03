package backend.businesslogic;

import backend.ressources.Customer;
import backend.ressources.Dish;
import backend.ressources.Employee;
import backend.ressources.Restaurant;
import backend.businesslogic.RestaurantReader;
import java.util.Random;
import java.util.List;

public class Lunch {

    private List<Employee> emps;
    private List<Customer> customs;
    private List<String> preferences;
    private List<String> allergies;
    private String today;
    private String weather;
    private List<Restaurant> allRestaurants;
    private List<Restaurant> availableRestaurants;

    public Lunch(List<Employee> emps, List<Customer> customs, String today, String weather) throws IncorrectFileNameException {
        this.emps = emps;
        this.customs = customs;
        this.today = today;
        this.weather = weather;

        readRestaurants();
        readAllergiesAndPreferences();
        defineAvailableRestaurants();
    }

    public List<Restaurant> getAvailableRestaurants() {
        return availableRestaurants;
    }

    private void readAllergiesAndPreferences(){
        try {
            for (Customer c : customs) {
                for (String s : c.getAllergies()) {
                    if (!allergies.contains(s)) allergies.add(s);
                }
                for (String s : c.getPreferences()) {
                    if (!preferences.contains(s)) preferences.add(s);
                }
            }
            for (Employee e : emps) {
                for (String s : e.getAllergies()) {
                    if (!allergies.contains(s)) allergies.add(s);
                }
                for (String s : e.getPreferences()) {
                    if (!preferences.contains(s)) preferences.add(s);
                }
            }
        }
        catch (Exception erorrHandlingException){
            erorrHandlingException.printStackTrace();
            System.out.println("Hui hier kam ein Fehler! :/");
        }
        finally {
            System.out.println("Wir machen jedoch weiter! :D");
        }
    }

    private void readRestaurants() throws IncorrectFileNameException {
        RestaurantReader rr = new RestaurantReader("RestaurantListe.docx");
        rr.update("RestaurantListe");
        allRestaurants = rr.getRestaurants();
    }
    public void defineAvailableRestaurants(){
        //
        for (Restaurant currRest : allRestaurants) {
            //check opening days
            if (currRest.isOpen(today)) {
                //check allergies
                for (int j = 0; j < currRest.getMenu().getDishes().size(); j++) {
                    Dish currDish = currRest.getMenu().getDishes().get(j);
                    if (!currDish.getAllergens().containsAll(this.allergies)) {
                        availableRestaurants.add(currRest);
                    }
                }

            }
        }
    }

    public Restaurant randomRestaurant(){

        int randomlySelectedRestaurantNumber = 0;
        Random random1 = new Random();
        Restaurant randomlySelectedRestaurant;

        randomlySelectedRestaurantNumber = random1.nextInt(availableRestaurants.size());

        //implement random number generator with max value == amount of available restaurants
        //that returns a Restaurant from the list availableRestaurants at that point in the list
         randomlySelectedRestaurant = availableRestaurants.get(randomlySelectedRestaurantNumber);
        return randomlySelectedRestaurant;
    }
}
