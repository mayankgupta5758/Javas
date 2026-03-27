package com.mayank.assignment.question6.model;

import java.util.*;
import com.mayank.assignment.question6.model.*;
import com.mayank.assignment.question6.exception.*;

public class InventoryManager {

    private Set<Product> products = new HashSet<>();
    private Map<String, List<Product>> categoryMap = new HashMap<>();
    private Queue<Integer> returnQueue = new LinkedList<>();

    private Product find(int id) throws ProductNotFoundException {
        for (Product p : products) {
            if (p.getProductId() == id)
                return p;
        }
        throw new ProductNotFoundException("Product not found");
    }

    public void addProduct(Product p) {
        if (products.add(p)) {
            if (!categoryMap.containsKey(p.getCategory())) {
                categoryMap.put(p.getCategory(), new ArrayList<>());
            }
            categoryMap.get(p.getCategory()).add(p);
            System.out.println("Product added");
        } else {
            System.out.println("Duplicate product not allowed");
        }
    }

    public void displayAll() throws EmptyInventoryException {
        if (products.isEmpty())
            throw new EmptyInventoryException("Inventory empty");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void displayByCategory(String cat) throws EmptyInventoryException {
        if (!categoryMap.containsKey(cat))
            throw new EmptyInventoryException("No products in this category");
        for (Product p : categoryMap.get(cat)) {
            System.out.println(p);
        }
    }

    public void sortById() {
        List<Product> list = new ArrayList<>(products);
        Collections.sort(list);
        for (Product p : list) {
            System.out.println(p);
        }
    }

    public void sortByPrice() {
        List<Product> list = new ArrayList<>(products);
        Collections.sort(list, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return (int)(p1.getPrice() - p2.getPrice());
            }
        });
        for (Product p : list) {
            System.out.println(p);
        }
    }

    public void requestReturn(int id) throws ProductNotFoundException {
        Product p = find(id);
        if (p.getStatus() == ProductStatus.ACTIVE) {
            returnQueue.offer(id);
            p.setStatus(ProductStatus.RETURN_REQUESTED);
            System.out.println("Return requested");
        } else {
            System.out.println("Already processed");
        }
    }

    public void processReturn() throws ProductNotFoundException {
        if (returnQueue.isEmpty()) {
            System.out.println("No return requests");
            return;
        }
        int id = returnQueue.poll();
        Product p = find(id);
        p.setStatus(ProductStatus.RETURNED);
        System.out.println("Product returned: " + p.getName());
    }

    public void removeProduct(int id) throws ProductNotFoundException {
        Iterator<Product> it = products.iterator();
        boolean found = false;
        while (it.hasNext()) {
            Product p = it.next();
            if (p.getProductId() == id) {
                it.remove();
                categoryMap.get(p.getCategory()).remove(p);
                found = true;
                System.out.println("Product removed");
                break;
            }
        }
        if (!found)
            throw new ProductNotFoundException("Product not found");
    }
}