package backend.ressources;

import java.util.List;

public class Restaurant {

    private String name;
    private String address;
    //range 1-3 cheap - expensive
    private int priceRange;
    //is list the best option? 2D array?
    private List<String> openingDays;
    private boolean hasTerrace;
    private Menu menu;

    public Restaurant(String name, String address,
                      int priceRange, List<String> openingDays, boolean hasTerrace, Menu menu
    ) {
        this.name = name;
        this.address = address;
        this.priceRange = priceRange;
        this.openingDays = openingDays;
        this.hasTerrace = hasTerrace;
        this.menu = menu;

    }
    public Restaurant(String name, String address
    ) {
        this.name = name;
        this.address = address;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(int priceRange) {
        this.priceRange = priceRange;
    }

    public List<String> getopeningDays() {
        return openingDays;
    }

    public void setopeningDays(List<String> openingDays) {
        this.openingDays = openingDays;
    }

    public boolean HasTerrace() {
        return hasTerrace;
    }

    public void setHasTerrace(boolean hasTerrace) {
        this.hasTerrace = hasTerrace;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public boolean isOpen(String today){

        if(openingDays.contains(today)) return true;

        return false;
    }
    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
