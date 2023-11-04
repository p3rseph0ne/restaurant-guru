package backend.ressources;

import java.util.List;

public class Customer extends Person {

    private boolean isPaying;
    public Customer(String id, String name, List<String> allergies, List<String> preferences, boolean isVegan, boolean isVeggy, boolean isPaying) {
        super(id, name, allergies, preferences, isVegan, isVeggy);
        this.isPaying = isPaying;
    }

}
