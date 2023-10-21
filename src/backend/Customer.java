package backend;

import backend.interfaces.Person;

import java.util.List;

public class Customer extends Person {
    public Customer(String name, List<String> allergies, List<String> preferences, boolean isVegan, boolean isVeggy) {
        super(name, allergies, preferences, isVegan, isVeggy);
    }

}
