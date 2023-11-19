package backend.businesslogic.database;

import backend.businesslogic.DBException;
import backend.ressources.Customer;
import backend.ressources.Employee;
import backend.ressources.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * UserHandling class implements the necessary jdbc functionality to safe, get and delete Persons from the given database
 */
public class UserHandling {
    //https://www.infoworld.com/article/3388036/what-is-jdbc-introduction-to-java-database-connectivity.html
    private final String url = "jdbc:sqlite:./personDataBase";

    /**
     * Upon instantiaton a new database is created. this means that after stopping the application all data will be lost.
     * At this point in time it's implemented this way so no old test data is displayed. In a production environment a
     * different solution would be applied.
     */
    public UserHandling(){
        createNewDatabase();
    }

    /**
     * creates a new database with the given path and name from the url class variable and creates a new table
     * with all necessary fields to portray a person.
     * If a problem occurs, a new custom DBException will be thrown and handled
     */
    private void createNewDatabase() {
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
            try {
                throw new DBException("problem during creation of new database and table");
            } catch (DBException ex) {
                ex.printStackTrace();
            }
        }
    }


    /**
     * creates a new user aka person entry in the database
     * If a problem occurs, a new custom DBException will be thrown and handled
     * @param name
     * @param allergies
     * @param preferences
     * @param isVegan
     * @param isVeggy
     * @param isCustomer
     * @param isPaying
     * @return SUCCESS if no problems occured, NOPE if problems occured and the person wasn't created in the database
     */
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
            try {
                throw new DBException("problem during creation of new person");
            } catch (DBException ex) {
              ex.printStackTrace();
            }
        }
        return "NOPE";
    }

    /**
     * Called by the getPersonlist method. Selects all data from the person table
     * If a problem occurs, a new custom DBException will be thrown and handled
     * @return a list that contains all user data in the table person
     */
    private List<Person> getAllUsers(){
        List<Person> personList = new ArrayList<>();
        String sql ="SELECT * FROM person";
        try (Connection conn = DriverManager.getConnection(url)){
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                //writing the current result data in temp variables to create either a customer or employee later on
                String name = result.getString("name");
                String allergies = result.getString("allergies");
                String preferences = result.getString("preferences");
                boolean isVegan = result.getBoolean("isVegan");
                boolean isVeggy = result.getBoolean("isVeggy");
                boolean isCustomer = result.getBoolean("isCustomer");
                boolean isPaying = result.getBoolean("isPaying");

                /**
                 * Since allergy and preferencedata is stored as a long string in the database, the result string is
                 * split and stored in temp-lists
                 */
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
            try {
                throw new DBException("problem occured while getting personlist data frooom db");
            } catch (DBException ex) {
                ex.printStackTrace();
            }
        }
        return personList;
    }

    /**
     * Deletes a given User based off the primary-key(name) from the database
     * If a problem occurs, a new custom DBException will be thrown and handled
     * @param name
     * @return SUCCESS if no problems occured, NOPE if problems occured and the person wasn't created in the database
     */
    public String deleteUser(String name){
        String sql = "DELETE FROM person where name = ?";
        try (Connection conn = DriverManager.getConnection(url)){
            PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.executeUpdate();
                return "SUCCESS";
        } catch (SQLException e){
            try {
                throw new DBException("problem occured while deleting person from db");
            } catch (DBException ex) {
                ex.printStackTrace();
                return "NOPE";
            }
        }
    }

    public List<Person> getPersonList() {
        return this.getAllUsers();
    }

}
