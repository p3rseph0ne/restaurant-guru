package backend.businesslogic;

import backend.ressources.Customer;
import backend.ressources.Employee;
import backend.ressources.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

import static org.junit.jupiter.api.Assertions.*;

class LunchTestForReal {

    @Test
    void getAvailableRestaurants() {
    }

    @Test
    void defineAvailableRestaurants() {
    }

    @Test
    void randomRestaurant() throws IncorrectFileNameException {

        String tageswetter = "Sonnig";
        String tag = "Saturday";
        List<String> listOfPreferences = new ArrayList<>();
            listOfPreferences.add("Sushi");
            listOfPreferences.add("Pizza");
            listOfPreferences.add("Schnitzel");

        List<String> allergens = new ArrayList<>();
            allergens.add("Keine");
            allergens.add("Nuts");

        List<Employee> mitarbeiter = new ArrayList<Employee>();
            mitarbeiter.add(0, new Employee("Lorenz", allergens, listOfPreferences, false, false));

            //---------------------------

        List<Customer> kunde = new ArrayList<Customer>();
            kunde.add(new Customer("KundenName", allergens, listOfPreferences, false, false, false));

            Lunch testLunch = new Lunch(mitarbeiter, kunde, tag, tageswetter);

            Restaurant r1 = testLunch.randomRestaurant();
            Restaurant r2 = testLunch.randomRestaurant();

            assertNotEquals(r1.getName(), r2.getName());
    }
}