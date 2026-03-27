package com.mayank.interfaces.model;

public class PracticalExam implements ExamEvaluator {

	private double marks;

	@Override
	public void evaluateMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String calculateGrade() {
		if (marks < 50)
			return "Fail";

		if (marks >= 85)
			return "A+";
		else if (marks >= 70)
			return "A";

		return "B";
	}

	public boolean isPass() {
		return marks >= 50;
	}
}