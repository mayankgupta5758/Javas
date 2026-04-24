package com.mayank.assignment.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.mayank.assignment.model.StringUtility;

class StringUtilityTest {

	StringUtility stringUtility = new StringUtility();

//	isEmpty()

	@ParameterizedTest
	@ValueSource(strings = { "    ", "", " " })
	public void testEmptyMethodWrongInput(String str) {
		assertTrue(stringUtility.isEmpty(str));
	}

	@ParameterizedTest
	@ValueSource(strings = { "  null  ", "null", " o" })
	public void testEmptyMethodValidInput(String str) {
		assertFalse(stringUtility.isEmpty(str));
	}
	/*
	 * @Test public void testIsEmptyNormalString() {
	 * assertFalse(stringUtility.isEmpty("null")); }
	 * 
	 * @Test public void testIsEmptyWhiteSpaces() {
	 * assertFalse(stringUtility.isEmpty("       ")); }
	 * 
	 * @Test public void testIsEmptyOfNoLength() {
	 * assertTrue(stringUtility.isEmpty("")); }
	 */

	@ParameterizedTest
	@NullSource
	void testIsEmptyNull(String input) {
		assertTrue(stringUtility.isEmpty(input));
	}
	/*
	 * @Test public void testIsEmptyNull() {
	 * assertTrue(stringUtility.isEmpty(null)); }
	 */

//	toUpperCase()

	@ParameterizedTest
	@NullSource
	void testToUpperCaseNull(String input) {
		assertNull(stringUtility.toUpperCase(input));
	}
	/*
	 * @Test public void testToUpperCaseNullString() {
	 * assertNull(stringUtility.toUpperCase(null)); }
	 */

	@ParameterizedTest
	@CsvSource({ "  NULL  , NULL", " O, O" })
	public void testToUpperCaseMethodValidInput(String str, String res) {
		assertEquals(res, stringUtility.toUpperCase(str));
	}

	@ParameterizedTest
	@CsvSource({ "  n  ,N", " Os, OS", " AvScDgRh  , AVSCDGRH" })
	public void testToUpperCaseMethodWrongInput(String str, String res) {
		assertEquals(res, stringUtility.toUpperCase(str));
	}
	/*
	 * @Test public void testToUpperCaseNormalUpperCaseString() {
	 * assertEquals("NULL", stringUtility.toUpperCase("NULL")); }
	 * 
	 * @Test public void testToUpperCaseNoLength() { assertEquals("",
	 * stringUtility.toUpperCase("")); }
	 * 
	 * @Test public void testToUpperCaseWhiteSpaces() { assertEquals("   ",
	 * stringUtility.toUpperCase("   ")); }
	 * 
	 * @Test public void testToUpperCaseInputMixedString() { assertEquals("AGDGDD",
	 * stringUtility.toUpperCase("AGdGdD")); }
	 */

//	getLength()

	@ParameterizedTest
	@NullSource
	public void testGetLengthNull(String input) {
		assertEquals(0, stringUtility.getLength(input));
	}
	/*
	 * @Test public void testGetLengthNull() { assertEquals(0,
	 * stringUtility.getLength(null)); }
	 */

	
	@ParameterizedTest
	@CsvSource({
		"4, null", "0, ", "0,    "
	})
	public void testGetLengthMixedInput(int res, String str) {
		assertEquals(res, stringUtility.getLength(str));
	}
	/*
	 * @Test public void testGetLengthNullString() { assertEquals(4,
	 * stringUtility.getLength("null")); }
	 * 
	 * @Test public void testGetLengthNoLength() { assertEquals(0,
	 * stringUtility.getLength("")); }
	 * 
	 * @Test public void testGetLengthWhiteSpacesString() { assertEquals(0,
	 * stringUtility.getLength("    ")); }
	 */

}
