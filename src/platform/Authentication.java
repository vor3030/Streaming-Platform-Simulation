package platform;

import user.User;

public class Authentication {
    private final Platform platform;

    public Authentication(Platform platform) {
        this.platform = platform;
    }

    public User authenticate(String username, String password) {
        if (username == null || password == null) {
            System.out.println("Username and password cannot be null.");
            return null;
        }

        User user = platform.findUserByUsername(username);

        if (user == null) {
            System.out.println("User not found.");
            return null;
        }

        if (user.getPassword() != null && user.getPassword().equals(password)) {
            System.out.println("Authentication successful! Welcome, " + username);
            platform.setCurrentUser(username);
            return user;
        } else {
            System.out.println("Invalid password.");
            return null;
        }
    }

    public void logout() {
        platform.setCurrentUser(null);
        System.out.println("You have been logged out.");
    }
}
