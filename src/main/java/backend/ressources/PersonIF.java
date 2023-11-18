package backend.ressources;

import java.util.List;

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
