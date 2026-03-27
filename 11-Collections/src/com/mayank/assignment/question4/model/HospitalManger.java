package com.mayank.assignment.question4.model;

import java.util.*;

public class HospitalManger {
	private Set<Patient> patients = new HashSet<>();
	private Set<Doctor> doctors = new HashSet<>();
	private Queue<Integer> patientsQueue = new LinkedList<>();
	private Map<Integer, List<Integer>> map = new HashMap<>();
	int patientNumber = 1;

	public void addPatient(Patient patient) {
		patient.setToken(patientNumber++);
		if (patients.add(patient)) {
			patient.setPatientStatus(PatientStatus.REGISTRED);
			System.out.println("Patient Added Successfully...");
			patientsQueue.add(patient.getToken());
			patient.setPatientStatus(PatientStatus.WATING);
			return;
		}
		System.out.println("Duplicate! Not Allowed!!!");
	}

	public void addDoctor(Doctor doctor) {
		if (doctors.add(doctor)) {
			System.out.println("Doctor Added Successfully...");
			return;
		}
		System.out.println("Duplicate! Not Allowed!!!");
	}

	public void showAllPatients() {
		if (patients.isEmpty()) {
			System.out.println("Enter Patients First!!!");
			return;
		}
		List<Patient> list = new ArrayList<>(patients);
		Collections.sort(list, new PatientComparator());
		for (Patient patient : list) {
			System.out.println("Id: " + patient.getPatientID() + " | " + "Name: " + patient.getName() + " | " + "Age: "
					+ patient.getAge() + " | " + "Token: " + patient.getToken() + " | " + "Status: " + patient.getPatientStatus());
		}
	}

	public void showAllDoctors() {
		if (doctors.isEmpty()) {
			System.out.println("Enter Patients First!!!");
			return;
		}
		for (Doctor doctor : doctors) {
			System.out.println("Id: " + doctor.getDoctorID() + " | " + "Name: " + doctor.getName() + " | " + "Age: "
					+ doctor.getAge());
		}
	}

	public void callNextPatient(int doctorId) {
		if (patientsQueue.isEmpty()) {
			System.out.println("No patients in queue.");
			return;
		}
		List<Integer> patientsForDoctor = map.get(doctorId);
		if (patientsForDoctor == null || patientsForDoctor.isEmpty()) {
			System.out.println("No Patients Allocated For Doctor " + doctorId);
			return;
		}
		int patientId = patientsForDoctor.remove(0);
		for (Patient patient : patients) {
			if (patient.getPatientID() == patientId) {
				patientsQueue.remove(patient.getToken());
				patient.setPatientStatus(PatientStatus.INCONSULTATION);
				System.out.println("Doctor " + doctorId + " is consulting Patient: " + patient.getName() + " | Token: "
						+ patient.getToken());
				return;
			}
		}
		System.out.println("Patient not found.");
	}

	public void allocateDoctorToPatient() {
		if (patients.isEmpty() || doctors.isEmpty()) {
			System.out.println("Enter Patients or Doctor!!!");
			return;
		}
		Iterator<Doctor> docIt = doctors.iterator();

		for (Patient pat : patients) {
			if (!docIt.hasNext()) {
				docIt = doctors.iterator();
			}

			Doctor doc = docIt.next();
			map.putIfAbsent(doc.getDoctorID(), new ArrayList<>());
			map.get(doc.getDoctorID()).add(pat.getPatientID());
			System.out.println("Patient " + pat.getName() + " assigned to Doctor " + doc.getDoctorID());
		}
	}

	public void dischargePatient(int patientId) {
		if(patients.isEmpty()) {
			System.out.println("Enter Patients First!!!");
			return;
		}
		for (Patient patient : patients) {
			if (patient.getPatientID() == patientId) {
				patient.setPatientStatus(PatientStatus.DISCHARGE);
				System.out.println("Patient Discharged: " + patient.getName());
				return;
			}
		}
	}

	public void removeDischargePatient() {
		if(patients.isEmpty()) {
			System.out.println("Enter Patients First!!!");
			return;
		}
		Iterator<Patient> it = patients.iterator();
		while (it.hasNext()) {
			Patient patient = it.next();
			if (patient.getPatientStatus() == PatientStatus.DISCHARGE) {
				System.out.println("Removing: " + patient.getName());
				it.remove();
			}
		}
	}

	public void removePatient(int patientID) {
		if (patients.isEmpty()) {
			System.out.println("Enter Patients First!!!");
			return;
		}
		Iterator<Patient> it = patients.iterator();
		while (it.hasNext()) {
			Patient patient = it.next();

			if (patient.getPatientID() == patientID) {
				it.remove();
				System.out.println("Patient removed successfully.");
				return;
			}
		}
		System.out.println("Patient not found.");
	}

	public void removeDoctor(int doctorID) {
		if (doctors.isEmpty()) {
			System.out.println("Enter Doctor First!!!");
			return;
		}
		Iterator<Doctor> it = doctors.iterator();
		while (it.hasNext()) {
			Doctor doctor = it.next();

			if (doctor.getDoctorID() == doctorID) {
				it.remove();
				System.out.println("Doctor removed successfully.");
				return;
			}
		}
		System.out.println("Doctor not found.");
	}
}
