package backend.ressources;

import java.util.List;

/**
 * Customer class extends class Person and holds all needed attributes for a Customer in the System
 */
public class Customer extends Person {

    /**
     * isPaying is an exclusive attribute to Customer, neither Person nor Employee have this. It indicates whether or not a given Customer
     * would pay for lunch
     */
    private boolean isPaying;
    public Customer(String name, List<String> allergies, List<String> preferences, boolean isVegan, boolean isVeggy, boolean isPaying) {
        super(name, allergies, preferences, isVegan, isVeggy);
        this.isPaying = isPaying;
    }

    public boolean isPaying() {
        return isPaying;
    }

    @Override
    public String toString() {
        super.toString();
        return "Customer{" +
                "isPaying=" + isPaying +
                '}';
    }
}
