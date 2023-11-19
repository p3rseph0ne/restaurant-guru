package backend.businesslogic;

import backend.ressources.Restaurant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RestaurantReaderTest {

    @Test
    public void testRestaurantReader() {
        try {
            RestaurantReader restaurantReader = new RestaurantReader();
            //restaurantReader.update();
            assertNotNull(restaurantReader.getRestaurants());
            assertEquals(25, restaurantReader.getRestaurants().size()); // Assuming 25 restaurants are loaded

            // Add more specific assertions based on your expectations for the data
            Restaurant firstRestaurant = restaurantReader.getRestaurants().get(0);
            assertEquals("Trattoria del Gusto", firstRestaurant.getName());
            assertEquals("Griesplatz 7, 8020 Graz, Austria", firstRestaurant.getAddress());
            // Add more assertions for other properties


        } catch (IncorrectFileNameException e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }
}