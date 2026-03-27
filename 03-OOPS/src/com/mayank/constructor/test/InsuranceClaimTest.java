package com.mayank.constructor.test;

	import java.util.Scanner;
	import com.mayank.constructor.model.InsuranceClaim;
	import com.mayank.constructor.model.CorporateClaim;

	public class InsuranceClaimTest {

	    public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);
	        InsuranceClaim claim = null;

	        System.out.println("Enter Policy Number: ");
	        String policyNumber = scanner.nextLine();

	        System.out.println("Enter Claim Amount: ");
	        double claimAmount = scanner.nextDouble();

	        System.out.println("Press 1 for Corporate Claim or 2 for Normal Claim:");

	        boolean validChoice = false;

	        while (!validChoice) {

	            int choice = scanner.nextInt();

	            try {

	                if (choice == 1) {

	                    System.out.println("Enter Processing Fee: ");
	                    double fee = scanner.nextDouble();

	                    claim = new CorporateClaim(policyNumber, claimAmount, fee);
	                    System.out.println("Corporate Claim Created Successfully.");
	                    validChoice = true;

	                } else if (choice == 2) {

	                    claim = new InsuranceClaim(policyNumber, claimAmount);
	                    System.out.println("Normal Claim Created Successfully.");
	                    validChoice = true;

	                } else {
	                    System.out.println("Invalid choice. Enter 1 or 2.");
	                }

	            } catch (IllegalArgumentException e) {
	                System.out.println("Error: " + e.getMessage());
	                return;
	            }
	        }

	        System.out.println("\n--- Claim Details ---");
	        System.out.println("Claim ID: " + claim.getClaimId());
	        System.out.println("Claim Amount: " + claim.getClaimAmount());
	        System.out.println("Status: " + claim.getStatus());
	        System.out.println("Approved Amount: " + claim.getApprovedAmount());

	        scanner.close();
	    }
	}