package models;

/**
 * User model represents a single user with username and password.
 * It uses encapsulation with private fields and public getters.
 */
public class User {

    private final String username;
    private final String password;

    /**
     * Constructor to initialize user credentials.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter methods (Encapsulation)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
