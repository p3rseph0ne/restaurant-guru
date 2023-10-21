package backend.interfaces;

import java.util.List;

public class Person {
    private String name;
    private List<String> allergies;
    private List<String> preferences;
    private boolean isVegan;
    private boolean isVeggy;

    public Person(String name, List<String> allergies, List<String> preferences, boolean isVegan, boolean isVeggy) {
        this.name = name;
        this.allergies = allergies;
        this.preferences = preferences;
        this.isVegan = isVegan;
        this.isVeggy = isVeggy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean isVeggy() {
        return isVeggy;
    }

    public void setVeggy(boolean veggy) {
        isVeggy = veggy;
    }
}
