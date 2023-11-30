package backend.testing;

import backend.businesslogic.RestaurantReader;
import backend.ressources.Restaurant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantReaderTest {

    RestaurantReader restaurantReader;
    Restaurant firstRestaurant;

    @BeforeAll
    public void initalisation(){
        RestaurantReader restaurantReader = new RestaurantReader();
        Restaurant firstRestaurant = restaurantReader.getRestaurants().get(0);
    }

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

    @Test
    public void testRestaurantReaderAddress() {
        try {
            assertEquals("Griesplatz 7, 8020 Graz, Austria", firstRestaurant.getAddress());
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }

    @Test
    public void testRestaurantReaderName() {
        try {
            assertEquals("Trattoria del Gusto", firstRestaurant.getName());
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }

    @Test
    public void testRestaurantReaderPrizeRange() {
        try {
            assertEquals(2, firstRestaurant.getPriceRange());
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }

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