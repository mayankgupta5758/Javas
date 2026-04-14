package com.mayank.ims;

import java.util.Queue;

public interface ValuationStrategy {
    double calc(Queue<ForFIFO> q, double price);

	double calc(Queue<ForFIFO> q, double price, int qty3);
}
