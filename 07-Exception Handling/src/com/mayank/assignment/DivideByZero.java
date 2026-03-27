package com.mayank.assignment;
import java.util.*;

public class DivideByZero {

    public static void divideByZero() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            int number1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int number2 = scanner.nextInt();
//            if (number2 == 0) {
//            	System.out.println("Enter non zero only.");
//                throw new ArithmeticException("Cannot divide by zero");
//            }

            double ans = (double) number1 / number2;
            System.out.println("The result is: " + ans);
        } catch (InputMismatchException e) {
            System.out.println("Please enter integers only.");
        } 
//        catch (ArithmeticException e) {
//            System.out.println("Cannot divide by zero.");
//        }
    }

    public static void main(String[] args) {
        divideByZero();
    }
}