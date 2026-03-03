package platform;

import user.*;
import java.util.*;

public class Registration {
    public void registerNewUser(){
        Scanner scan = new Scanner(System.in);
        InputAuthenticator inputAuth = new InputAuthenticator();
        User user = new User();

        System.out.println("Welcome to a Streaming Platform Simulation");

        while(true){
            try{
                System.out.print("Enter Email: ");
                String email = scan.nextLine();
                if(!inputAuth.isValidEmail(email)){
                    throw new InputMismatchException("Invalid email format! Try again.");
                }
                user.setEmail(email);
                break;
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }

        while(true){
            try{
                System.out.print("Enter Password: ");
                String password = scan.nextLine();
                if(!inputAuth.isValidPassword(password)){
                    throw new InputMismatchException("Invalid password format! Try again.");
                }
                user.setPassword(password);
                break;
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }

        int subscriptionType = 0;
        while(true){
            try{
                System.out.println("1. Free");
                System.out.println("2. Premium");
                System.out.println("Choose a subscription type: ");
                subscriptionType = scan.nextInt();
                if(subscriptionType == 1){
                    user.setSubscriptionType("free");
                    break;
                }else if(subscriptionType == 2){
                    user.setSubscriptionType("premium");
                    break;
                }else{
                    throw new InputMismatchException("Invalid subscription type! Try again.");
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid subscription type! Try again.");
                scan.nextLine();
            }
        }
    }
}