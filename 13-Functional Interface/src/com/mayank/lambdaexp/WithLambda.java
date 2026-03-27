package com.mayank.lambdaexp;

@FunctionalInterface
interface MathOrps {
	int opr(int a, int b);
}

public class WithLambda {
	public static void main(String[] args) {
		MathOrps sumOrp = (a, b) -> a+b;
		System.out.println(sumOrp.opr(2, 6));
		
		MathOrps subOrp = (a, b) -> a-b;
		System.out.println(subOrp.opr(2, 6));
		
		MathOrps mulOrp = (a, b) -> a*b;
		System.out.println(mulOrp.opr(2, 6));
		
		MathOrps divOrp = (a, b) -> a/b;
		System.out.println(divOrp.opr(2, 6));
	}
}
