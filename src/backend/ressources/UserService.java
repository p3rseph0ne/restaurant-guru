package backend.ressources;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String, User> userDatabase;

    public UserService() {
        this.userDatabase = new HashMap<>();
        initializeUsers();
    }

    private void initializeUsers() {
        // In a real application, user details would be fetched from a database
        // For simplicity, we are hardcoding user details here
        addUser(new User("admin", "MsRulen5Mal", UserRole.ADMINISTRATOR));
        addUser(new User("employee", "axtesys123", UserRole.EMPLOYEE));
    }

    public backend.ressources.User authenticateUser(String username, String password) {
        User user = userDatabase.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void addUser(User user) {
        userDatabase.put(user.getUsername(), user);
    }

    public User getUserByUsername(String username) {
        //add funktionalität zum Userfiltern hier
    }

    public void addUser(backend.ressources.User validUser) {
    }

    public enum UserRole {
        ADMINISTRATOR,
        EMPLOYEE
    }

    public static class User {
        private final String username;
        private final String password;
        private final UserRole role;

        public User(String username, String password, UserRole role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public UserRole getRole() {
            return role;
        }
    }
}