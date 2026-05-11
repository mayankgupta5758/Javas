package model;

public class Course {

	private int cId;
	private String cName;
	private String duration;
	private double fees;
	private String trainerName;

	public Course(String cName, String duration, double fees, String trainerName) {
		this.cName = cName;
		this.duration = duration;
		this.fees = fees;
		this.trainerName = trainerName;
	}

	public Course(int cId, String cName, String duration, double fees, String trainerName) {
		this.cId = cId;
		this.cName = cName;
		this.duration = duration;
		this.fees = fees;
		this.trainerName = trainerName;
	}

	public int getcId() {
		return cId;
	}

	public String getcName() {
		return cName;
	}

	public String getDuration() {
		return duration;
	}

	public double getFees() {
		return fees;
	}

	public String getTrainerName() {
		return trainerName;
	}
}