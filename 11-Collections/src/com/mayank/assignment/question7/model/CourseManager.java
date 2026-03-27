package com.mayank.assignment.question7.model;

import java.util.*;

public class CourseManager {
	private Set<Participant> participants = new HashSet<>();
	private Map<String, List<Participant>> batchMap = new HashMap<>();
	private Queue<Integer> waitingQueue = new LinkedList<>();

	private Participant find(int id) throws ParticipantNotFoundException {
		for (Participant p : participants) {
			if (p.getParticipantId() == id)
				return p;
		}
		throw new ParticipantNotFoundException("Participant not found");
	}

	public void register(Participant p) {
		if (participants.add(p)) {
			if (!batchMap.containsKey(p.getTrack())) {
				batchMap.put(p.getTrack(), new ArrayList<>());
			}
			batchMap.get(p.getTrack()).add(p);
			System.out.println("Participant registered");
		} else {
			System.out.println("Duplicate not allowed");
		}
	}

	public void displayAll() throws EmptyDataException {
		if (participants.isEmpty())
			throw new EmptyDataException("No participants");
		for (Participant p : participants) {
			System.out.println(p);
		}
	}

	public void displayByTrack(String track) throws EmptyDataException {
		if (!batchMap.containsKey(track))
			throw new EmptyDataException("No data for this track");
		for (Participant p : batchMap.get(track)) {
			System.out.println(p);
		}
	}

	public void sortById() {
		List<Participant> list = new ArrayList<>(participants);
		Collections.sort(list);
		for (Participant p : list) {
			System.out.println(p);
		}
	}

	public void sortByName() {
		List<Participant> list = new ArrayList<>(participants);
		Collections.sort(list, new Comparator<Participant>() {
			public int compare(Participant p1, Participant p2) {
				return p1.getName().compareTo(p2.getName());
			}
		});
		for (Participant p : list) {
			System.out.println(p);
		}
	}

	public void addToWaiting(int id) throws ParticipantNotFoundException {
		Participant p = find(id);
		if (p.getStatus() == ParticipantStatus.REGISTERED) {
			waitingQueue.offer(id);
			p.setStatus(ParticipantStatus.IN_WAITING);
			System.out.println("Added to waiting list");
		} else {
			System.out.println("Already in process or enrolled");
		}
	}

	public void enroll() throws ParticipantNotFoundException {
		if (waitingQueue.isEmpty()) {
			System.out.println("No waiting participants");
			return;
		}
		int id = waitingQueue.poll();
		Participant p = find(id);
		p.setStatus(ParticipantStatus.ENROLLED);
		System.out.println("Enrolled: " + p.getName());
	}

	public void remove(int id) throws ParticipantNotFoundException {
		Iterator<Participant> it = participants.iterator();
		boolean found = false;
		while (it.hasNext()) {
			Participant p = it.next();
			if (p.getParticipantId() == id) {
				it.remove();
				batchMap.get(p.getTrack()).remove(p);
				found = true;
				System.out.println("Removed");
				break;
			}
		}
		if (!found)
			throw new ParticipantNotFoundException("Participant not found");
	}
}