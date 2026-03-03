package user;

import admin.WatchHistory;

public class User implements UserInterface{
    private String username;
    private String email;
    private String password;
    private String subscriptionType;
    private WatchHistory watchHistory;

    public User() {
        // Default no-arg constructor
        this.subscriptionType = "free";
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.subscriptionType = "free"; // default
    }

    @Override
    public void setUsername(String username){
        this.username = username;
    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String getEmail(){
        return email;
    }

    @Override
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public void setSubscriptionType(String subscriptionType){
        this.subscriptionType = subscriptionType;
    }

    @Override
    public String getSubscriptionType(){
        return subscriptionType;
    }

    @Override
    public void setWatchHistory(WatchHistory watchHistory){
        this.watchHistory = watchHistory;
    }

    @Override
    public WatchHistory getWatchHistory(){
        return watchHistory;
    }

    @Override
    public String getAccessLevel(){
        return "User Access: Basic access to the platform.";
    }

    @Override
    public String toString(){
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", subscriptionType='" + subscriptionType + '\'' +
                ", watchHistory='" + watchHistory + '\'' +
                '}';
    }
}