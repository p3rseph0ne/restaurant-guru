package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTestChatGPT {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);

            // Create the table if it does not exist
            String createTableSql = "CREATE TABLE IF NOT EXISTS mytable (id INTEGER, name TEXT)";
            statement.executeUpdate(createTableSql);

            // Insert some sample data if needed
            String insertDataSql = "INSERT INTO mytable (id, name) VALUES (1, 'John'), (2, 'Doe')";
            statement.executeUpdate(insertDataSql);

            // Query the data
            String selectDataSql = "SELECT * FROM mytable";
            ResultSet rs = statement.executeQuery(selectDataSql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id: " + id + ", name: " + name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
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