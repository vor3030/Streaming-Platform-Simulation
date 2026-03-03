package platform;

import user.User;

public class Authentication {
    private Platform platform;
    private User currentUser;
    private boolean isLoggedIn;

    public Authentication(Platform platform) {
        this.platform = platform;
        this.currentUser = null;
        this.isLoggedIn = false;
    }

    public boolean login(String username, String password) {
        User user = platform.getUsers().stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
        if (user != null) {
            currentUser = user;
            isLoggedIn = true;
            return true;
        }
        return false;
    }

    public void logout() {
        currentUser = null;
        isLoggedIn = false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}