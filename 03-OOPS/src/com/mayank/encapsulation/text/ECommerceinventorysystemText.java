package com.mayank.encapsulation.text;

import java.util.Scanner;

import com.mayank.encapsulation.model.ECommerceinventorysystem;

public class ECommerceinventorysystemText {

	public static void main(String[] args) {

		ECommerceinventorysystem product = new ECommerceinventorysystem();
		Scanner scanner = new Scanner(System.in);

		boolean setOut = true;
		

		while (setOut) {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("Enter 1 for Add Product.");
			System.out.println("Enter 2 for see Product Details.");
			System.out.println("Enter 3 for To Update Price");
			System.out.println("Enter 4 for Change Stock");
			System.out.println("Enter 5 for Exit");
			int num = scanner.nextInt();
			switch (num) {
			case 1:
				scanner.nextLine(); // clear buffer first
				System.out.println("Enter the Product Name: ");
				product.setProductName(scanner.nextLine());
				System.out.println("Enter the Price: ");
				product.setPrice(scanner.nextDouble());
				System.out.println("Enter the quantity: ");
				product.setStockQuantity(scanner.nextInt());
				break;

			case 2:
				if (product.getPrice() != 0) {
					System.out.println("Name: " + product.getProductName());
					System.out.println("Price: " + product.getPrice());
					System.out.println("Stock: " + product.getStockQuantity());
				} else {
					System.out.println("Enter the product the first.");
				}
				break;

			case 3:
				if (product.getPrice() != 0) {
					System.out.println("To Update Price: ");
					System.out.println("------------ Updating Price (Admin) ------------");
					product.updatePrice(scanner.nextInt(), true);
					System.out.println("Updated Price: " + product.getPrice());
				} else {
					System.out.println("Enter the product the first.");
				}
				break;
				
			case 4:
				if (product.getPrice() != 0) {
					System.out.println("------------ Change Stock ------------");
					product.changeStock(scanner.nextInt());
					System.out.println("Stock after increase: " + product.getStockQuantity());
				} else {
					System.out.println("Enter the product the first.");
				}
				break;

			case 5:
				System.out.println("Exiting...");
				setOut = false;
				break;
			default:
				System.out.println("Enter 1,2,3,4,5");
			}
		}
		scanner.close();
	}
}
