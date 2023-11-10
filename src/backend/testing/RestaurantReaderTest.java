
package backend.testing;


import backend.ressources.Dish;
import backend.ressources.Menu;
import backend.ressources.Restaurant;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestaurantReaderTest {

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void getRestaurants() {
        //Setup auslagern
        // Restaurant vs Restaurant
        List<String> openingDays = new ArrayList<>();
        openingDays.add("Montag");
        openingDays.add("Dienstag");
        List<Dish> dishes = new ArrayList<>();
        List<String> allergens = new ArrayList<>();
        allergens.add("Keine");

        dishes.add(new Dish(allergens, "French", false, false));
        Menu m = new Menu(dishes);

        Restaurant restTest1 = new Restaurant("Mci", "Grazbachgasse 49", 1, openingDays , true, m);
        assertEquals("Mci", restTest1.getName());
        assertEquals("Grazbachgasse 49", restTest1.getAddress());
        assertEquals(1, restTest1.getPriceRange());

        List<String> vergleichOpeningDays = Arrays.asList("Montag", "Dienstag");
        Assertions.assertArrayEquals(vergleichOpeningDays.toArray(), restTest1.getopeningDays().toArray());

        assertEquals(true, restTest1.HasTerrace());
        List<Dish> vergleichDishes = Arrays.asList(new Dish(allergens, "French", false, false));

        Menu n = new Menu(vergleichDishes);
        Assertions.assertEquals(vergleichDishes, restTest1.getMenu());

    }
}