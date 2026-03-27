package com.mayank.assignment.question5.model;

public abstract class Passenger {

	protected int passengerId;
	protected String name;
	protected int routeNumber;
	protected PassengerStatus status;

	public Passenger(int passengerId, String name, int routeNumber) {
		this.passengerId = passengerId;
		this.name = name;
		this.routeNumber = routeNumber;
		this.status = PassengerStatus.REGISTERED;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public String getName() {
		return name;
	}

	public int getRouteNumber() {
		return routeNumber;
	}

	public PassengerStatus getStatus() {
		return status;
	}

	public void setStatus(PassengerStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Passenger Id: " + passengerId + " | " + "Name: " + name + " | Route: " + routeNumber + " | Status: "
				+ status;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Passenger))
			return false;
		Passenger p = (Passenger) obj;
		return this.passengerId == p.passengerId;
	}

	@Override
	public int hashCode() {
		return passengerId;
	}
}