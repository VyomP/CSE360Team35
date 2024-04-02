package HealthcareApplicationPrototypeModels;


public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        // Implement login logic here
        return this.username.equals(username) && this.password.equals(password);
    }

    public void logout() {
        // Implement logout logic here
    }

    public void resetPassword(String newPassword) {
        this.password = newPassword;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}