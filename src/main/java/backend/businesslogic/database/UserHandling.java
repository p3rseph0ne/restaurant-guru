package backend.businesslogic.database;

import backend.ressources.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserHandling {
    //https://www.infoworld.com/article/3388036/what-is-jdbc-introduction-to-java-database-connectivity.html
    private final String url = "jdbc:sqlite:./personDataBase";
    public UserHandling(){
        createNewDatabase();
    }
    public void createNewDatabase(){
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                /*String createNewTable = "CREATE Table IF NOT EXISTS person"+
                        "(name VARCHAR(255), "+
                        "allergies VARCHAR(255), "+
                        "preference VARCHAR(255), "+
                        "isVegan BOOLEAN, "+
                        "isVeggy BOOLEAN, "+
                        "isCustomer BOOLEAN, "+
                        "isPayign BOOEALN, "+
                        "PRIMARY KEY (name))";*/
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String createNewUser(){
        return "";
    }
    public List<Person> getAllUsers(){
        return new ArrayList<Person>();
    }


    public static void main(String[] args) {
        UserHandling uh = new UserHandling();
        /*List<Person> personList = new ArrayList<>();
        ArrayList<String> allergies = new ArrayList<>();
        allergies.add("A");
        allergies.add("B");
        ArrayList<String> preferences = new ArrayList<>();
        preferences.add("italian");
        Employee testEmployee = new Employee("Employee",allergies,preferences,true,false);
        Customer testCustomer = new Customer("Customer",allergies,preferences,false,false,true);

        personList.add(testEmployee);
        personList.add(testCustomer);

        StringJoiner joiner = new StringJoiner(", ");
        for (Person person : personList) {
            String string = "("+person.toString()+")";
            joiner.add(string);
        }
        String stringlist = joiner.toString();

        System.out.println("st: "+stringlist);*/



        System.out.println("AYO");
    }

}
