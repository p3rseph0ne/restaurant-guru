package backend.businesslogic;


import backend.logging.Logging;
import backend.ressources.Restaurant;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * RestaurantReader reads the restaurant data from a given json-file, this is considered a POC to showcase different
 * ways to read data. In a real scenarion the restaurant data would also be mantained via a user interface and stored
 * in a database.
 */
public class RestaurantReader {

    private List<Restaurant> restaurants;
    //filename and path for further usage
    private final String fileName = "src/main/java/backend/ressources/RestaurantList.json";

    static Logger logger = Logger.getLogger(Logging.class.getName());


    /**
     * upon initialization the restaurant list is initialized and the method update is called to read
     * the available restaurant data
     * @throws IncorrectFileNameException
     */
    public RestaurantReader(){
        restaurants = new ArrayList<>();
        update();
    }

    /**
     * Read the restaurant data from the given json file. File contains name, adress, menu and dish data for the restaurant
     * @throws IncorrectFileNameException
     */
    private void update(){

        //implement reading json file with restaurant data
        try {
            Gson gson = new Gson();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            Restaurant[] restaurantArray = gson.fromJson(reader, Restaurant[].class);
            restaurants = Arrays.asList(restaurantArray);
            logger.log(Level.INFO, "Restaurants einlesen erfolgreich");
            } catch (FileNotFoundException e) {
                logger.log(Level.SEVERE, e.toString());
            try {
                throw new IncorrectFileNameException("Incorrect filename : " + fileName );
            } catch (IncorrectFileNameException ex) {
                ex.printStackTrace();
            }
        }

    }

    /**
     * returns the list of restaurants that have been read prior when update method was called
     * @return
     */
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
