package backend.ressources;

import java.util.List;

/**
 * Interface that describes what methods have to be implemented for a Person-class
 */
public interface PersonIF {
    void sayHello();
    String getName();
    void setName(String name);
    List<String> getAllergies();
    void setAllergies(List<String> allergies);
    List<String> getPreferences();
    void setPreferences(List<String> preferences);
    boolean isVegan();
    void setVegan(boolean vegan);
    boolean isVeggy();
    void setVeggy(boolean veggy);
    @Override
    public String toString();

}
