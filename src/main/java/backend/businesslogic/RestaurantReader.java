package backend.businesslogic;

import backend.ressources.Dish;
import backend.ressources.Restaurant;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantReader {
    /*testing the import
    public static void main(String[] args) {

        try {
            RestaurantReader restaurantReader = new RestaurantReader();
            restaurantReader.printData();
        } catch (IncorrectFileNameException e) {
            e.printStackTrace();
        }
    }
    */

    private List<Restaurant> restaurants;
    private final String fileName = "C:\\Users\\lorenz.moser\\Desktop\\Uni-Projekt\\restaurant-guru\\src\\main\\java\\backend\\ressources\\RestaurantList.json";


    public RestaurantReader() throws IncorrectFileNameException {
        restaurants = new ArrayList<>();
        update();

    }

    public void update() throws IncorrectFileNameException {
        //implement reading a doc with restaurant data

        try {


                Gson gson = new Gson();
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                Restaurant[] restaurantArray = gson.fromJson(reader, Restaurant[].class);
                restaurants = Arrays.asList(restaurantArray);
            }

         catch (FileNotFoundException e) {

                throw new IncorrectFileNameException("Incorrect filename : " + fileName );
        }


    }
    /* This is for testing the import
    public void printData() {


        for (Restaurant restaurant : restaurants) {
            System.out.println("Restaurant Name: " + restaurant.getName());
            System.out.println("Address: " + restaurant.getAddress());
            System.out.println("Price Range: " + restaurant.getPriceRange());
            System.out.println("Opening Days: " + restaurant.getopeningDays());
            System.out.println("Has Terrace: " + restaurant.HasTerrace());

            // Print dish information
            List<Dish> dishes = restaurant.getMenu().getDishes();
            for (Dish dish : dishes) {
                System.out.println("Allergens: " + dish.getAllergens());
                System.out.println("Cuisine: " + dish.getCuisine());
                System.out.println("Is Vegan: " + dish.isVegan());
                System.out.println("Is Veggy: " + dish.isVeggy());
                System.out.println("------");
            }

            System.out.println("=====================================");
        }
    }
  */
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
