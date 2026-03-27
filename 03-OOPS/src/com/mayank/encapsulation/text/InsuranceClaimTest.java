package com.mayank.encapsulation.text;

import java.util.Scanner;

import com.mayank.encapsulation.model.InsuranceClaim;


public class InsuranceClaimTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("How many claims you want to create: ");
        int n = sc.nextInt();

        InsuranceClaim[] claims = new InsuranceClaim[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Claim " + (i + 1));

            System.out.print("Enter Policy Number: ");
            int policyNumber = sc.nextInt();

            System.out.print("Enter Claim Amount: ");
            double claimAmount = sc.nextDouble();

            try {
                claims[i] = new InsuranceClaim(policyNumber, claimAmount);
                System.out.println("Claim Created Successfully!");
                System.out.println("Claim ID: " + claims[i].getClaimId());
                System.out.println("Status: " + claims[i].getClaimStatus());
            } 
            catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                i--; 
            }
        }

        sc.close();
    }
}
