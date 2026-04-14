package com.mayank.ims;

import java.util.Queue;

public class FIFOValuation implements ValuationStrategy {
    @Override
    public double calc(Queue<ForFIFO> q, double price, int qty3) {
        double totalquantity = 0;
        
        return totalquantity*price;
    }

	@Override
	public double calc(Queue<ForFIFO> q, double price) {
		// TODO Auto-generated method stub
		return 0;
	}
}
