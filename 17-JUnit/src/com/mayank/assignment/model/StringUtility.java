package com.mayank.assignment.model;

public class StringUtility {
	
	public boolean isEmpty(String str) {
	    return str == null || str.trim().isEmpty();
	}
	
	public String toUpperCase(String str) {
		if(str == null) return null;
		return str.toUpperCase();
	}
	
	public int getLength(String str) {
		if(str == null) return 0;
		return str.length();
	}
}
