package backend;

import backend.interfaces.Person;

import java.util.List;

public class Customer extends Person {

    private boolean isPaying;
    public Customer(String name, List<String> allergies, List<String> preferences, boolean isVegan, boolean isVeggy, boolean isPaying) {
        super(name, allergies, preferences, isVegan, isVeggy);
        this.isPaying = isPaying;
    }

}
