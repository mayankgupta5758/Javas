package com.mayank.assignment.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.*;
import com.mayank.assignment.model.ArrayReverse;

class ArrayReverseTest {
	
	ArrayReverse arrayReverse = new ArrayReverse();

//	arrayReverse()
	
	@ParameterizedTest
	@MethodSource("data")
	public void testArrayReverse(int[] arr1, int[] arr2) {
		assertArrayEquals(arr1, arrayReverse.reverseArray(arr2));
	}
	
	static Stream<Arguments> data() {
		return Stream.of(
		        Arguments.of(null, null),
		        Arguments.of(new int[]{}, new int[]{}),
		        Arguments.of(new int[] {1}, new int[]{1}),
		        Arguments.of(new int[] {1,2,3,4},new int[] {1,2,3,4}
		        )
		    );
	}
	
//	@Test
//	public void testArrayReverseNullArray() {
//		assertArrayEquals(null, arrayReverse.reverseArray(null));
//	}
//	
//	@Test
//	public void testArrayReverseEmptyArray() {
//		assertArrayEquals(new int[] {}, arrayReverse.reverseArray(new int[] {}));
//	}
//	
//	@Test
//	public void testArrayOneElementOnly() {
//		assertArrayEquals(new int[] {1}, arrayReverse.reverseArray(new int[] {1}));
//	}
//	
//	@Test
//	public void testArrayMixedElement() {
//		assertArrayEquals(new int[] {1,2,3,4}, arrayReverse.reverseArray(new int[] {4,3,2,1}));
//	}
}
