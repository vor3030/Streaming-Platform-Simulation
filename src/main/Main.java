package main;
import platform.*;
import user.*;
import billing.*;
import admin.*;

public class Main {
    public static void main(String[] args) {
        Registration registration = new Registration();
        registration.registerNewUser();
    }
}
