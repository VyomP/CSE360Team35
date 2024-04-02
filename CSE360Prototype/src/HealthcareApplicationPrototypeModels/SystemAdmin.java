package HealthcareApplicationPrototypeModels;

public class SystemAdmin extends User {
    public SystemAdmin(String username, String password) {
        super(username, password);
    }

    public void createUserAccount(User user) {
        // Implement logic to create a user account
    }

    public void assignRoles(User user, String role) {
        // Implement logic to assign roles to a user
    }
}
