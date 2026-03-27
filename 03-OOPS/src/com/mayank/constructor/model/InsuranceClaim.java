package com.mayank.constructor.model;

public class InsuranceClaim {

    private static int counter = 1000;

    private final int claimId;
    private String policyNumber;
    private double claimAmount;
    private String status;
    private double approvedAmount;

    // Private default constructor (invalid object prevent)
    private InsuranceClaim() {
        this.claimId = ++counter;
    }

    // Parameterized constructor
    public InsuranceClaim(String policyNumber, double claimAmount) {

        if (policyNumber == null || policyNumber.isEmpty())
            throw new IllegalArgumentException("Policy number cannot be empty");

        if (claimAmount < 0)
            throw new IllegalArgumentException("Claim amount cannot be negative");

        this.claimId = ++counter;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.status = "Filed";
        this.approvedAmount = 0;
    }

    public int getClaimId() {
        return claimId;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }
}
