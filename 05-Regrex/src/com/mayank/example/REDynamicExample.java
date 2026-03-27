 package com.mayank.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REDynamicExample {
    public static void checkStringAgainstRE(String re, String str) {
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(str);
        boolean result = matcher.matches();
        System.out.println("result: " + result);
    }

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter Regular Expression: ");
        // String re = scanner.nextLine();

        // System.out.println("Enter input String: ");
        // String str = scanner.nextLine();
        // checkStringAgainstRE(re, str);
        // checkStringAgainstRE("[a-z]", "adt"); // single char, from a to z.
        // checkStringAgainstRE("[a-zA-Z]", "a"); // single char, from a to z or from A
        // to Z true aG false.
        // checkStringAgainstRE("[a-zA-Z]+", "abcABGaYqC"); // one or more check karega.
        // true.

        // Q1. Write RE for alpha numeric charcter.
        // checkStringAgainstRE("[a-zA-Z0-9]+", "jghhtAdsfgDFGJHK08TGY5Tm");
        // checkStringAgainstRE("[a-zA-Z0-9#]+", "jghhtAdsfgDFGJHK08TGY5Tm");

        // Q2. Write RE for 10 digit number only.
        // checkStringAgainstRE("[0-9]{10}", "1234567890");
        // checkStringAgainstRE("^[0-9]{10}$", "0123456789");
//         checkStringAgainstRE("^[1-9][0-9]{9}$", "102456789"); // first digit 0 nahi
        // hogi.

        // Q3. mathch a email address.
        // checkStringAgainstRE("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
        // "text@gmail.com");
        // | Symbol | Meaning |
        // | ------ | ----------------- |
        // | `.` | koi bhi character |
        // | `\.` | sirf dot |

    }
}
