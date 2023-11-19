package backend.ressources;

import java.util.List;

/**
 * Employee class extends Person, has no special attributes itself
 */
public class Employee extends Person {
    public Employee(String name, List<String> allergies, List<String> preferences, boolean isVegan, boolean isVeggy) {
        super(name, allergies, preferences, isVegan, isVeggy);
    }
}
