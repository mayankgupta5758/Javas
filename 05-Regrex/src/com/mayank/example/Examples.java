package com.mayank.example;

import java.util.regex.*;

// Greedy quantifiers
// X?	X, once or not at all
// X*	X, zero or more times
// X+	X, one or more times
// X{n}	X, exactly n times
// X{n,}	X, at least n times
// X{n,m}	X, at least n but not more than m times
// ^	The beginning of a line
// $	The end of a line

public class Examples {

	public static void main(String[] args) {
		// Pattern pattern = Pattern.compile("a*b");// a*b - start with a end with
		// b(only one b or zero present more no. of a).
		// a*b* - start with a or many no. of a and same for b.
		// Pattern pattern = Pattern.compile("a+b*"); // one or more a zero or more b.
		Pattern pattern = Pattern.compile("a?b"); // once a or not at all.
		Matcher matcher = pattern.matcher("ab");
		boolean result = matcher.matches();
		System.out.println(result);

	}
}
