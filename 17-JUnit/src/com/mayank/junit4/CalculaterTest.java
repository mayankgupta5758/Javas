package com.mayank.junit4;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class CalculaterTest {
	
	@BeforeClass
	public static void initi() {
		System.out.println("Before all test cases.");
		System.out.println("Started time: "+ new Date());
	}
	
	@AfterClass
	public static void cleanUp() {
		System.out.println("Run After all test case.");
		System.out.println("End time: "+ new Date());
	}
	
	@Before
	public void beforeEach() {
		System.out.println("Before each test case.");
	}
	
	@After
	public void afterEach() {
		System.out.println("After each test case.");
	}

	@Test // yaha se testing exceute hogi
	public void sum() {
		System.out.println("Test for sum");
		Intro i = new Intro(); // triple A pattern called line 42 to 46. arrange, annotations, assert
		int res = i.sum(3,4);
		int ex = 7;
		
		Assert.assertEquals(res, ex); // to check
	}
	
//	@Test
	@Test(timeout = 2000)
	public void sumAnyNum() {
		System.out.println("Test for sumAnyNum");
		Intro i = new Intro();
		int res = i.sumAnyNum(1,2,3,4,5,6);
		int ex = 21;
		
		Assert.assertEquals(res, ex);
	}

}
