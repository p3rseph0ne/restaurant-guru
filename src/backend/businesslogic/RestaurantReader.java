package backend.businesslogic;

import backend.ressources.Restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class RestaurantReader {

    //https://www.javatpoint.com/how-to-read-csv-file-in-java

    private List<Restaurant> restaurants;

    //evtl pfad zur datei als parameter angeben lassen?
    public RestaurantReader(String fileName) throws IncorrectFileNameException {
        update(fileName);
    }

    public void update(String fileName) throws IncorrectFileNameException {
        //implement reading a doc with restaurant data

        try (Scanner file = new Scanner(new File(fileName))) {
            if (file.hasNextLine()){
                //create new restaurant based on file-input
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
