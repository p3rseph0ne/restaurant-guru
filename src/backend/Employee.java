package backend;

import backend.interfaces.Person;

import java.util.List;

public class Employee extends Person {

    public Employee(String name, List<String> allergies, List<String> preferences, boolean isVegan, boolean isVeggy) {
        super(name, allergies, preferences, isVegan, isVeggy);
    }
}
