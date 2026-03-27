package com.mayank.assignment1.model;

import java.util.Comparator;

public class TransactionComparator implements Comparator<Transaction> {

	@Override
	public int compare(Transaction t1, Transaction t2) {
		int amountSort = Double.compare(t2.amount, t1.amount);

		if (amountSort != 0)
			return amountSort;

		return t1.id - t2.id;
	}
}