package com.mayank.assignment;

public class MultipleCatchBlocks {
	
	public static void multipleCatch() {
		String[] array = new String[2];
		
		try {
			System.out.println(array[5]);
			System.out.println(array[1].length());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("can not access element more than array length");
		} catch (NullPointerException e) {
			System.out.println("Can not access null String length.");
		}
	}

	public static void main(String[] args) {
		multipleCatch();
	}

}
