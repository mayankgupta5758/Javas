package com.mayank.encapsulation.model;


public class InsuranceClaim {
	public enum ClaimStatus {
		FILED, APPROVED, REJECTED, SETTLED
	}

	private static int counter = 1000;

	private final String claimId;
	private final int policyNumber;
	private final double claimAmount;

	private double approvedAmount;
	private ClaimStatus claimStatus;

	public InsuranceClaim(int policyNumber, double claimAmount) {

		if (claimAmount <= 0) {
			throw new IllegalArgumentException("Claim amount must be positive");
		} else {

			this.claimId = "C" + counter++;
			this.policyNumber = policyNumber;
			this.claimAmount = claimAmount;
			this.claimStatus = ClaimStatus.FILED;
		}
	}

	public String getClaimId() {
		return claimId;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public double getApprovedAmount() {
		return approvedAmount;
	}

	public ClaimStatus getClaimStatus() {
		return claimStatus;
	}

	public void approveClaim(double amount) {

		ensureNotSettled();

		if (claimStatus != ClaimStatus.FILED) {
			System.out.println("Only FILED claims can be approved");
			if (amount <= 0 || amount > claimAmount) {
				System.out.println("Invalid approved amount");
			} else {
				this.approvedAmount = amount;
				this.claimStatus = ClaimStatus.APPROVED;
			}
		}
	}

	public void rejectClaim() {

		ensureNotSettled();

		if (claimStatus != ClaimStatus.FILED) {
			System.out.println("Only FILED claims can be rejected");
		} else {
			this.claimStatus = ClaimStatus.REJECTED;
		}
	}

	public void settleClaim() {

		ensureNotSettled();

		if (claimStatus == ClaimStatus.FILED) {
			System.out.println("Cannot settle directly from FILED");
		} else {
			this.claimStatus = ClaimStatus.SETTLED;
		}
	}

	private void ensureNotSettled() {
		if (claimStatus == ClaimStatus.SETTLED) {
			System.out.println("Claim already settled. No further modification allowed.");
		}
	}
}
