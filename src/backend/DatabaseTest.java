package backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseTest {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Step 1: Load the JDBC driver - Version 1
            //Class.forName("com.mysql.jdbc.Driver");

          // chatgpt: Substitute this with the one below  conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);

            // Step 2: Establish the connection to the database
           // String url = "jdbc:mysql://localhost:3306/mydatabase";
            //String user = "root";
            //String password = "password";
            //conn = DriverManager.getConnection(url, user, password);

            // Step 3: Create a statement
            Statement stmt = conn.createStatement();

            // Step 4: Execute a SQL statement
            String sql = "SELECT * FROM mytable";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 5: Process the results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id: " + id + ", name: " + name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Step 6: Close the connection
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
