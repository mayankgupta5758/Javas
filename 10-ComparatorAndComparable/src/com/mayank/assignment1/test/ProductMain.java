package com.mayank.assignment1.test;

import java.util.*;
import com.mayank.assignment1.model.*;

public class ProductMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        int n = 0;

        while (true) {
            try {
                System.out.print("Enter number of products: ");
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

            System.out.println("\nEnter Product " + (i + 1));

            String category;
            String name;
            double price;

            while (true) {
                System.out.print("Enter Category: ");
                category = sc.nextLine();

                if (category.trim().isEmpty()) {
                    System.out.println("Category cannot be empty.");
                    continue;
                }
                break;
            }

            while (true) {
                System.out.print("Enter Product Name: ");
                name = sc.nextLine();

                if (name.trim().isEmpty()) {
                    System.out.println("Name cannot be empty.");
                    continue;
                }
                break;
            }

            while (true) {
                try {
                    System.out.print("Enter Price: ");
                    price = sc.nextDouble();

                    if (price < 0) {
                        System.out.println("Price cannot be negative.");
                        continue;
                    }

                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid price. Enter number only.");
                    sc.next();
                }
            }

            sc.nextLine(); 
            list.add(new Product(category, name, price));
        }

        Collections.sort(list, new ProductComparator());

        System.out.println("\nSorted Products:");

        for (Product p : list) {
            System.out.println(p.category + " " + p.price + " " + p.name);
        }

        sc.close();
	}

}
