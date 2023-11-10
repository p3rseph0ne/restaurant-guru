import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String username;
    private String passwordHash; // Hashed password
    private String role;

    // Constructors, getters, setters

    public String getPasswordHash() {
        return passwordHash;
    }

    // Method to check if the entered password matches the stored hash
    public boolean checkPassword(String password) {
        return hashPassword(password).equals(passwordHash);
    }

    // Method to hash a password
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest).toLoLoginServlet werCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // Handle the exception based on your application's requirements
            return null;
        }
    }
}
