import java.util.Scanner;

public class ReduceElseBlock {
	
	public static void withdrawUsingIfElse(double balance, double amount) {
	    if (amount > 0) {
	        if (amount <= balance) {
	            balance -= amount;
	            System.out.println("Your remaining balance is: " + balance);
	        } else {
	            System.out.println("Insufficient balance");
	        }
	    } else {
	        System.out.println("Invalid amount");
	    }
	}
	
	public static void withdrawUsingIfOnly(double balance, double amount) {
	    if (amount <= 0) {
	        System.out.println("Enter Positive mount");
	        return;
	    }

	    if (amount > balance) {
	        System.out.println("Insufficient balance");
	        return;
	    }

	    balance -= amount;
	    System.out.println("Your remaining balance is: " + balance);
	}
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the balance: ");
		double balance = scanner.nextDouble();
		
		System.out.println("Enter the amount: ");
		double amount = scanner.nextDouble();
		
		withdrawUsingIfElse(balance, amount);
		
		withdrawUsingIfOnly(balance, amount);
		scanner.close();
	}

}
