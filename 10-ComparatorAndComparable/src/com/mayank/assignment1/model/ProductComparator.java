package com.mayank.assignment1.model;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {

		int categorySort = p1.category.compareTo(p2.category);

		if (categorySort != 0)
			return categorySort;

		return Double.compare(p1.price, p2.price);
	}
}