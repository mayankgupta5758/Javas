package com.mayank.ims;

import java.time.LocalDate;

public class InventoryHelper {
    InventoryService service = new InventoryService();

    public void addPerishableProductHelper() {
        System.out.println("-------------------------------------------------------");
        int id = Validation.getValidInt(scanner, "Enter Id: ");
        String name = Validation.getValidString(scanner, "Enter product name: ");
        int qty = Validation.getValidInt(scanner, "Enter qty: ");
        double price = Validation.getValidDouble(scanner, "Enter product price: ");
        Product product = new PreishableProduct(id, name.toLowerCase(), LocalDate.now().plusDays(2));
        service.addProduct(product, qty, price);
        service.showProd();
    }

    public void addNonPreishableProductHelper() {
        System.out.println("-------------------------------------------------------");
        int id2 = Validation.getValidInt(scanner, "Enter Id: ");
        String name2 = Validation.getValidString(scanner, "Enter product name: ");
        String brand = Validation.getValidString(scanner, "Enter Brand Name: ");
        double price2 = Validation.getValidDouble(scanner, "Enter product price: ");
        Product product2 = new NonPreishableProduct(id2, name2.toLowerCase(), brand);
        int qty2 = Validation.getValidInt(scanner, "Enter quantity: ");
        service.addProduct(product2, qty2, price2);
        service.showProd();
    }

    public void removeProduct() {
        System.out.println("-------------------------------------------------------");
        String name3 = Validation.getValidString(scanner, "Enter Product name: ");
        int qty3 = Validation.getValidInt(scanner, "Enter qty to remove: ");
        name3 = name3.toLowerCase();
        Product product3 = service.findProductByName(name3);
        if (product3 == null) {
            System.out.println("Product not found.");
            break;
        }
        service.removeProduct(product3, qty3);
    }
}
