package backend.testing;

import backend.businesslogic.RestaurantReader;
import backend.ressources.Restaurant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantReaderTest {

    RestaurantReader restaurantReader;
    Restaurant firstRestaurant;

    /**
     *  Prepare the variables for the further use
     */
    @BeforeAll
    public static void initalisation(){
        RestaurantReader restaurantReader = new RestaurantReader();
        Restaurant firstRestaurant = restaurantReader.getRestaurants().get(0);
    }

    /**
     *  Check if the expected Amount of Restaurants is the same as the real Amount of Restaurants
     *  If an error occurs, print the stack trace
     */
    @Test
    public void testRestaurantReaderSize() {
        try {
            assertNotNull(restaurantReader.getRestaurants());
            assertEquals(25, restaurantReader.getRestaurants().size()); // Assuming 25 restaurants are loaded

        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }

    /**
     *  Check if the expected Address is the same as the real Address
     *  If an error occurs, print the stack trace
     */
    @Test
    public void testRestaurantReaderAddress() {
        try {
            assertEquals("Griesplatz 7, 8020 Graz, Austria", firstRestaurant.getAddress());
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }
    /**
     *  Check if the expected Restaurant Name is the same as the real Restaurant Name
     *  If an error occurs, print the stack trace
     */
    @Test
    public void testRestaurantReaderName() {
        try {
            assertEquals("Trattoria del Gusto", firstRestaurant.getName());
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }

    /**
     *  Check if the expected PriceRange is the same as the real PriceRange
     *  If an error occurs, print the stack trace
     */
    @Test
    public void testRestaurantReaderPrizeRange() {
        try {
            assertEquals(2, firstRestaurant.getPriceRange());
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }

    /**
     *  Check if the expected OpeningDays is the same as the real OpeningDays
     *  If an error occurs, print the stack trace
     */
    @Test
    public void testRestaurantReaderOpeningDays() {
        try {
            List<String> openingDays = firstRestaurant.getopeningDays();
            assertNotNull(openingDays);
            assertArrayEquals(Arrays.asList("Monday", "Wednesday", "Friday").toArray(), openingDays.toArray());
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }



}