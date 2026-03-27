package com.mayank.lambdaexp;

@FunctionalInterface
interface MathOpr {
	int opr(int a, int b);
}

class SumOpr implements MathOpr {

	@Override
	public int opr(int a, int b) {
		return a+b;
	}
	
}
class SubOpr implements MathOpr {

	@Override
	public int opr(int a, int b) {
		return a-b;
	}
	
}

public class WithoutLambda {
	public static void main(String[] args) {
		SumOpr sumo = new SumOpr();
		System.out.println(sumo.opr(2, 4));
	}
}
