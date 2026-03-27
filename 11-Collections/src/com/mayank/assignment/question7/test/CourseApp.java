package com.mayank.assignment.question7.test;

import java.util.Scanner;

import com.mayank.assignment.question3.model.InputValidator;
import com.mayank.assignment.question7.model.*;

public class CourseApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseManager cm = new CourseManager();
        boolean run = true;

        while (run) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 Add Regular");
            System.out.println("2 Add Corporate");
            System.out.println("3 Display All");
            System.out.println("4 Display by Track");
            System.out.println("5 Sort by ID");
            System.out.println("6 Sort by Name");
            System.out.println("7 Add to Waiting");
            System.out.println("8 Enroll");
            System.out.println("9 Remove");
            System.out.println("10 Exit");

            int ch = InputValidator.getValidInt(sc, "Enter choice: ");
            try {
                switch (ch) {
                case 1:
                    int id = InputValidator.getValidInt(sc, "ID: ");
                    String name = InputValidator.getValidString(sc, "Name: ");
                    String track = InputValidator.getValidString(sc, "Track: ");
                    String mode = InputValidator.getValidString(sc, "Mode: ");
                    cm.register(new RegularParticipant(id, name, track, mode));
                    break;

                case 2:
                    id = InputValidator.getValidInt(sc, "ID: ");
                    name = InputValidator.getValidString(sc, "Name: ");
                    track = InputValidator.getValidString(sc, "Track: ");
                    String comp = InputValidator.getValidString(sc, "Company: ");
                    cm.register(new CorporateParticipant(id, name, track, comp));
                    break;

                case 3:
                    cm.displayAll();
                    break;

                case 4:
                    track = InputValidator.getValidString(sc, "Track: ");
                    cm.displayByTrack(track);
                    break;

                case 5:
                    cm.sortById();
                    break;

                case 6:
                    cm.sortByName();
                    break;

                case 7:
                    id = InputValidator.getValidInt(sc, "ID: ");
                    cm.addToWaiting(id);
                    break;

                case 8:
                    cm.enroll();
                    break;

                case 9:
                    id = InputValidator.getValidInt(sc, "ID: ");
                    cm.remove(id);
                    break;

                case 10:
                    run = false;
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}