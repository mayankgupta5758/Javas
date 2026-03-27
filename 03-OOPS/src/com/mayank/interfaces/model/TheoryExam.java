package com.mayank.interfaces.model;

public class TheoryExam implements ExamEvaluator {

	private double marks;

	@Override
	public void evaluateMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String calculateGrade() {
		if (marks < 40)
			return "Fail";

		if (marks >= 75)
			return "A";
		else if (marks >= 60)
			return "B";

		return "C";
	}

	public boolean isPass() {
		return marks >= 40;
	}
}