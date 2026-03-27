package com.mayank.assignment.question5.test;

import java.util.Scanner;
import com.mayank.assignment.question3.model.InputValidator;
import com.mayank.assignment.question5.model.*;

public class TransportApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TransportManager tm = new TransportManager();
        boolean run = true;

        while (run) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 Add Daily Passenger");
            System.out.println("2 Add Tourist Passenger");
            System.out.println("3 Display All");
            System.out.println("4 Display by Route");
            System.out.println("5 Sort by Name");
            System.out.println("6 Sort by Route");
            System.out.println("7 Add to Waiting");
            System.out.println("8 Process Boarding");
            System.out.println("9 Remove Passenger");
            System.out.println("10 Exit");
            System.out.println("11 Show Waiting");
            System.out.println("12 Show Boarded");

            int ch = InputValidator.getValidInt(sc, "Enter choice: ");
            try {
                switch (ch) {
                case 1:
                    int id = InputValidator.getValidInt(sc, "ID: ");
                    String name = InputValidator.getValidString(sc, "Name: ");
                    int route = InputValidator.getValidInt(sc, "Route: ");
                    String pass = InputValidator.getValidString(sc, "Pass Type: ");
                    tm.registerPassenger(new DailyPassenger(id, name, route, pass));
                    break;

                case 2:
                    id = InputValidator.getValidInt(sc, "ID: ");
                    name = InputValidator.getValidString(sc, "Name: ");
                    route = InputValidator.getValidInt(sc, "Route: ");
                    String hotel = InputValidator.getValidString(sc, "Hotel: ");
                    tm.registerPassenger(new TouristPassenger(id, name, route, hotel));
                    break;

                case 3:
                    tm.displayAll();
                    break;

                case 4:
                    route = InputValidator.getValidInt(sc, "Route: ");
                    tm.displayByRoute(route);
                    break;

                case 5:
                    tm.sortByName();
                    break;

                case 6:
                    tm.sortByRoute();
                    break;

                case 7:
                    id = InputValidator.getValidInt(sc, "Passenger ID: ");
                    tm.addToWaiting(id);
                    break;

                case 8:
                    tm.processBoarding();
                    break;

                case 9:
                    id = InputValidator.getValidInt(sc, "Remove ID: ");
                    tm.removePassenger(id);
                    break;

                case 10:
                    run = false;
                    break;
                    
                case 11:
                    tm.showWaitingPassengers();
                    break;

                case 12:
                    tm.showBoardedPassengers();
                    break;
                }
                
                

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}