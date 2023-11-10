package backend.businesslogic.database;

import backend.ressources.Person;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserHandling {
    //https://www.infoworld.com/article/3388036/what-is-jdbc-introduction-to-java-database-connectivity.html
    private final String url = "jdbc:sqlite:./personDataBase";
    public UserHandling(){
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

    public String createNewUser(){

    }
    public List<Person> getAllUsers(){
        return new ArrayList<Person>();
    }

    public static void main(String[] args) {
        createNewDatabase("personDatabase.db");
    }
}
