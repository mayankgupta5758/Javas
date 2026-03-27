package com.mayank.assignment1.test;

import java.util.*;
import com.mayank.assignment1.model.*;

public class MovieMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        List<Movie> list = new ArrayList<>();

        int n = 0;

        while (true) {
            try {
                System.out.print("Enter number of movies: ");
                n = sc.nextInt();

                if (n <= 0) {
                    System.out.println("Number must be greater than 0.");
                    continue;
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter integer only.");
                sc.next();
            }
        }

        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter Movie " + (i + 1));

            String title;
            int year;

            while (true) {
                System.out.print("Enter Movie Title: ");
                title = sc.nextLine();

                if (title.trim().isEmpty()) {
                    System.out.println("Title cannot be empty.");
                    continue;
                }

                break;
            }

            while (true) {
                try {
                    System.out.print("Enter Release Year: ");
                    year = sc.nextInt();

                    if (year <= 0) {
                        System.out.println("Year must be positive.");
                        continue;
                    }

                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid year. Enter integer only.");
                    sc.next();
                }
            }

            sc.nextLine(); 

            list.add(new Movie(title, year));
        }

        Collections.sort(list, new MovieComparator());

        System.out.println("\nSorted Movies:");

        for (Movie m : list) {
            System.out.println(m.year + " " + m.title);
        }

        sc.close();
	}

}
