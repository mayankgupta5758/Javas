package com.mayank.ims;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryHelper serviceHelper = new InventoryHelper();
        boolean run = true;
        while (run) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Press 1 for add Preishable Product.");
            System.out.println("Press 2 for add Non-Preishable Product.");
            System.out.println("Press 3 for remove Product.");
            System.out.println("Press 4 for Exit.");
            System.out.println("Press 5 for Show all product.");
            int n = Validation.getValidInt(scanner, "Enter 1, 2, 3, 4 or 5.");
            System.out.println("-------------------------------------------------------");

            switch (n) {
                case 1:
                    serviceHelper.addPerishableProductHelper();
                    break;

                case 2:
                    serviceHelper.addNonPreishableProductHelper();
                    break;

                case 3:
                    serviceHelper.removeProduct();
                    break;

                case 4:
                    System.out.println("-------------------------------------------------------");
                    run = false;
                    System.out.println("Exit...");
                    break;

                case 5:
                    service.showProd();
                    break;

                default:
                    System.out.println("Enter 1, 2, 3 or 4.");
                    break;
            }
        }
    }
}
