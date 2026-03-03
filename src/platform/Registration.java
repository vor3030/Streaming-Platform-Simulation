
package platform;

import user.User;
import user.FreeUser;
import user.PremiumUser;
import billing.FreeSubscription;
import billing.PremiumSubscription;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Registration {

    private Platform platform;

    public Registration(Platform platform) {
        this.platform = platform;
    }

    public boolean register(String username, String password, String email, String subscriptionType) {
        if (subscriptionType.equalsIgnoreCase("free")) {
            FreeUser newUser = new FreeUser(username, password, email);
            FreeSubscription freeSubscription = new FreeSubscription(username);
            newUser.setSubscription(freeSubscription);
            platform.addUser(newUser);
            platform.addSubscription(freeSubscription);
            return true;
        } else if (subscriptionType.equalsIgnoreCase("premium")) {
            PremiumUser newUser = new PremiumUser(username, password, email);
            PremiumSubscription premiumSubscription = new PremiumSubscription(username, "monthly");
            newUser.setSubscription(premiumSubscription);
            platform.addUser(newUser);
            platform.addSubscription(premiumSubscription);
            return true;
        }
        return false;

    public boolean isUsernameTaken(String username) {
        return platform.getUsers().stream().anyMatch(user -> user.getUsername().equals(username));
    }

    public boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public boolean isValidPassword(String password) {
        return password.length() >= 6;
    }   

    public void displayRegistrationInfo(){
        System.out.println("Registration information displayed.");
    }

    public boolean registerNewUser(String username, String password, String email, String subscriptionType) {
        if (!isValidEmail(email) || !isValidPassword(password) || isUsernameTaken(username)) {
            return false;
        }
        return register(username, password, email, subscriptionType);
    }

    public void registerNewUser(){
        Scanner scan = new Scanner(System.in);
        InputAuthenticator inputAuth = new InputAuthenticator();
        User user = new User();

        System.out.println("Welcome to a Streaming Platform Simulation");

        while(true){
            try{
                System.out.println("Enter Email: ");
                String email = scan.nextLine();
                if(!inputAuth.isValidEmail(email)){
                    throw new InputMismatchException("Invalid email format! Try again.");
                }
                break;
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }

        while(true){
            try{
                System.out.println("Enter Password: ");
                String password = scan.nextLine();
                if(!inputAuth.isValidPassword(password)){
                    throw new InputMismatchException("Invalid password format! Try again.");
                }
                break;
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }
    }
}