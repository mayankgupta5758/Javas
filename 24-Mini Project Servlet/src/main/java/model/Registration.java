package model;

import java.sql.Date;

public class Registration {

	private int registrationId;
	private int studentId;
	private int courseId;
	private Date registrationDate;
	private String status;

	public Registration(int studentId, int courseId, Date registrationDate, String status) {
		this.studentId = studentId;
		this.courseId = courseId;
		this.registrationDate = registrationDate;
		this.status = status;
	}

	public Registration(int registrationId, int studentId, int courseId, Date registrationDate, String status) {
		this.registrationId = registrationId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.registrationDate = registrationDate;
		this.status = status;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public int getStudentId() {
		return studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public String getStatus() {
		return status;
	}
}