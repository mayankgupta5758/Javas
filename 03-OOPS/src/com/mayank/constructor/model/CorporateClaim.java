package com.mayank.constructor.model;

public class CorporateClaim extends InsuranceClaim {

    private double processingFee;

    public CorporateClaim(String policyNumber, double claimAmount, double processingFee) {

        super(policyNumber, claimAmount);   // Parent constructor call

        if (processingFee < 0)
            throw new IllegalArgumentException("Processing fee cannot be negative");

        this.processingFee = processingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }
}