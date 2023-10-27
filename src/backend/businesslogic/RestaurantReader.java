package backend.businesslogic;

import backend.ressources.Restaurant;

import java.util.List;

public class RestaurantReader {

    //https://www.javatpoint.com/how-to-read-csv-file-in-java

    private List<Restaurant> restaurants;

    //evtl pfad zur datei als parameter angeben lassen?
    public RestaurantReader(){
        update();
    }

    public void update(){


        //implement reading a doc with restaurant data


    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
