package backend.businesslogic.database;

import backend.ressources.Customer;
import backend.ressources.Employee;
import backend.ressources.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserHandling {
    //https://www.infoworld.com/article/3388036/what-is-jdbc-introduction-to-java-database-connectivity.html
    private final String url = "jdbc:sqlite:./personDataBase";
    private List<Person> personList = new ArrayList<>();
    public UserHandling(){
        //createNewDatabase();
    }
    public void createNewDatabase(){
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("The driver name is " + meta.getDriverName());
            System.out.println("A new database has been created.");
            stmt.executeUpdate("drop table person");
            String createNewTable = "CREATE Table IF NOT EXISTS person"+
                    "(name VARCHAR(255), "+
                    "allergies VARCHAR(255), "+
                    "preferences VARCHAR(255), "+
                    "isVegan BOOLEAN, "+
                    "isVeggy BOOLEAN, "+
                    "isCustomer BOOLEAN, "+
                    "isPaying BOOEALN, "+
                    "PRIMARY KEY (name))";
            stmt.executeUpdate(createNewTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String createNewUser(String name, String allergies, String preferences, boolean isVegan, boolean isVeggy, boolean isCustomer, boolean isPaying){
        try (Connection conn = DriverManager.getConnection(url)){
            String sql = "INSERT INTO person (name,allergies,preferences,isVegan,isVeggy,isCustomer,isPaying) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, allergies);
            statement.setString(3, preferences);
            statement.setBoolean(4, isVegan);
            statement.setBoolean(5, isVeggy);
            statement.setBoolean(6, isCustomer);
            statement.setBoolean(7, isPaying);
            statement.executeUpdate();
            System.out.println("Record created.");
            return "SUCCESS";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "NOPE";
    }
    public void getAllUsers(){
        String sql ="SELECT * FROM person";
        try (Connection conn = DriverManager.getConnection(url)){
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String name = result.getString("name");
                String allergies = result.getString("allergies");
                String preferences = result.getString("preferences");
                boolean isVegan = result.getBoolean("isVegan");
                boolean isVeggy = result.getBoolean("isVeggy");
                boolean isCustomer = result.getBoolean("isCustomer");
                boolean isPaying = result.getBoolean("isPaying");

                List<String> allergieList = Arrays.asList(allergies.split("\\s*,\\s*"));
                List<String> preferenceList = Arrays.asList(preferences.split("\\s*,\\s*"));

                if(isCustomer){
                    Customer ctemp = new Customer(name,allergieList,preferenceList,isVegan,isVeggy,isPaying);
                    personList.add(ctemp);
                } else {
                    Employee etemp = new Employee(name,allergieList,preferenceList,isVegan,isVeggy);
                    personList.add(etemp);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Person> getPersonList() {
        this.getAllUsers();
        return personList;
    }

        /*public static void main(String[] args) {
        UserHandling uh = new UserHandling();
        ArrayList<String> allergies = new ArrayList<>();
        allergies.add("A");
        allergies.add("B");
        ArrayList<String> preferences = new ArrayList<>();
        preferences.add("italian");
        preferences.add("asian");
        Employee emp = new Employee("Employee12",allergies,preferences,true,false);
        String allergieString = emp.getAllergies().stream().map(Object::toString)
                .collect(joining(", "));
        System.out.println("allergiestring "+allergieString);
        String prefString = emp.getPreferences().stream().map(Object::toString)
                .collect(joining(", "));
        System.out.println("prefstring "+prefString);

        String resp = uh.createNewUser(emp.getName(),allergieString,prefString,emp.isVegan(),emp.isVeggy(),false,false);

        uh.getPersonList();
    }*/
}
