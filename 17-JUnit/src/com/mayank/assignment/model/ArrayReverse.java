package com.mayank.assignment.model;

public class ArrayReverse {

	public int[] reverseArray(int[] arr) {
		if (arr == null) {
			throw new IllegalArgumentException("Array cannot be null");
		}

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;

			left++;
			right--;
		}
		return arr;
	}

}
