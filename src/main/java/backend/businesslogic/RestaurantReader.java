package backend.businesslogic;

import backend.ressources.Dish;
import backend.ressources.Menu;
import backend.ressources.Restaurant;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RestaurantReader {

    //https://www.javatpoint.com/how-to-read-csv-file-in-java
    private List<Restaurant> restaurants;
    private final String fileName = "/hier/liegt/dann/ein/File";


    public RestaurantReader() throws IncorrectFileNameException {
        update();

    }

    public void update() throws IncorrectFileNameException {
        //implement reading a doc with restaurant data

        try (Scanner file = new Scanner(new File(fileName))) {
            if (file.hasNextLine()){
                //create new restaurant based on file-input
                List<String> openingDays = new ArrayList<>();
                List<Dish> dishes = new ArrayList<>();
                Menu menu = new Menu(dishes);
                restaurants.add(new Restaurant(file.nextLine(), file.nextLine(), file.nextInt(), openingDays, file.nextBoolean(), menu));
            }

        } catch (FileNotFoundException e) {

                throw new IncorrectFileNameException("Incorrect filename : " + fileName );

            //...
        }


    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
