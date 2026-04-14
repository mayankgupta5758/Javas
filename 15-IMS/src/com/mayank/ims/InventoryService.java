package com.mayank.ims;

import java.time.LocalDate;
import java.util.*;

public class InventoryService {
    Map<Product, Queue<ForFIFO>> inventory = new HashMap<>();
    ReoderService reoderService = new ReoderService();
    ValuationStrategy strategy = new FIFOValuation();

    public void addProduct(Product product, int qty, double price) {
        boolean chk = false;
        for (Product p : inventory.keySet()) {
            if (p.productId() == product.productId()) {
                Queue<ForFIFO> q = inventory.get(p);
                q.add(new ForFIFO(qty, LocalDate.now(), price));
                chk = true;
            }
        }

        if (chk == false) {
            inventory.put(product, new LinkedList<>());
            Queue<ForFIFO> q = inventory.get(product);
            q.add(new ForFIFO(qty, LocalDate.now(), price));
        }

        System.out.println("Added quantity " + qty + " of product " + product.name);
    }

    public void showProd() {
        for (Product p : inventory.keySet()) {
            System.out.print(p.name + " -> ");
            Queue<ForFIFO> q = inventory.get(p);
            for (ForFIFO f : q) {
                System.out.print(f.quantity + " units of " + " price" + f.price + ", ");
            }
            System.out.println();
        }
    }

    public Product findProductByName(String name) {
        if (name.isEmpty() || name.length() == 0) {
            System.out.println("Enter name First.");
            return null;
        }

        for (Product p : inventory.keySet()) {
            if (p.name.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public void removeProduct(Product product, int qty3) {
        if (!inventory.containsKey(product)) {
            System.out.println("Product not exist!!!");
            return;
        }
        Queue<ForFIFO> q = inventory.get(product);
        if (q == null || q.isEmpty()) {
            System.out.println("Add Quantity First.");
            return;
        }
        int removeqty = qty3;
        double totalAmount = 0;
        while (removeqty > 0 && !q.isEmpty()) {
            ForFIFO f = q.peek();
            if (f.quantity <= removeqty) {
                totalAmount += f.price * f.quantity;
                removeqty -= f.quantity;
                q.poll();
            } else {
                totalAmount += f.price * removeqty;
                f.quantity -= removeqty;
                removeqty = 0;
            }
        }
        if (removeqty > 0) {
            System.out.println("Not enough stock!");
            return;
        }
        System.out.println("Removed " + qty3 + " of " + product.name);
        System.out.println("Total Amount = " + totalAmount);
            System.out.println("-------------------------------------------------------");
        checkReorder(product);
    }

    public int getTotalStock(Product product) {
        int total = 0;
        Queue<ForFIFO> q = inventory.get(product);
        if (q != null) {
            for (ForFIFO f : q) {
                total += f.quantity;
            }
        }
        return total;
    }

    private void checkReorder(Product product) {
        int total = getTotalStock(product);
        if (reoderService.chkThreshold(total)) {
            System.out.println("Low stock for " + product.name);
            reoderService.placeOrder(product);
            String message = "Low Stock alert for " + product.name;
            Notifier emailNotifier = new EmailNotifier();
            emailNotifier.send(message);
            Notifier smsNotifier = new SMSNotifier();
            smsNotifier.send(message);
            System.out.println("-------------------------------------------------------");
        }
    }
}

