package com.mayank.assignmentquestion;

import java.util.Scanner;

public class DetectBalancedBrackets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();

        char[] arr = new char[str.length()];
        int top = -1;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                arr[++top] = ch;  
            } else if(ch == ')' || ch == '}' || ch == ']') {
                if(top == -1) {
                    System.out.println("Not Balanced");
                    return;
                }
                char last = arr[top--]; 
                if((ch == ')' && last != '(') ||
                   (ch == '}' && last != '{') ||
                   (ch == ']' && last != '[')) {
                    System.out.println("Not Balanced");
                    return;
                }
            }
        }

        if(top == -1)
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
	}

}
