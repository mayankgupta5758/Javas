package com.mayank.assignment.question3.model;

import java.util.*;

public class StudentRecordManager {
	private Set<Student> students = new HashSet<>();
	private HashMap<Integer, List<SubjectMarks>> studentMarks = new HashMap<>();

	public void addStudent(Student student) {
		student.setTotalPercentage(percentageCalculate(student.getStudentId()));
		if (students.add(student)) {
			System.out.println("Student Added Successfully...");
			return;
		}
		System.out.println("Duplicate Student Id not Allowed!!!");
		System.out.println("--------------------------------------------------------------------");
	}

	public void removeStudent(int studentId) {
		if (students.isEmpty()) {
			System.out.println("Enter Students First.");
			return;
		}

		Student student = findStudentWithId(studentId);
		if (students.remove(student)) {
			studentMarks.remove(student.getStudentId());
			System.out.println("Student With this Student Id is Removed...");
			return;
		}
		System.out.println("Student Not Found With this Student Id...");
		System.out.println("--------------------------------------------------------------------");
	}

	public Student findStudentWithId(int studentId) {
		if (students.isEmpty()) {
			System.out.println("Enter Student First.");
			return null;
		}

		for (Student std : students) {
			if (std.getStudentId() == studentId) {
				return std;
			}
		}
		System.out.println("Student Id not Found.");
		System.out.println("--------------------------------------------------------------------");
		return null;
	}

	public void addSubjectMarks(int id, List<SubjectMarks> subjectsMarks) {
		if (subjectsMarks == null) {
			System.out.println("Enter Valid Name And Subject Marks.");
			return;
		}

		studentMarks.put(id, subjectsMarks);
		System.out.println("Marks Added Successfully.");
	}

	public void showAllStudentMarks() {
		if (students.isEmpty()) {
			System.out.println("Enter Students First.");
			return;
		}

		for (Integer studentId : studentMarks.keySet()) {
			System.out.println("-----------------");
			String name = getNameById(studentId);
			if (name == null)
				return;
			System.out.println("Name: " + name);
			for (SubjectMarks sm : studentMarks.get(studentId)) {
				System.out.println(sm.subjectName + " " + sm.subjectMarks);
			}
		}
		System.out.println("--------------------------------------------------------------------");
	}

	private String getNameById(Integer studentId) {
		for (Student student : students) {
			if (student.getStudentId() == studentId) {
				return student.getName();
			}
		}
		System.out.println("--------------------------------------------------------------------");
		return null;
	}

	public double percentageCalculate(int id) {
		List<SubjectMarks> list = studentMarks.get(id);
		double totalMarks = 0;
		for (SubjectMarks sm : list) {
			totalMarks += sm.subjectMarks;
		}
		return totalMarks / list.size();
	}

	public void eligibilityCondition() {
		if (students.isEmpty()) {
			System.out.println("Enter Students First.");
			return;
		}

		Iterator<Student> it = students.iterator();
		while (it.hasNext()) {
			Student std = it.next();
			if (std.getTotalPercentage() <= 60) {
				System.out.println("Removing Student: " + std.getName() + " | Percentage: " + std.getTotalPercentage());
				it.remove();
				studentMarks.remove(std.getStudentId());
			}
		}
		System.out.println("--------------------------------------------------------------------");
	}

	public void showStudentGroupByDepartment(String department) {
		if (students.isEmpty()) {
			System.out.println("Enter Students First.");
			return;
		}

		for (Student student : students) {
			if (student.getDepartment().equalsIgnoreCase(department)) {
				System.out.println("ID: " + student.getStudentId() + " | Name: " + student.getName() + " | Department: "
						+ student.getDepartment() + " | Percentage: " + student.getTotalPercentage());
			}
		}
		System.out.println("--------------------------------------------------------------------");
	}

	public void seeSortedResult() {
		if (students.isEmpty()) {
			System.out.println("Enter Students First.");
			return;
		}

		List<Student> list = new ArrayList<>(students);
		Collections.sort(list, new StudentComparator());

		for (Student student : list) {
			System.out.println("ID: " + student.getStudentId() + " | Name: " + student.getName() + " | Department: "
					+ student.getDepartment() + " | Percentage: " + student.getTotalPercentage());
		}
		System.out.println("--------------------------------------------------------------------");
	}

}