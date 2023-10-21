package backend.interfaces;

import java.util.Date;
import java.util.List;

public class Restaurant {

    private String name;
    private String address;
    private int priceRange;
    //is list the best option? 2D array?
    private List<String[]> openingHours;
    private boolean hasTerrace;
    private Menu menu;

    public Restaurant(String name, String address, int priceRange, List<String[]> openingHours, boolean hasTerrace, Menu menu) {
        this.name = name;
        this.address = address;
        this.priceRange = priceRange;
        this.openingHours = openingHours;
        this.hasTerrace = hasTerrace;
        this.menu = menu;
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

    public List<String[]> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(List<String[]> openingHours) {
        this.openingHours = openingHours;
    }

    public boolean isHasTerrace() {
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

    public boolean isOpen(Date today){
        //implement comparison today and openinghourse
        return true;
    }
}
