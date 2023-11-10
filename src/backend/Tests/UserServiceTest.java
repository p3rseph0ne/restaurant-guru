package backend.Tests;

import backend.ressources.User;
import backend.ressources.UserService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void testAuthenticateUser() {
        UserService userService = new UserService();

        // Test valid authentication
        User validUser = new User("admin", "MsRulen5Mal", UserService.UserRole.ADMINISTRATOR);
        userService.addUser(validUser);

        User authenticatedUser = userService.authenticateUser("admin", "MsRulen5Mal");
        assertNotNull(authenticatedUser);
        assertEquals("admin", authenticatedUser.getUsername());
        assertEquals(UserService.UserRole.ADMINISTRATOR, authenticatedUser.getRole());

        // Test invalid authentication
        User invalidUser = userService.authenticateUser("nonexistent", "wrongpassword");
        assertNull(invalidUser);
    }

    @Test
    void testGetUserByUsername() {
        UserService userService = new UserService();

        // Test getting a user by username
        User user = new User("employee", "axtesys123", UserService.UserRole.EMPLOYEE);
        userService.addUser(user);

        User retrievedUser = userService.getUserByUsername("employee");
        assertNotNull(retrievedUser);
        assertEquals("employee", retrievedUser.getUsername());
        assertEquals(UserService.UserRole.EMPLOYEE, retrievedUser.getRole());

        // Test getting a non-existent user
        User nonExistentUser = userService.getUserByUsername("nonexistent");
        assertNull(nonExistentUser);
    }
}
