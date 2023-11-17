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
        /*for (Customer c: customers) {
            for(String s:c.getAllergies()){
                if(!allergies.contains(s)) allergies.add(s);
            }
            for(String s:c.getPreferences()){
                if(!preferences.contains(s)) preferences.add(s);
            }
        }
        for (Employee e: employees) {
            for(String s:e.getAllergies()){
                if(!allergies.contains(s)) allergies.add(s);
            }
            for(String s:e.getPreferences()){
                if(!preferences.contains(s)) preferences.add(s);
            }
        }*/



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
        /*RestaurantReader restaurantReader = new RestaurantReader();
        restaurantReader.update();
        allRestaurants = restaurantReader.getRestaurants();*/

        this.allRestaurants = new ArrayList<Restaurant>();

        List<String> openingDays1 = new ArrayList<>();
        openingDays1.add("Monday");
        List<String> allergens1 = new ArrayList<>();
        allergens1.add("A");
        Dish dish1 = new Dish(allergens1,"italian",true,true);
        List<Dish> dishes1= new ArrayList<Dish>();
        dishes1.add(dish1);
        Menu menu1 = new Menu(dishes1);
        Restaurant testRestaurant1 = new Restaurant("name1","adresse1",1,openingDays1,true,menu1);

        List<String> openingDays2 = new ArrayList<>();
        openingDays2.add("Tuesday");
        List<String> allergens2 = new ArrayList<>();
        allergens1.add("F");
        Dish dish2 = new Dish(allergens2,"asian",false,true);
        List<Dish> dishes2= new ArrayList<Dish>();
        dishes2.add(dish2);
        Menu menu2 = new Menu(dishes2);
        Restaurant testRestaurant2 = new Restaurant("name2","adresse2",3,openingDays2,true,menu2);


        allRestaurants.add(testRestaurant1);
        allRestaurants.add(testRestaurant2);

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
        Random rndm = new Random();
        int rndmNumber = rndm.nextInt(0, availableRestaurants.size());
        System.out.println("random restaurant: "+availableRestaurants.get(rndmNumber).getName());
        return availableRestaurants.get(rndmNumber);
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
