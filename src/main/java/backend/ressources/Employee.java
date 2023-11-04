package backend.ressources;

import java.util.List;

public class Employee extends Person {

    public Employee(String id, String name, List<String> allergies, List<String> preferences, boolean isVegan, boolean isVeggy) {
        super(id, name, allergies, preferences, isVegan, isVeggy);
    }
}
