package com.mayank.interfaces.model;

public class OnlineQuiz implements ExamEvaluator {

	private double marks;

	@Override
	public void evaluateMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String calculateGrade() {
		if (marks < 35)
			return "Fail";

		if (marks >= 90)
			return "A+";
		else if (marks >= 70)
			return "A";
		else if (marks >= 50)
			return "B";

		return "C";
	}

	public boolean isPass() {
		return marks >= 35;
	}
}